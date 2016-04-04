package mapper.manager;

import cn.hpu.yuan.ssm.mapper.manager.LikedManagerMapper;
import cn.hpu.yuan.ssm.model.pojo.LikedPo;
import common.MapperContanst;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 后台管理　－　点赞管理　－　单元测试
 */
public class LikedManagerTest {

    private ApplicationContext context;
    private LikedManagerMapper likedManagerMapper;

    @Before
    public void setUp(){
        context=new ClassPathXmlApplicationContext(MapperContanst.APPLIACTION_CONTEXT_LOCATION);
        likedManagerMapper= (LikedManagerMapper) context.getBean("likedManagerMapper");
    }

    @Test
    public void findLikeds(){
        List<LikedPo> likeds = likedManagerMapper.findLikeds(0, 2);
        System.out.printf("点赞测试结果　："+likeds);
    }

}
