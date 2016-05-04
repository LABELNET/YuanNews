package yuan.ssm.datacenter.ParseUtil;

import org.jsoup.select.Elements;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.datacenter.base.ParserBase;
import yuan.ssm.datacenter.common.CateCommon;
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

    private final String HUXIU_WORD="1.html";

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
        String img=doc.select(".article-img-box").tagName("img").get(0).attr("src");//图片

        newsVo.setTitle(str);
        newsVo.setDt(dt);
        newsVo.setImg(img);
        newsVo.setContent(content);
        newsVo.setRnum(100);
        newsVo.setCid(CateCommon.getCateId(HUXIU_WORD));
        newsVo.setSid(1);

        LoggerUtil.printJSON(newsVo);

        File file = new File("/mnt/JAVA/tomcatImageServer/ids/Huxiu.txt");
        if(!file.exists()){

            try {
                file.createNewFile();
            } catch (IOException e) {
                LoggerUtil.printJSON("HuxiuParser parserDetailPage File Exception");
                e.printStackTrace();
            }

        }

        try {
            FileWriter writer=new FileWriter(file,true);
            writer.write(newsVo.getTitle() +" : "+ url+" \n ");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            LoggerUtil.printJSON("HuxiuParser parserDetailPage FileWriter Exception");
            e.printStackTrace();
        }

        return newsVo;
    }


}
