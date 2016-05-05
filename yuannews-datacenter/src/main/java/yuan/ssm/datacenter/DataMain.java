package yuan.ssm.datacenter;

import yuan.ssm.datacenter.LoadUtil.HuanQiuLoader;
import yuan.ssm.datacenter.LoadUtil.HuxiuLoader;
import yuan.ssm.datacenter.base.ThreadPoolHttpClient;
import yuan.ssm.datacenter.datasource.HuanQiuSource;

import java.io.IOException;

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

//        getHuXiuData(HuxiuSource.getHuxiuIndexUrl(),"虎嗅主页");//虎嗅主页爬取

        getHuanQiuData(HuanQiuSource.getHuanQiuIndexUrl(),"环球网主页"); //环球网主页爬取


    }

    /**
     * 虎嗅的数据爬去方法
     * @param url
     */
    private static synchronized void getHuXiuData(String url,String source) {
        //1.实现主页加载类
        HuxiuLoader huxiuLoader=new HuxiuLoader(url);

        //2.实现线程池
        ThreadPoolHttpClient threadPoolHttpClient=new ThreadPoolHttpClient(huxiuLoader,source);

        //3.执行开始操作
        threadPoolHttpClient.start();
    }


    /**
     * 环球的数据爬去方法
     * @param url
     * @param source
     */
    private static synchronized void getHuanQiuData(String url,String source) {
        //1.实现主页加载类
        HuanQiuLoader huanQiuLoader=new HuanQiuLoader(url);

        //2.实现线程池
        ThreadPoolHttpClient threadPoolHttpClient=new ThreadPoolHttpClient(huanQiuLoader,source);

        //3.执行开始操作
        threadPoolHttpClient.start();
    }


}
