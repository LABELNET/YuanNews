package mapper.manager;

import cn.hpu.yuan.ssm.mapper.manager.TasteManagerMapper;
import common.MapperContanst;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuan on 16-4-1.
 * 后台管理 - 兴趣管理 - 单元测试
 */
public class TasteManagerTest {

    private ApplicationContext context;
    private TasteManagerMapper tasteManagerMapper;

    @Before
    public void setUp(){
        context=new ClassPathXmlApplicationContext(MapperContanst.APPLIACTION_CONTEXT_LOCATION);
        tasteManagerMapper= (TasteManagerMapper) context.getBean("tasteManagerMapper");
    }

    @Test
    public void findTasteById(){

    }


}
