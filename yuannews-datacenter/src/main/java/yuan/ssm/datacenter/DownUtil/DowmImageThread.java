package yuan.ssm.datacenter.DownUtil;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

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
 * 创建日期：　16-5-4 下午10:18
 * <p/>
 * 功能描述： TODO
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class DowmImageThread{



    private static List<String> urls=new ArrayList<String>();


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

    }

}
