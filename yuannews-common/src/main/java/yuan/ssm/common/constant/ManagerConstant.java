package yuan.ssm.common.constant;

/**
 * Created by yuan on 16-4-5.
 * 控制器－后台管理－放置常量
 * 注意：核心类，配置后台管理各个页面（jsp）
 */
public interface ManagerConstant {

    String LOG_MANAGER_CONTROLLER="controller/ManagerController";//后台管理－log位置标示

    String MANAGER_INDEX="manager/index"; //后台管理-主页

    String SESSION_ATTRIBUTE_KEY="uid"; //HttpSession 的 key

    String MANAGER_REDRICT_LOGIN="redirect:LoginManger.jsp"; //重定向url到登陆界面

    String MANAGER_INDEX_MV_KEY="userVo";

    String MAGAGER_USER_PAGE="manager/UserManager"; //用户管理页面

    String MANAGER_USER_NAME="usernick";

    String MANAGER_TASTE_PAGE="manager/TasteManager"; //兴趣管理页面

    String MANAGER_SOURCE_PAGR="manager/SourceManager"; //新闻来源管理页面

    String MANAGER_CATE_PAGE="manager/CateManager"; //新闻分类管理页面

    String MANAGER_LIKED_PAGE="manager/LikedManager"; //点赞管理页面

    String MANAGER_COMMENT_PAGR="manager/CommentManager";//评论管理页面

    String MANAGER_NEWS_PAGE="manager/NewsManager";//新闻管理页面

}
