package manager;

import common.ServiceBaseTest;
import org.junit.Before;
import org.junit.Test;
import yuan.ssm.dao.manager.UserManagerMapper;
import yuan.ssm.service.manager.UserManager;
import yuan.ssm.service.manager.impl.UserManagerImpl;
import yuan.ssm.vo.UserVo;

import java.util.List;

/**
 * Created by yuan on 16-4-7.
 * 服务端测试类实现
 */
public class UserManagerTest extends ServiceBaseTest{

    private UserManager userManager;

    @Before
    public void setUp(){
        super.setUp();
        userManager= (UserManager) context.getBean("userManagerImpl");
    }

    @Test
    public void managerFindUserList() throws Exception {
        List<UserVo> userVos = userManager.managerFindUserList(0, 3);
        System.out.println(" 服务端测试结果　：　 "+userVos);
    }

}
