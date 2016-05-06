package yuan.ssm.datacenter.ParseUtil;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.datacenter.common.UrlsContanst;

import java.util.HashSet;
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
 * 创建日期：　16-5-4 下午2:55
 * <p/>
 * 功能描述：
 * 1.功能唯一，解析各个网站的主页内容；一个网站主页对应一个解析静态方法；
 * 2.返回值唯一 ： List<String> urls</>
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class ParseIndex {

    /**
     * 解析虎嗅主页的新闻链接
     * @param doc 主页新闻对象
     * @return Set<String> 去重url
     */
    public synchronized static Set<String> getHuXiuPageUrls(Document doc){
        Set<String> urls=new HashSet<String>();
        Elements as = doc.select("a");
        for (Element a:as) {
            String href = a.attr("href");
            if(href.contains("/1.html") ){
                int i = href.indexOf("?");
                if(i>0) {
                    href = href.substring(0,i);
                }
                String url= UrlsContanst.HUXIU_BASE_URL+href;
                urls.add(url);
                LoggerUtil.printJSON(url);
            }
        }
        return urls;
    }

    /**
     * 解析环球网 新闻主页，返回详情页地址urls
     * @param doc html对象
     * @return urls
     */
    public synchronized static Set<String> getHuanQiuUrls(Document doc){
        Set<String> urls=new HashSet<String>();
        Elements as = doc.select("a");
        for (Element a:as){
            String href=a.attr("href").trim();
            //过滤url
            if(href.contains("huanqiu.com") && href.contains("2016") && href.contains(".html") && !href.startsWith("http://v") && !href.startsWith("!http://photo")){
                int i = href.indexOf("#");
                if(i>0) {
                    href = href.substring(0,i);
                }
                urls.add(href);
            }
        }
        LoggerUtil.print("　主页url已经遍历完毕！　");
        return urls;
    }


    /**
     * 解析中国新闻网主页，返回详情页urls
     * @param doc html对象
     * @return urls
     */
    public synchronized static Set<String> getChinaNewsUrls(Document doc){
        Set<String> urls=new HashSet<String>();
        Elements as = doc.select("a");
        for (Element a:as){
            String href=a.attr("href").trim();
            if(!href.contains("http://")){
                urls.add(href);
            }
        }
        LoggerUtil.print("　主页url已经遍历完毕！　");
        return urls;
    }

}
