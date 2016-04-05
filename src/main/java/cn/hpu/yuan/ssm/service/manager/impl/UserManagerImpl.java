package cn.hpu.yuan.ssm.service.manager.impl;

import cn.hpu.yuan.ssm.common.LoginStatus;
import cn.hpu.yuan.ssm.mapper.manager.UserManagerMapper;
import cn.hpu.yuan.ssm.model.vo.UserVo;
import cn.hpu.yuan.ssm.service.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yuan on 16-4-4.
 * 业务层　－　后台管理 － 用户管理 - 接口实现
 */
public class UserManagerImpl implements UserManager{


    @Autowired
    private UserManagerMapper userManagerMapper;

    /**
     * 管理员登陆
     * @param unum　账号
     * @param pass　密码
     * @return
     * @throws Exception
     */
    public Integer managerLogin(String unum, String pass) throws Exception {

        Integer userId = userManagerMapper.findUserByUnum(unum);
        if(userId==null){
            return LoginStatus.UNUM_NOT_HAVE;
        }
        UserVo userVo = userManagerMapper.findUserByUnumPass(unum, pass);
        if (userVo==null){
            return LoginStatus.PASS_ERROR;
        }
        if(userId>0 && userVo.getId()==userId){
            return userId;
        }
        return LoginStatus.Login_ERROR;
    }

    /**
     * 获得用户信息
     * @param uid
     * @return
     * @throws Exception
     */
    public UserVo managerFindUserIfo(Integer uid) throws Exception {
        return userManagerMapper.findUserById(uid);
    }


}
