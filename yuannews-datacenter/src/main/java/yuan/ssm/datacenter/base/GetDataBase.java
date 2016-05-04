package yuan.ssm.datacenter.base;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import yuan.ssm.common.util.LoggerUtil;

import java.io.InputStream;

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
 * 创建日期：　16-5-4 下午1:35
 * <p/>
 * 功能描述：详情请求类： 抽象出请求类，添加解析抽象方法
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public abstract class GetDataBase implements Runnable{


    private final int SUCCESS_CODE=200;
    private final HttpClient httpClient;
    private final HttpContext context;
    private final HttpGet httpget;
    //默认值
    private final String NO_URL=" NO ";

    public GetDataBase(HttpClient httpClient, HttpGet httpget) {
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
                LoggerUtil.printJSON(this.httpget.getURI()+": status"+response.getStatusLine().toString());
                if(response.getStatusLine().getStatusCode()==SUCCESS_CODE){
                    //执行解析
                    parserDetailData(entity.getContent());
                }else {
                    LoggerUtil.printJSON(this.httpget.getURI()+": response code : "+response.getStatusLine().getStatusCode());
                }
            }else {
                LoggerUtil.printJSON(this.httpget.getURI()+": HttpEntity is null");
            }
            // 回收
            EntityUtils.consume(entity);
        } catch (Exception ex) {
            this.httpget.abort();
        }finally{
            httpget.releaseConnection();
        }
    }

    /**
     * 解析的抽象方法
     * @param stream
     */
    protected abstract void parserDetailData(InputStream stream);

}
