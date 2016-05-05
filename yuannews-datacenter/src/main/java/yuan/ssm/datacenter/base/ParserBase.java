package yuan.ssm.datacenter.base;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.dao.manager.NewsManagerMapper;
import yuan.ssm.datacenter.DownUtil.ImageDown;
import yuan.ssm.vo.NewsVo;

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

    private final String MOREN_IMGAE="/image/head/moren.png";


    //图片下载器
    private ImageDown imageDown;

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
    }

    /**
     * 清除NewsVo中的图片属性，将图片下载到本地，服务器存储当前的地址;
     * @return NewsVo
     */
    private NewsVo cleanNewsVo() {
        NewsVo newsVo=parserDetailPage();
        imageDown=new ImageDown(getType().toString(),newsVo.getImg());
        String imgName=imageDown.getImageName();
        if(newsVo.getImg().length()==0){
            //没有图片
            newsVo.setImg(MOREN_IMGAE);
        }else{
            newsVo.setImg(imageDown.getNetPath(imgName));
            imageDown.downloadImage(imgName);
        }
        return newsVo;
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
        NewsVo newsVo = cleanNewsVo();
        try {
            if(newsVo.getContent().length()>0 && newsVo.getTitle().length()>0) {
                newsManagerMapper.insertNews(newsVo);
            }else{
                LoggerUtil.printJSON("ParserBase NewsManagerMapper NewsVo的内容和标题没有内容了！");
            }
        } catch (Exception e) {
            LoggerUtil.printJSON("ParserBase NewsManagerMapper toMysql");
            e.printStackTrace();
        }
    }


    public void toLogPrint(){
        LoggerUtil.printJSON(parserDetailPage());
    }

    /**
     * 文件存储
     */
    public void toFile(){
    }

}
