package mapper.manager;

import common.ManagerBaseTest;
import org.junit.Before;
import org.junit.Test;
import yuan.ssm.dao.manager.UserManagerMapper;
import yuan.ssm.vo.UserVo;

import java.util.List;

/**
 * Created by yuan on 16-3-30.
 * 用户管理 - 单元测试
 */
public class UserManagerTest extends ManagerBaseTest{

    private UserManagerMapper managerMapper;

    @Before
    public void setUp() {
        super.setUp();
        managerMapper = (UserManagerMapper) context.getBean("userManagerMapper");
    }

    /**
     * 根据用户id，查询用户信息
     * @throws Exception
     */
    @Test
    public void testFindUserById() throws Exception {

        UserVo userVo = managerMapper.findUserById(1);
        System.out.println("查询结果 ："+userVo.toString());
    }

    /**
     * 分页查询用户信息 list
     * @throws Exception
     */
    @Test
    public void findPageIndexUsers() throws Exception {
        List<UserVo> list=managerMapper.findPageIndexUsers(0,2);
        System.out.println("查询结果 ："+list.get(0).getNick()
                 +" ==== "+list.get(1).getNick());
    }

    /**
     * 根据id 修改用户状态
     * @throws Exception
     */
    @Test
    public void updateUserStatus() throws Exception {
        Integer result = managerMapper.updateUserStatus(1, 0);
        System.out.println("查询结果 ："+(result>0?"成功":"失败"));
    }

    /**
     * 根据id 修改用户性别
     * @throws Exception
     */
    @Test
    public void updateUserSex() throws Exception {
        Integer result = managerMapper.updateUserSex(1, 0);
        System.out.println("查询结果 ："+(result>0?"成功":"失败"));
    }

    /**
     * 根据id 修改用户头像
     * @throws Exception
     */
    @Test
    public void updateUserHead() throws Exception {
        Integer result = managerMapper.updateUserHead(1,"/imgage/moren.jpg");
        System.out.println("查询结果 ："+(result>0?"成功":"失败"));
    }

    /**
     * 修改密码
     * @throws Exception
     */
    @Test
    public void updateUserPass() throws Exception {
        Integer result = managerMapper.updateUserPass(1,"123456");
        System.out.println("查询结果 ："+(result>0?"成功":"失败"));
    }

    /**
     * 修改昵称
     * @throws Exception
     */
    @Test
    public void updateUserNick() throws Exception {
        Integer result = managerMapper.updateUserNick(1,"HaHaHa");
        System.out.println("查询结果 ："+(result>0?"成功":"失败"));
        testFindUserById();
    }

    /**
     * 删除用户
     * @throws Exception
     */
    @Test
    public void deleteUserById() throws Exception {
        Integer result = managerMapper.deleteUserById(1);
        System.out.println("查询结果 ："+(result>0?"成功":"失败"));
        testFindUserById();
    }

    /**
     * 添加用户
     * @throws Exception
     */
    @Test
    public void insertUser() throws Exception {
        UserVo vo=new UserVo();
        vo.setUnum("15000000003");
        vo.setPass("123456");
        vo.setNick("zhuo");
        Integer result = managerMapper.insertUser(vo);
        System.out.println("查询结果 ："+result+" | "+(result>0?"成功":"失败"));
    }

    /**
     * 查询用户账号存不存在 ，返回用户id ,查询不到为 null
     * @throws Exception
     */
    @Test
    public void findUserByUnum() throws Exception {
        Integer result = managerMapper.findUserByUnum("15000000004");
        System.out.println("查询结果 ："+result);
    }


    /**
     * 根据账号和密码查询
     * @throws Exception
     */
    @Test
    public void findUserByUnumPass() throws Exception {
        UserVo unumPass = managerMapper.findUserByUnumPass("15000000004", "123456");
        System.out.println("查询结果 ："+unumPass);
    }






}
