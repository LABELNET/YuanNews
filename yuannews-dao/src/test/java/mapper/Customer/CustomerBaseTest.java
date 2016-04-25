package mapper.Customer;

import common.ManagerBaseTest;
import yuan.ssm.dao.customer.CateNewsMapper;
import yuan.ssm.dao.customer.NewsMapper;
import yuan.ssm.dao.customer.UserMapper;


/**
 * Create by yuanmingzhuo on 16/04/25
 * 创建测试客户基础类，用来创建bean
 * */
public class CustomerBaseTest extends ManagerBaseTest{

    protected NewsMapper newsMapper;
    protected UserMapper userMapper;
    protected CateNewsMapper cateNewsMapper;

    @Override
    public void setUp() {
        super.setUp();
        newsMapper= (NewsMapper) super.context.getBean("newsMapper");
        userMapper= (UserMapper) super.context.getBean("userMapper");
        cateNewsMapper= (CateNewsMapper) super.context.getBean("cateNewsMapper");
    }
}
