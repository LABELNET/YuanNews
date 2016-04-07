package mapper.manager;

import common.ManagerBaseTest;
import org.junit.Before;
import org.junit.Test;
import yuan.ssm.dao.manager.ManagerCountMapper;
import yuan.ssm.other.PageJo;

/**
 * Created by yuan on 16-4-7.
 * 后台管理－统计相关－测试类
 */
public class ManagerCountTest extends ManagerBaseTest{


    private ManagerCountMapper managerCountMapper;

    @Before
    public void setUp(){
        super.setUp();
        managerCountMapper= (ManagerCountMapper) context.getBean("managerCountMapper");
    }

    @Test
    public void findUserCount() throws Exception {
        PageJo pageJo = managerCountMapper.findUserCount(3);
        System.out.println("查询结果为　：　"+pageJo.getAllCount());
    }

}
