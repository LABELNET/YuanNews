package yuan.ssm.common.config;

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
 * 创建日期：　16-4-14 上午11:47
 * <p/>
 * 功能描述：
 * TODO :　如果需要的切换环境的话，需要进行配置的地方！
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public interface ConfigConstant {

    /**
     * 根据文字生成图片，存放的基础路径，跟随着tomcat的变化而变化
     * 详见：　tomcat_home/conf/server.xml - Context
     */
    String FONT_IMAGE_BASE_PATH="/mnt/JAVA/tomcatImageServer/";

    /**
     * 用户管理页面，每页加载的数量
     */
    Integer MAGAGER_USER_PAGE_NUM=8;

    /**
     * 兴趣管理页面，每页加载的数量
     */
    Integer MANAGER_TASTE_PAGE_NUM=10;

    /**
     * 新闻来源管理页面，每页加载的数量
     */
    Integer MANAGER_SOURCE_PAGE_NUM=10;

    /**
     * 点赞每页显示的数量
     */
    Integer MANAGER_LIKED_PAGE_NUM=10;

    /**
     * 评论每页显示数量
     */
    Integer MANAGER_COMMENT_PAGE_NUM=8;

    /**
     *　新闻页面显示数量
     */
    Integer MANAGER_NEWS_PAGE_NUM=8;


}
