package mapper.manager;

import cn.hpu.yuan.ssm.mapper.manager.CommentManagerMapper;
import cn.hpu.yuan.ssm.model.pojo.CommentPo;
import common.MapperContanst;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuan on 16-4-4.
 * 评论管理－　单元测试
 */
public class CommentManagerTest {

    private ApplicationContext context;
    private CommentManagerMapper commentManagerMapper;

    @Before
    public void setUp(){
        context=new ClassPathXmlApplicationContext(MapperContanst.APPLIACTION_CONTEXT_LOCATION);
        commentManagerMapper= (CommentManagerMapper) context.getBean("commentManagerMapper");
    }

    @Test
    public void findCommentById(){
        CommentPo commentPo = commentManagerMapper.findCommentById(1);
        System.out.printf("评论管理测试　：　"+commentPo);
    }


}
