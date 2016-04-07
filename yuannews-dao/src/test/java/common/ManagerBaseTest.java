package common;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuan on 16-4-4.
 * 初始化　base类
 */
public class ManagerBaseTest {

    public ApplicationContext context;

    @Before
    public void setUp(){
        context=new ClassPathXmlApplicationContext(MapperContanst.APPLIACTION_CONTEXT_LOCATION);
    }

}
