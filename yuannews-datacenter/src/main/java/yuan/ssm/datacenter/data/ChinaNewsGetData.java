package yuan.ssm.datacenter.data;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import yuan.ssm.datacenter.base.GetDataBase;
import yuan.ssm.datacenter.base.ParserBase;

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
 * 创建日期：　16-5-6 上午10:35
 * <p/>
 * 功能描述： TODO
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class ChinaNewsGetData extends GetDataBase{


    public ChinaNewsGetData(HttpClient httpClient, HttpGet httpget) {
        super(httpClient, httpget);
    }

    //解析后的操作
    protected void parserDetailToDb(ParserBase parserBase) {
            parserBase.toLogPrint();//日志打印
    }

    protected ParserBase parserDetailMethod(InputStream stream, String url) {
        return null;
    }
}
