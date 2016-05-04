package yuan.ssm.datacenter.base;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.datacenter.data.DataGetUtil;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    // 线程池
    private ExecutorService exe = null;
    // 线程池的容量
    private static final int POOL_SIZE = 20;

    //兴趣主页加载父类：为了适应各个来源的加载
    private LoaderBase loaderBase=null;

    public ThreadPoolHttpClient(LoaderBase loaderBase) {
        this.loaderBase = loaderBase;
    }
    public void start(){
        exe = Executors.newFixedThreadPool(POOL_SIZE);
        HttpParams params =new BasicHttpParams();
        /* 从连接池中取连接的超时时间 */ 
        ConnManagerParams.setTimeout(params, 1000);
        //连接超时
        HttpConnectionParams.setConnectionTimeout(params, 2000); 
        //请求超时
        HttpConnectionParams.setSoTimeout(params, 4000);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(
                new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        //多线程实例
        PoolingClientConnectionManager cm=new PoolingClientConnectionManager(schemeRegistry);
        cm.setMaxTotal(10);
        final HttpClient httpClient = new DefaultHttpClient(cm,params);


        if(loaderBase!=null){
            List<String> urls = loaderBase.getUrls();
            for (String url:urls) {
                HttpGet httpget = new HttpGet(url);
                Runnable runnable = DataGetUtil.getRunnable(httpClient, httpget, loaderBase.getType());
                if(runnable!=null){
                    exe.execute(runnable);
                }else{
                    LoggerUtil.printJSON("ThreadPoolHttpClient DataGetUtil.getRunnable() is Null!");
                }
            }
        }else{
            LoggerUtil.printJSON("ThreadPoolHttpClient LoaderBase is Null!");
        }
        exe.isShutdown();
        LoggerUtil.printJSON("ThreadPoolHttpClient Done");
    }
}