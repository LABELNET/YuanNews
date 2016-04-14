package yuan.ssm.service.manager;



import yuan.ssm.other.PageJo;
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
    PageJo managerFindUserCount() throws Exception;

    //修改用户信息
    Integer managerUpdateUserIfo(UserVo userVo) throws Exception;

    //添加用户信息
    Integer managerInsertUserIfo(UserVo userVo) throws Exception;

    //删除用户信息
    Integer managerDeleteUserIfo(Integer id) throws Exception;

}
