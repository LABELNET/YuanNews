package manager;

import common.ServiceBaseTest;
import org.junit.Before;
import org.junit.Test;
import yuan.ssm.service.manager.UserManager;
import yuan.ssm.vo.UserVo;

import java.util.List;

/**
 * Created by yuan on 16-4-7.
 */
public class UserManagerTest extends ServiceBaseTest{



    public UserManager userManager;

    @Before
    public void setUp(){
        super.setUp();
        userManager= (UserManager) super.context.getBean("userManager");
    }

    @Test
    public void managerFindUserList() throws Exception {
        List<UserVo> userVos = userManager.managerFindUserList(0, 3);
        System.out.println(" 服务端测试结果　：　 "+userVos);
    }

}
