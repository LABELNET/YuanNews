package yuan.ssm.datacenter.DownUtil;

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
 * 创建日期：　16-5-4 下午10:00
 * <p/>
 * 功能描述：图片下载类
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class ImageDown extends DownImageBase{

    private SourceEnum type;

    public ImageDown(HttpClient httpClient, HttpGet httpget) {
        super(httpClient, httpget);
    }

    public ImageDown(HttpClient httpClient, HttpGet httpget,SourceEnum type) {
        this(httpClient, httpget);
    }


    protected void saveImage(byte[] arrs) {


//        FileOutputStream outputStream=new FileOutputStream()
    }
}
