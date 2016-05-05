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
    private static final String HUXIUURL="http://www.huxiu.com";//主页

    //虎嗅-车行
    private static final String HUXIUURL_CAR="http://www.huxiu.com/mobility.html";//车与出行

    //虎嗅-24小时
    private static final String HUXIU_TIME="http://www.huxiu.com/whatsnew.html";//24小时

    //虎嗅-娱乐影视
    private static final String HUXIU_YU="http://www.huxiu.com/entertainment.html";//娱乐淘金

    //虎嗅-创业
    private static final String HUXIU_CHUANG="http://www.huxiu.com/startups.html";//创业维艰

    //虎嗅-生活
    private static final String HUXIU_SHUENGHUO="http://www.huxiu.com/lifestyle.html";//生活腔调


    public static void main(String [] args) throws IOException, InterruptedException {
        //总调度类
        DataMain dataMain=new DataMain();


        dataMain.getHuxiuIndexData();
        //虎嗅-分类爬去
//        dataMain.getHuxiuCateData();


    }


    /**
     * 其余的爬取主页数据即可
     */
    private void getHuxiuIndexData(){
        getData(HUXIUURL);
    }

    /**
     * 虎嗅-首次爬去，可以爬取分类信息
     */
    private void getHuxiuCateData(){
        getData(HUXIUURL_CAR);
        getData(HUXIU_TIME);
        getData(HUXIU_CHUANG);
        getData(HUXIU_YU);
        getData(HUXIU_SHUENGHUO);
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


    /**
     * 总的爬去方法
     * @param url
     */
    private synchronized void getData(String url) {
        //1.实现主页加载类
        HuxiuLoader huxiuLoader=new HuxiuLoader(url);

        //2.实现线程池
        ThreadPoolHttpClient threadPoolHttpClient=new ThreadPoolHttpClient(huxiuLoader);

        //3.执行开始操作
        threadPoolHttpClient.start();
    }


}
