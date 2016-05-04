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
 * 创建日期：　16-5-4 上午9:52
 * <p/>
 * 功能描述：环球网新闻爬去数据执行类
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class HuanQiuGetData extends GetDataBase{


    public HuanQiuGetData(HttpClient httpClient, HttpGet httpget,ParserBase parserBase) {
        super(httpClient, httpget,parserBase);
    }

    protected void parserDetailToDb(InputStream stream, String url, ParserBase parserBase) {

    }

}
