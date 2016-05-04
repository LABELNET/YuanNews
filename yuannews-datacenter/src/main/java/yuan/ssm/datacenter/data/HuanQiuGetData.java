package yuan.ssm.datacenter.data;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.vo.NewsVo;

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
 * 创建日期：　16-5-4 上午9:52
 * <p/>
 * 功能描述：环球网新闻爬去数据执行类
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class HuanQiuGetData implements Runnable{

    private final HttpClient httpClient;
    private final HttpContext context;
    private final HttpGet httpget;

    //默认值
    private final String NO_URL=" NO ";

    //详情页url
    private String detailUrl=NO_URL;


    public HuanQiuGetData(HttpClient httpClient, HttpGet httpget) {
        this.httpClient = httpClient;
        this.context = new BasicHttpContext();
        this.httpget = httpget;
    }
    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            LoggerUtil.printJSON("HuanQiuGetData Thread.sleep Exception");
            e.printStackTrace();
        }
        get();
    }

    public void get() {
        try {
            HttpResponse response = this.httpClient.execute(this.httpget, this.context);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                System.out.println(this.httpget.getURI()+": status"+response.getStatusLine().toString());
            }
            // ensure the connection gets released to the manager
            EntityUtils.consume(entity);
        } catch (Exception ex) {
            this.httpget.abort();
        }finally{
            httpget.releaseConnection();
        }
    }

    /**
     * 执行加载详情和存储到mysql操作
     */
    private NewsVo loadDetailToMysql(){
        if(NO_URL.equals(detailUrl)){
            LoggerUtil.printJSON("没有URL");
            return null;
        }
        try {
            Document document = Jsoup.connect(detailUrl).timeout(100000).get();

        } catch (IOException e) {
            LoggerUtil.printJSON("数据获取失败： "+detailUrl);
            e.printStackTrace();
        }
        return null;
    }






}
