package cn.hpu.yuan.ssm.mapper.manager;

import cn.hpu.yuan.ssm.model.pojo.LikedPo;
import java.util.List;

/**
 * Created by yuan on 16-4-3.
 * 后台管理 - 点赞管理 - mapper
 */
public interface LikedManagerMapper {

    //分页查询－　id排序　倒序输出　
    List<LikedPo> findLikeds(Integer start,Integer num);
    //分页查询－　根据用户id查询　－　id排序　倒序输出
    List<LikedPo> findLikedsByUid(Integer start,Integer num,Integer uid);
    //分页查询－　根据新闻id查询　－　id排序　倒序输出
    List<LikedPo> findLikedsByNid(Integer start,Integer num,Integer nid);

    //删除该条点赞
    Integer deleteLikeds(Integer id);

    //判断是否点过赞
    Integer findLikedByNidUid(Integer uid,Integer nid);
}
