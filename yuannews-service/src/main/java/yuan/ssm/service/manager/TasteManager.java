package yuan.ssm.service.manager;

import yuan.ssm.other.PageJo;
import yuan.ssm.vo.TasteVo;
import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 业务层－后台管理－兴趣接口添加
 */
public interface TasteManager {

    //分页查询
    List<TasteVo> managerTasteList(Integer start, Integer num) throws Exception;

    //查询单个
    TasteVo managerTaste(Integer id) throws Exception;

    //添加兴趣
    Integer managerInsertTaste(String label,Integer uid) throws Exception;

    //删除兴趣
    Integer managerDeleteTaste(Integer id) throws Exception;

    //修改兴趣
    Integer managerUpdateTaste(String label,Integer id) throws Exception;

    //获得兴趣总数
    PageJo managerTasteCount() throws Exception;


}
