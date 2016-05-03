package mapper.manager;

import common.ManagerBaseTest;
import org.junit.Before;
import org.junit.Test;
import yuan.ssm.dao.manager.TasteManagerMapper;
import yuan.ssm.vo.TasteVo;

import java.util.List;
import java.util.Set;

/**
 * Created by yuan on 16-4-1.
 * 后台管理 - 兴趣管理 - 单元测试
 */
public class TasteManagerTest extends ManagerBaseTest{

    private TasteManagerMapper tasteManagerMapper;

    @Before
    public void setUp(){
        super.setUp();
        tasteManagerMapper= (TasteManagerMapper) context.getBean("tasteManagerMapper");
    }

    /**
     * 根据兴趣id 查询兴趣信息
     */
    @Test
    public void findTasteById() throws Exception{
        TasteVo tasteById = tasteManagerMapper.findTasteById(1);
        System.out.printf("兴趣管理测试结果 ： "+tasteById.toString());
    }

    /**
     * 根据用户id 查询用户兴趣
     */
    @Test
    public void findTastesByUid() throws Exception{
        List<TasteVo> voList = tasteManagerMapper.findTastesByUid(1);
        System.out.printf("兴趣管理测试结果 ： "+voList.toString());
    }

    /**
     * 分页查询，兴趣信息
     */
    @Test
    public void findTasteList() throws Exception{
        List<TasteVo> voList = tasteManagerMapper.findTasteList(0,3);
        System.out.printf("兴趣管理测试结果 ： "+voList.toString());
    }


    /**
     * 根据用户兴趣，查询用户id
     */

    @Test
    public void findTasteByLabel() throws Exception{
        Set<Integer> tasteByLabel = tasteManagerMapper.findTasteByLabel("大米");
        System.out.printf("兴趣管理测试结果 ： "+tasteByLabel.toString());
    }

    /**
     * 根据用户兴趣和用户id 查询，兴趣信息
     * 失败 返回 null,等于null ，则该用户不存在该兴趣
     */
    @Test
    public void findTasteByUidAndLabel() throws Exception{
        Integer id = tasteManagerMapper.findTasteByUidAndLabel("小米", 100);
        System.out.printf("兴趣管理测试结果 ： "+id +(id>0?"存在":"不存在"));
    }


    /**
     * 根据用户id 和 兴趣 添加记录
     * 注意 uid 是否存在，存在 ，才使其添加到记录
     */
    @Test
    public void insertTasteByUidAndLabel() throws Exception{
        Integer id = tasteManagerMapper.insertTasteByUidAndLabel("小米",2);
        System.out.printf("兴趣管理测试结果 ： "+id +(id>0?"成功":"不成功"));
    }


    /**
     * 根据兴趣id 修改 兴趣信息
     */
    @Test
    public void updateTasteById() throws Exception{
        Integer id = tasteManagerMapper.updateTasteById("华为",12);
        System.out.printf("兴趣管理测试结果 ： "+id +(id>0?"成功":"不成功"));
    }

    /**
     * 删除兴趣信息
     */
    @Test
    public void deleteTasteById() throws Exception{
        Integer[] ids={7,8,9,12};
        for (int id : ids){
            Integer result = tasteManagerMapper.deleteTasteById(id);
            System.out.printf("兴趣管理测试结果 ： "+result +(result>0?"成功":"不成功"));
        }
    }






}
