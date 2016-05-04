package yuan.ssm.datacenter.base;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.dao.manager.NewsManagerMapper;
import yuan.ssm.vo.NewsVo;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

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
 * 创建日期：　16-5-4 下午2:25
 * <p/>
 * 功能描述： 解析抽象类，所有的解析类，包含两个方法
 * 1.解析主页 List<String>，静态类，静态加载
 * 2.解析详情页 ， 返回 NewsVo
 * 3.解析详情页，进行数据存储操作 - > mysql
 * 4.下载图片存储到本地；
 *
 * 4.TODO 可拓展性高，如果需要存储在不同的地方或形式，可以在此拓展实现；
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public abstract class ParserBase {


    /**
     * mapper存储对象
     */
    private NewsManagerMapper newsManagerMapper;

    //dao
    private final String APPLIACTION_CONTEXT_LOCATION="classpath:spring/applicationContext-dao.xml";

    //编码
    protected final String ENCODEING_CODE="utf-8";

    //本地硬盘存储位置
    private static final String LOCAL_IMAGE_PATH="/mnt/JAVA/tomcatImageServer/";

    private final String MOREN_IMGAE="/image/head/moren.png";

    private static HttpClient httpClient;

    //数据源
    protected Document doc;
    //当前url
    protected String url;

    public ParserBase(InputStream inputStream, String url) {
        //初始化mysql存储对象
        final ApplicationContext context=new ClassPathXmlApplicationContext(APPLIACTION_CONTEXT_LOCATION);
        newsManagerMapper= (NewsManagerMapper) context.getBean("newsManagerMapper");

        this.url = url;

        try {
             doc = Jsoup.parse(inputStream, ENCODEING_CODE, url);
        } catch (IOException e) {
            LoggerUtil.printJSON("ParserBase ParserBase IOException");
            e.printStackTrace();
        }
        httpClient=new DefaultHttpClient();
    }

    /**
     * 解析新闻详情页面，返回的新闻对象
     * @return 新闻对象
     */
    protected abstract NewsVo parserDetailPage();

    /**
     * 获取当前执行类型
     * @return
     */
    protected  abstract SourceEnum getType();

    /**
     * 存储到mysql数据库
     */
    public void toMysql(){
        NewsVo newsVo = parserDetailPage();
        try {
            String imgName=MOREN_IMGAE;
            if(newsVo.getImg().length()==0){
                newsVo.setImg(MOREN_IMGAE);
            }else{
                imgName=getType().toString()+"/"+ UUID.randomUUID()+".jpg";
                newsVo.setImg("/image/"+imgName);
                downloadImage(newsVo.getImg(),imgName);
            }
            newsManagerMapper.insertNews(newsVo);
        } catch (Exception e) {
            LoggerUtil.printJSON("ParserBase NewsManagerMapper toMysql");
            e.printStackTrace();
        }
    }

    /**
     * 文件存储
     */
    public void toFile(){
    }


    /**
     * 下载图片并存储到本地硬盘
     * @param imgName 图片名称
     */
    private void downloadImage(String imgUrl,String imgName){

    }

}
