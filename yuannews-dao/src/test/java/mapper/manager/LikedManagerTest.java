package mapper.manager;

import common.ManagerBaseTest;
import org.junit.Before;
import org.junit.Test;
import yuan.ssm.dao.manager.LikedManagerMapper;
import yuan.ssm.pojo.LikedPo;
import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 后台管理　－　点赞管理　－　单元测试
 */
public class LikedManagerTest extends ManagerBaseTest {

    private LikedManagerMapper likedManagerMapper;

    @Before
    public void setUp(){
        super.setUp();
        likedManagerMapper= (LikedManagerMapper) context.getBean("likedManagerMapper");
    }

    /**
     * 分页查询
     */
    @Test
    public void findLikeds() throws Exception{
        List<LikedPo> likeds = likedManagerMapper.findLikeds(0, 2);
        System.out.printf("点赞测试结果　："+likeds);
    }

    /**
     * 查询不到　ｎｕｌｌ， 查询结果为ｉｄ
     */
    @Test
    public void findLikedByNidUid() throws Exception{
        Integer id = likedManagerMapper.findLikedByNidUid(1, 2);
        System.out.printf("点赞测试结果　："+id);
    }


}
