package yuan.ssm.datacenter.ParseUtil;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import yuan.ssm.common.util.DateUtil;
import yuan.ssm.datacenter.base.EncodeEnum;
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
 * 创建日期：　16-5-6 上午10:37
 * <p/>
 * 功能描述： ChinaNews详情页解析类
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class ChinaNewsParser extends ParserBase{


    public ChinaNewsParser(InputStream inputStream, String url) {
        super(inputStream, url);
    }

    //解析详情页
    protected NewsVo parserDetailPage() {
        NewsVo newsVo=new NewsVo();

        String title = doc.select("h1").get(0).text();//标题
        String dt= DateUtil.getDate(); //时间
        Elements select = doc.select(".left-t");
        for(Element element:select){
            if(element.text().contains("年")){
                dt=element.text();
                break;
            }
        }
        String img="";
        Elements imgs = doc.select("img");
        for (Element element:imgs){
            img=element.attr("src");
            if(!img.contains("http:")){
                break;
            }
        }

        String content = doc.select(".left_zw").get(0).text();

        newsVo.setSid(CSCommon.getSourceId(getType()));
        newsVo.setCid(CSCommon.getCateId());
        newsVo.setDt(dt);
        newsVo.setRnum(121);
        newsVo.setTitle(title);
        newsVo.setContent(content);
        newsVo.setImg(img);

        return newsVo;
    }

    protected SourceEnum getType() {
        return SourceEnum.chinanews;
    }

    protected EncodeEnum getEncode() {
        return EncodeEnum.gbk;
    }
}
