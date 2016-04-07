package common;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuan on 16-4-7
 * 基础工具类
 */
public class ServiceBaseTest {


     public ApplicationContext context;

    @Before
    public void setUp(){
        context=new ClassPathXmlApplicationContext(ServiceConstant.SERVICE_APPLICATION);
    }

}
