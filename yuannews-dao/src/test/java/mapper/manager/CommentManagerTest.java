package mapper.manager;

import common.ManagerBaseTest;
import common.MapperContanst;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yuan.ssm.dao.manager.CommentManagerMapper;
import yuan.ssm.pojo.CommentPo;

/**
 * Created by yuan on 16-4-4.
 * 评论管理－　单元测试
 */
public class CommentManagerTest extends ManagerBaseTest{

    private CommentManagerMapper commentManagerMapper;

    @Before
    public void setUp(){
        super.setUp();
        commentManagerMapper= (CommentManagerMapper) super.context.getBean("commentManagerMapper");
    }

    /**
     * 根据id , 查询评论
     */
    @Test
    public void findCommentById() throws Exception{
        CommentPo commentPo = commentManagerMapper.findCommentById(1);
        System.out.printf("评论管理测试　：　"+commentPo);
    }

    /**
     * 修改评论状态
     */
    @Test
    public void updateCommentStatus() throws Exception{
        Integer status = commentManagerMapper.updateCommentStatus(1, 0);
        System.out.printf("评论管理测试　：　"+status +(status>0?"成功":"失败"));
    }


}
