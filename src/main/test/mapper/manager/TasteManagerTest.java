package mapper.manager;

import cn.hpu.yuan.ssm.mapper.manager.TasteManagerMapper;
import cn.hpu.yuan.ssm.model.vo.TasteVo;
import common.MapperContanst;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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

    /**
     * 根据兴趣id 查询兴趣信息
     */
    @Test
    public void findTasteById(){
        TasteVo tasteById = tasteManagerMapper.findTasteById(1);
        System.out.printf("兴趣管理测试结果 ： "+tasteById.toString());
    }

    /**
     * 根据用户id 查询用户兴趣
     */
    @Test
    public void findTastesByUid(){
        List<TasteVo> voList = tasteManagerMapper.findTastesByUid(1);
        System.out.printf("兴趣管理测试结果 ： "+voList.toString());
    }

    /**
     * 分页查询，兴趣信息
     */
    @Test
    public void findTasteList(){
        List<TasteVo> voList = tasteManagerMapper.findTasteList(0,3);
        System.out.printf("兴趣管理测试结果 ： "+voList.toString());
    }


    /**
     * 根据用户兴趣，查询用户id
     */

    @Test
    public void findTasteByLabel(){
        List<Integer> tasteByLabel = tasteManagerMapper.findTasteByLabel("小米");
        System.out.printf("兴趣管理测试结果 ： "+tasteByLabel.toString());
    }

    /**
     * 根据用户兴趣和用户id 查询，兴趣信息
     * 失败 返回 null,等于null ，则该用户不存在该兴趣
     */
    @Test
    public void findTasteByUidAndLabel(){
        Integer id = tasteManagerMapper.findTasteByUidAndLabel("小米", 100);
        System.out.printf("兴趣管理测试结果 ： "+id +(id>0?"存在":"不存在"));
    }


    /**
     * 根据用户id 和 兴趣 添加记录
     * 注意 uid 是否存在，存在 ，才使其添加到记录
     */
    @Test
    public void insertTasteByUidAndLabel(){
        Integer id = tasteManagerMapper.insertTasteByUidAndLabel("小米",2);
        System.out.printf("兴趣管理测试结果 ： "+id +(id>0?"成功":"不成功"));
    }


    /**
     * 根据兴趣id 修改 兴趣信息
     */
    @Test
    public void updateTasteById(){
        Integer id = tasteManagerMapper.updateTasteById("华为",12);
        System.out.printf("兴趣管理测试结果 ： "+id +(id>0?"成功":"不成功"));
    }

    /**
     * 删除兴趣信息
     */
    @Test
    public void deleteTasteById(){
        Integer[] ids={7,8,9,12};
        for (int id : ids){
            Integer result = tasteManagerMapper.deleteTasteById(id);
            System.out.printf("兴趣管理测试结果 ： "+result +(result>0?"成功":"不成功"));
        }
    }






}
