package yuan.ssm.datacenter.ParseUtil;

import org.apache.commons.io.FileUtils;
import org.jsoup.select.Elements;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.datacenter.base.ParserBase;
import yuan.ssm.vo.NewsVo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
 * 创建日期：　16-5-4 下午1:52
 * <p/>
 * 功能描述： 虎嗅网内容解析类
 * 1.解析主页
 * 2.解析内容页
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class HuxiuParser extends ParserBase{


    /**
     * 初始化
     * @param inputStream 数据流
     * @param url 当前url
     */
    public HuxiuParser(InputStream inputStream, String url) {
        super(inputStream, url);
    }

    /**
     * 解析操作
     * @return
     */
    protected NewsVo parserDetailPage() {

        List<String> yuliao= new ArrayList<String>();
        Elements title= doc.select("title");//主题
        String str = title.first().text().replace("-看点-@虎嗅网", "").
                replace("-观点-@虎嗅网", "").replace("-读点-@虎嗅网", "");
        System.out.println("title： "+str);
        Elements userAndTime = doc.select(".author-name");   // 发帖时间
        Elements content= doc.select("#article_content");//内容
        if(str.contains("提示信息 - 虎嗅网"))
        {
            LoggerUtil.printJSON("HuxiuParser parserDetail : 文章被删除 ");
            return null;
        }
        yuliao.add(str);
        yuliao.add(url);
        yuliao.add(userAndTime.get(0).select(".fc1").text());
        yuliao.add(userAndTime.get(1).text());
        yuliao.add(content.get(0).text());
        File file = new File("/mnt/JAVA/tomcatImageServer/ids/"+str+".txt");
        try {
            FileUtils.writeLines(file, yuliao);
        } catch (IOException e) {
            LoggerUtil.printJSON("HuxiuParser parserDetail : FileUtils  IOException");
            e.printStackTrace();
        }
        yuliao.clear();

        return null;
    }


}
