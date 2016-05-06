package yuan.ssm.datacenter.base;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import yuan.ssm.common.util.DateUtil;
import yuan.ssm.common.util.FileTool;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.datacenter.data.DataGetUtil;

import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.SECONDS;

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
 * 功能描述： 详情多线程并发执行操作类
 * 1.需要主页的请求类
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class ThreadPoolHttpClient {

    //兴趣主页加载父类：为了适应各个来源的加载
    private LoaderBase loaderBase=null;

    //线程池
    private ThreadPoolExecutor threadPool=null;

    //更新的Url条数
    private int urlsSize=0;
    private String poolName;


    public ThreadPoolHttpClient(LoaderBase loaderBase,String poolName) {
        this.loaderBase = loaderBase;
        threadPool=new ThreadPoolExecutor(100,500,5, SECONDS,
                new ArrayBlockingQueue<Runnable>(10000),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        this.poolName=poolName;
    }
    public void start(){
        HttpParams params =new BasicHttpParams();
        //连接超时
        HttpConnectionParams.setConnectionTimeout(params, 10000);
        //请求超时
        HttpConnectionParams.setSoTimeout(params, 10000);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(
                new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        //多线程实例
        PoolingClientConnectionManager cm=new PoolingClientConnectionManager(schemeRegistry);
        cm.setMaxTotal(10);
        final HttpClient httpClient = new DefaultHttpClient(cm,params);


        if(loaderBase!=null){
            Set<String> urls = loaderBase.getUrls();
            urlsSize=urls.size();
            for (String url:urls) {
                HttpGet httpget = new HttpGet(url);
                Runnable runnable = DataGetUtil.getRunnable(httpClient, httpget, loaderBase.getType());
                if(runnable!=null){
                    threadPool.execute(runnable);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        LoggerUtil.printJSON("ThreadPoolHttpClient Thread.sleep InterruptedException!");
                        e.printStackTrace();
                    }
                }else{
                    LoggerUtil.printJSON("ThreadPoolHttpClient DataGetUtil.getRunnable() is Null!");
                }
            }

            while(true)
            {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    LoggerUtil.printJSON("ThreadPoolHttpClient  while(true) Thread.sleep InterruptedException!");
                    e.printStackTrace();
                }
                if(threadPool.getActiveCount()==0)
                {
                    threadPool.shutdown();
                    break;
                }
            }

        }else{
            LoggerUtil.printJSON("ThreadPoolHttpClient LoaderBase is Null!");
        }

        String log= DateUtil.getDate()+" | "+poolName+" 更新了 "+urlsSize +" 条数据 .";
        LoggerUtil.printJSON(log);
        FileTool.createNewFile(log);
        LoggerUtil.printJSON("ThreadPoolHttpClient Done");
    }
}