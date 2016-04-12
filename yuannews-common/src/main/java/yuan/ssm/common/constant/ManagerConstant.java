package yuan.ssm.common.constant;

/**
 * Created by yuan on 16-4-5.
 * 控制器－后台管理－放置常量
 */
public interface ManagerConstant {

    String LOG_MANAGER_CONTROLLER="controller/ManagerController";//后台管理－log位置标示

    String MANAGER_INDEX="manager/index"; //后台管理-主页

    String SESSION_ATTRIBUTE_KEY="uid"; //HttpSession 的 key

    String MANAGER_REDRICT_LOGIN="redirect:LoginManger.jsp"; //重定向url到登陆界面

    String MANAGER_INDEX_MV_KEY="userVo";

    String MAGAGER_USER_PAGE="manager/UserManager";

    String MANAGER_USER_NAME="usernick";

}
