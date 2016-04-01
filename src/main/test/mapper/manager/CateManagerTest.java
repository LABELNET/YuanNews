package mapper.manager;

import cn.hpu.yuan.ssm.mapper.manager.CateManagerMapper;
import cn.hpu.yuan.ssm.model.vo.CateVo;
import common.MapperContanst;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuan on 16-4-1.
 * 分类信息管理测试
 */
public class CateManagerTest {

    private ApplicationContext context;
    private CateManagerMapper managerMapper;

    @Before
    public void setUp() throws Exception{
        context=new ClassPathXmlApplicationContext(MapperContanst.APPLIACTION_CONTEXT_LOCATION);
        managerMapper= (CateManagerMapper) context.getBean("cateManagerMapper");
    }

    @Test
    public void findCateById(){

        CateVo cateById = managerMapper.findCateById(1);


    }

}
