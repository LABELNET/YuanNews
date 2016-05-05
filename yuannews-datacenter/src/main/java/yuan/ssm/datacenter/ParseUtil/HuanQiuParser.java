package yuan.ssm.datacenter.ParseUtil;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import yuan.ssm.datacenter.base.ParserBase;
import yuan.ssm.datacenter.base.SourceEnum;
import yuan.ssm.datacenter.common.CSCommon;
import yuan.ssm.vo.NewsVo;

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
 * 创建日期：　16-5-4 上午9:57
 * <p/>
 * 功能描述：  环球网新闻解析类
 *
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class HuanQiuParser extends ParserBase{

    public HuanQiuParser(InputStream inputStream, String url) {
        super(inputStream, url);
    }

    protected NewsVo parserDetailPage() {

         String title=doc.select("h1").get(0).text();
         String dt=doc.select("#pubtime_baidu").text();
         String img="";
         Elements imgs = doc.select("img");
         for(Element i : imgs){
             img=i.attr("src");
             if(img.contains("huanqiu.com")){
                 break;
             }
         }
        StringBuffer buffer=new StringBuffer();
        Elements elements = doc.select("#text p");
        for(Element element : elements){
            buffer.append("　　" + element.text()+" \n ");
        }

        String content=buffer.toString();
        if(content.length()==0){
            content=doc.select("#text").text();
        }

        NewsVo newsVo=new NewsVo();
        newsVo.setImg(img);
        newsVo.setRnum(102);
        newsVo.setContent(content);
        newsVo.setDt(dt);
        newsVo.setTitle(title);
        newsVo.setCid(CSCommon.getCateId());
        newsVo.setSid(CSCommon.getSourceId(getType()));

        return newsVo;
    }

    protected SourceEnum getType() {
        return SourceEnum.huanqiu;
    }
}
