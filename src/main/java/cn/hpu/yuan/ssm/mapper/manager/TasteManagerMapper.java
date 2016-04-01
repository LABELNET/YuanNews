package cn.hpu.yuan.ssm.mapper.manager;

import cn.hpu.yuan.ssm.model.vo.TasteVo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by yuan on 16-4-1.
 * 用户兴趣管理
 *
 * 批量操作待定
 */
public interface TasteManagerMapper {

    /**
     * -----------------------------------
     * 查询
     */

    //根据兴趣id 查询 兴趣信息
    TasteVo findTasteById(Integer id);
    //根据用户id 查询 兴趣信息
    List<TasteVo> findTastesByUid(Integer id);
    //分页查询所有兴趣信息
    List<TasteVo> findTasteList(Integer start,Integer num);
    //根据兴趣查询 兴趣信息 返回多个用户id , id 进行从小到大排序
    List<Integer> findTasteByLabel(@Param("label") String label);
    //根据兴趣信息和用户id 查询是否具有改兴趣 , 查询id即可
    Integer findTasteByUidAndLabel(@Param("label") String label,@Param("uid") Integer uid);

    /**
     * ----------------------------------
     * 添加
     */
    //根据用户兴趣和用户id 进行添加
    Integer insertTasteByUidAndLabel(@Param("label") String label,@Param("uid") Integer uid);

    /**
     * ----------------------------------
     * 修改
     */
    //根据兴趣id 进行修改兴趣信息
    Integer updateTasteById(@Param("label") String label,@Param("id") Integer id);

    /**
     * ----------------------------------
     * 删除
     */
    //根据兴趣id ， 删除改兴趣 ，直接删除
    Integer deleteTasteById(Integer id);


}
