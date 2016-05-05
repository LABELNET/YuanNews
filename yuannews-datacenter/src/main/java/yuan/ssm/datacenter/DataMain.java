package yuan.ssm.datacenter;

import yuan.ssm.datacenter.LoadUtil.HuxiuLoader;
import yuan.ssm.datacenter.base.ThreadPoolHttpClient;
import yuan.ssm.datacenter.datasource.HuxiuSource;

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




    public static void main(String [] args) throws IOException, InterruptedException {

        getData(HuxiuSource.getHuxiuIndexUrl(),"虎嗅主页");//虎嗅主页爬取

    }

    /**
     * 多个页面爬去获取
     * @param urls
     */
    private static synchronized void getData(List<String> urls,String source){
        for (String url : urls){
            getData(urls,source);
        }
    }

    /**
     * 总的爬去方法
     * @param url
     */
    private static synchronized void getData(String url,String source) {
        //1.实现主页加载类
        HuxiuLoader huxiuLoader=new HuxiuLoader(url);

        //2.实现线程池
        ThreadPoolHttpClient threadPoolHttpClient=new ThreadPoolHttpClient(huxiuLoader,source);

        //3.执行开始操作
        threadPoolHttpClient.start();
    }


}
