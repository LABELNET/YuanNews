package yuan.ssm.service.manager;



import yuan.ssm.vo.UserVo;
import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 业务层　－　后台管理－　用户管理
 */
public interface UserManager {

    //管理员登陆
    Integer managerLogin(String unum,String pass) throws Exception;
    //获取用户信息
    UserVo managerFindUserIfo(Integer uid) throws Exception;
    //获取多个用户
    List<UserVo> managerFindUserList(Integer start,Integer num) throws Exception;
    //获取用户总数
    Integer managerFindUserCount() throws Exception;

}
