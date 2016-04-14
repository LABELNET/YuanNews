package yuan.ssm.dao.manager;

import org.apache.ibatis.annotations.Param;
import yuan.ssm.vo.UserVo;

import java.util.List;

/**
 * Created by yuan on 16-3-30.
 * 用户管理 ：  mapper
 */
public interface UserManagerMapper {




    /**
     * ---------------------------------------------------------------
     * 查询
     */

    //根据用户id，获得用户信息
    UserVo findUserById(Integer id) throws Exception;
    //分页查询，用户所有信息
    List<UserVo> findPageIndexUsers(Integer pageIndex, Integer pageNum) throws Exception;
    //登陆查询 ，查询账号是否存在
    Integer findUserByUnum(@Param("unum") String unum) throws Exception;
    //登陆查询 ，根据账号查询密码
    UserVo findUserByUnumPass(@Param("unum") String unum,@Param("pass") String pass) throws Exception;

    /**
     * ---------------------------------------------------------------
     * 修改
     */
    //修改用户的状态 0: 用户 ； 1 ：管理员 , 2: xxx
    Integer updateUserStatus(Integer id,Integer status) throws Exception;
    //修改用户性别 0: 男 ，1 ：女 , 2:未知
    Integer updateUserSex(Integer id,Integer sex) throws Exception;
    //修改用户头像
    Integer updateUserHead(@Param("id") Integer id,@Param("img") String img) throws  Exception;
    //修改密码
    Integer updateUserPass(@Param("id") Integer id,@Param("pass") String pass) throws Exception;
    //修改昵称
    Integer updateUserNick(@Param("id") Integer id,@Param("nick") String nick) throws Exception;

    /**
     * ---------------------------------------------------------------
     * 删除
     */

    //删除用户 ： 修改 status 状态为 -1 ；
    Integer deleteUserById(Integer id,Integer status) throws Exception;

    /**
     * ---------------------------------------------------------------
     * 添加
     */
    Integer insertUser(UserVo user) throws Exception;


}
