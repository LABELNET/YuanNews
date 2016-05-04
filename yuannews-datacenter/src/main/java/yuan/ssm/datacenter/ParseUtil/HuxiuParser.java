package yuan.ssm.datacenter.ParseUtil;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.datacenter.base.ParserBase;
import yuan.ssm.datacenter.base.SourceEnum;
import yuan.ssm.datacenter.common.CSCommon;
import yuan.ssm.vo.NewsVo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
 * 创建日期：　16-5-4 下午1:52
 * <p/>
 * 功能描述： 虎嗅网内容解析类
 * 1.解析主页
 * 2.解析内容页
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class HuxiuParser extends ParserBase{

    /**
     * 初始化
     * @param inputStream 数据流
     * @param url 当前url
     */
    public HuxiuParser(InputStream inputStream, String url) {
        super(inputStream, url);
    }

    /**
     * 解析操作
     * @return
     */
    protected NewsVo parserDetailPage() {

        NewsVo newsVo=new NewsVo();

        Elements title= doc.select("title");//主题
        String str = title.first().text().replace("-看点-@虎嗅网", "").
                replace("-观点-@虎嗅网", "").replace("-读点-@虎嗅网", "");
        String dt=doc.select(".article-time").text();  // 发帖时间
        String content= doc.select("#article_content").get(0).text();//内容
        String img="默认";

        Elements imgs = doc.select("img");

        for (Element element:imgs){
            String attr = element.attr("src");
            if(attr.contains("w/800/h/450")){
                img=attr;
            }
        }
        newsVo.setTitle(str);
        newsVo.setDt(dt);
        newsVo.setImg(img);
        newsVo.setContent(content);
        newsVo.setRnum(100);
        newsVo.setCid(CSCommon.getCateId(SourceEnum.huxiu));
        newsVo.setSid(CSCommon.getSourceId(SourceEnum.huxiu));

        return newsVo;
    }


}
