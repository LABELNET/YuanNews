package cn.hpu.yuan.ssm.mapper.manager;

import cn.hpu.yuan.ssm.model.vo.CateVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yuan on 16-4-1.
 * 数据访问层 - 分类管理
 */
public interface CateManagerMapper {

    //根据分类id，查询分类信息
    CateVo findCateById(Integer id) throws Exception;

    //获取全部分类信息
    List<CateVo> findCates() throws Exception;

    //修改分类信息
    Integer updateCate(@Param("id") Integer id,@Param("content") String content) throws Exception;

    //删除分类信息 : 管理的时候需要先判断是否存在正在使用的分类信息（在新闻中判断该分类下的新闻）
    Integer deleteCate(Integer id) throws Exception;

    //添加分类信息
    Integer insertCate(String content) throws Exception;

}
