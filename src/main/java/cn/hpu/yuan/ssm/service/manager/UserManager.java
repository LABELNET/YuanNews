package cn.hpu.yuan.ssm.service.manager;


import cn.hpu.yuan.ssm.model.vo.UserVo;

/**
 * Created by yuan on 16-4-4.
 * 业务层　－　后台管理－　用户管理
 */
public interface UserManager {

    //管理员登陆
    Integer managerLogin(String unum,String pass) throws Exception;

    UserVo managerFindUserIfo(Integer uid) throws Exception;

}
