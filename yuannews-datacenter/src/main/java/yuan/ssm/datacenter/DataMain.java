package yuan.ssm.datacenter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.datacenter.LoadUtil.HuxiuLoader;
import yuan.ssm.datacenter.base.ThreadPoolHttpClient;
import yuan.ssm.datacenter.common.UrlsContanst;

import java.io.IOException;
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
 * 创建日期：　16-5-4 上午9:59
 * <p/>
 * 功能描述： TODO 总执行操作类
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class DataMain {

    //环球网
    private static final String HuanQiuUrl="http://huanqiu.com";

    //虎嗅网
    private static final String HUXIUURL="http://www.huxiu.com";

    public static void main(String [] args) throws IOException {
       //总调度类
        getData(HUXIUURL);



        //测试虎嗅主页
//        testHuXiuIndexPage();
    }

    private static void getData(String url) {
        //1.实现主页加载类
        HuxiuLoader huxiuLoader=new HuxiuLoader(HUXIUURL);

        //2.实现线程池
        ThreadPoolHttpClient threadPoolHttpClient=new ThreadPoolHttpClient(huxiuLoader);

        //3.执行开始操作
        threadPoolHttpClient.start();
    }


    private static void testHuXiuIndexPage() throws IOException {
        Document doc = Jsoup.connect(HUXIUURL).timeout(100000).get();
        Set<String> urls=new HashSet<String>();
        Elements as = doc.select("a");
        for (Element a : as) {
            String href = a.attr("href");
            if(href.contains("/1.html")){
                String url= UrlsContanst.HUXIU_BASE_URL+href;
                urls.add(url);
            }
        }
        LoggerUtil.printJSON(urls);
    }
}
