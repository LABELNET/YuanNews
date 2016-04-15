package yuan.ssm.service.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import yuan.ssm.common.status.LoginStatus;
import yuan.ssm.common.status.ManagerConutStatus;
import yuan.ssm.common.status.UpdateStatus;
import yuan.ssm.common.util.DateUtil;
import yuan.ssm.common.util.FontImageUtil;
import yuan.ssm.common.util.StringUtil;
import yuan.ssm.dao.manager.ManagerCountMapper;
import yuan.ssm.dao.manager.UserManagerMapper;
import yuan.ssm.other.PageJo;
import yuan.ssm.service.manager.UserManager;
import yuan.ssm.vo.UserVo;
import java.util.List;
import java.util.UUID;

/**
 * Created by yuan on 16-4-4.
 * 业务层　－　后台管理 － 用户管理 - 接口实现
 */
public class UserManagerImpl implements UserManager {


    @Autowired
    private UserManagerMapper userManagerMapper;

    @Autowired
    private ManagerCountMapper managerCountMapper;

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

    /**
     * 获取用户列表
     * @param start
     * @param num
     * @return
     * @throws Exception
     */
    public List<UserVo> managerFindUserList(Integer start, Integer num) throws Exception {
        return userManagerMapper.findPageIndexUsers(start,num);
    }

    /**
     * 获取用户总数
     * @return
     * @throws Exception
     */
    public PageJo managerFindUserCount() throws Exception {
        return managerCountMapper.findCount(ManagerConutStatus.MANAGER_USER_COUNT_TYPE);
    }


    /**
     * 修改用户信息
     * @param userVo　用户实体对象
     * @return
     * @throws Exception
     */
    public Integer managerUpdateUserIfo(UserVo userVo) throws Exception {
        if(userVo==null){
            return UpdateStatus.UPDATE_FAIL;
        }

        int uid=userVo.getId();
        int success=UpdateStatus.UPDATE_SUCCESS;

        if(uid<=0){
            return UpdateStatus.UPDATE_ID_ZORE;
        }

        if(userVo.getNick()!=null){
            success=userManagerMapper.updateUserNick(uid,userVo.getNick());
        }

        if(userVo.getSex()>-1){
            success=userManagerMapper.updateUserSex(uid,userVo.getSex());
        }

        if(userVo.getStatus()>-1){
            success=userManagerMapper.updateUserStatus(uid,userVo.getStatus());
        }
        return success;
    }

    /**
     * 添加用户信息
     * @param userVo 用户实体
     * @return 成功>0
     * @throws Exception
     */
    public Integer managerInsertUserIfo(UserVo userVo) throws Exception {
        //生成默认头像，并存储
        try {
            String imgName = DateUtil.getDateFileName()+UUID.randomUUID() +".png";
            String font= StringUtil.getCharString(userVo.getNick());
            FontImageUtil.createImage(font,imgName);
            userVo.setHead("/image/"+imgName);
        }catch (Exception e){
            userVo.setHead("/images/moren.jpg");
        }
        return userManagerMapper.insertUser(userVo);
    }

    /**
     * 删除用户信息
     * @param id 用户id
     * @return
     * @throws Exception
     * 状态改为　3代表已经删除
     */
    public Integer managerDeleteUserIfo(Integer id) throws Exception {
        return userManagerMapper.deleteUserById(id,3);
    }

    /**
     * 恢复用户信息
     * @param id　用户id
     * @return
     * @throws Exception
     * 回复为普通用户
     */
    public Integer managerSettingUserIfo(Integer id) throws Exception {
        return userManagerMapper.deleteUserById(id,0);
    }


}
