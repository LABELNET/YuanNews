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

    /**
     * 根据id , 查询评论
     */
    @Test
    public void findCommentById(){
        CommentPo commentPo = commentManagerMapper.findCommentById(1);
        System.out.printf("评论管理测试　：　"+commentPo);
    }

    /**
     * 修改评论状态
     */
    @Test
    public void updateCommentStatus(){
        Integer status = commentManagerMapper.updateCommentStatus(1, 0);
        System.out.printf("评论管理测试　：　"+status +(status>0?"成功":"失败"));
    }


}
