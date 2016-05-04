package yuan.ssm.datacenter.base;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import yuan.ssm.common.util.LoggerUtil;
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
 *
 * 4.可拓展性高，如果需要存储在不同的地方或形式，可以在此拓展实现；
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public abstract class ParserBase {


    //编码
    protected final String ENCODEING_CODE="utf-8";

    //数据源
    protected Document doc;
    //当前url
    protected String url;

    public ParserBase(InputStream inputStream, String url) {
        this.url = url;
        try {
             doc = Jsoup.parse(inputStream, ENCODEING_CODE, url);
        } catch (IOException e) {
            LoggerUtil.printJSON("ParserBase ParserBase IOException");
            e.printStackTrace();
        }
    }

    /**
     * 解析新闻详情页面，返回的新闻对象
     * @return
     */
    protected abstract NewsVo parserDetailPage();

    /**
     * 存储到mysql数据库
     */
    public void toMysql(){
        //TODO 存储到mysql中
        LoggerUtil.printJSON(" ToMysql : "+parserDetailPage());
    }


}
