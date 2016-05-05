package yuan.ssm.datacenter.datasource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.datacenter.ParseUtil.ParseIndex;

import java.io.IOException;
import java.util.Set;

/**
 * ==================================================
 * <p/>
 * 版权：　软件工程.net12-1 原明卓
 * <p/>
 * 项目：　基于用户兴趣标签的新闻推荐系统
 * <p/>
 * 作者：　原明卓
 * <p/>
 * 版本：　1.0
 * <p/>
 * 创建日期：　16-5-5 下午1:33
 * <p/>
 * 功能描述： 环球url数据与测试
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class HuanQiuSource {


    //环球网：主页
    private static final String HuanQiuUrl="http://huanqiu.com";

    public static String getHuanQiuIndexUrl(){
        return HuanQiuUrl;
    }

    public static void testHuanQiuIndexPage() throws IOException {
        Document doc = Jsoup.connect(HuanQiuUrl).timeout(100000).get();
        Set<String> qiuUrls = ParseIndex.getHuanQiuUrls(doc);
        LoggerUtil.printJSON(qiuUrls);
    }

}
