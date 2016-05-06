package yuan.ssm.datacenter.datasource;

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
 * 创建日期：　16-5-6 上午10:33
 * <p/>
 * 功能描述： ChinaNews来源链接封装类
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public class ChinaNewsSource {

    private static final String CHINA_NEWS_URL="http://www.chinanews.com/";

    /**
     * 得到主页
     * @return
     */
    public static String getChinaNewsPageIndex(){
        return CHINA_NEWS_URL;
    }


}
