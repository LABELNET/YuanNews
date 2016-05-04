package yuan.ssm.datacenter.base;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import yuan.ssm.common.util.LoggerUtil;

import java.io.IOException;
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
 * 创建日期：　16-5-4 下午1:08
 * <p/>
 * 功能描述： 主页数据加载的抽象类
 * 1.返回urls
 * 2.
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public abstract class LoaderBase {

    private String url=null;


    public LoaderBase(String url) {
        this.url = url;
    }

    protected Document getDoc(){
        try {
            return Jsoup.connect(url).timeout(200000).get();
        } catch (IOException e) {
            LoggerUtil.printJSON("LoaderBase  getDoc Exception Url : "+url);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取某个新闻来源上的主页urls
     * @return url集合
     */
    protected abstract List<String> getUrls();

    /**
     * 获取某个新闻来源的类型
     * @return 来源类型
     */
    protected abstract SourceEnum getType();

}
