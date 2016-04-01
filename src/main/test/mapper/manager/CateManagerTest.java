package mapper.manager;

import common.MapperContanst;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuan on 16-4-1.
 * 分类信息管理测试
 */
public class CateManagerTest {

    private ApplicationContext context;

    @Before
    public void setUp(){
        context=new ClassPathXmlApplicationContext(MapperContanst.APPLIACTION_CONTEXT_LOCATION);
    }

}
