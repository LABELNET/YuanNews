package mapper.manager;

import cn.hpu.yuan.ssm.mapper.manager.UserManagerMapper;
import cn.hpu.yuan.ssm.model.vo.UserVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuan on 16-3-30.
 * 用户管理 - 单元测试
 */
public class UserManagerTest {

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
    }

    /**
     * 根据用户id，查询用户信息
     * @throws Exception
     */
    @Test
    public void testFindUserById() throws Exception {
        UserManagerMapper managerMapper= (UserManagerMapper) context.getBean("userManagerMapper");
        UserVo userVo = managerMapper.findUserById(1);
        System.out.println("查询结果 ："+userVo.getNick()+userVo.getUnum());
    }

}
