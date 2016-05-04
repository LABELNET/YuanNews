package yuan.ssm.datacenter.data;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import yuan.ssm.datacenter.base.SourceEnum;

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
 * 创建日期：　16-5-4 下午1:22
 * <p/>
 * 功能描述： 根据来源创建 runnable对象，用来添加到线程池中
 * 1.添加其他来源需要更新这里
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class DataGetUtil {

    public synchronized static Runnable getRunnable(HttpClient httpClient, HttpGet httpget, SourceEnum sourceEnum){
        switch (sourceEnum){
            case huanqiu:
                return new HuanQiuGetData(httpClient, httpget);
            case cctv:
                break;
            case huxiu:
                 return new HuxiuGetData(httpClient, httpget);
            default:
                return null;
        }
        return null;
    }
}
