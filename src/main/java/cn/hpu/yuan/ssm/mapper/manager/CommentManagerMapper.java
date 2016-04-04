package cn.hpu.yuan.ssm.mapper.manager;


import cn.hpu.yuan.ssm.model.pojo.CommentPo;
import java.util.List;

/**
 * Created by yuan on 16-4-3.
 * 后台管理 - 评论管理 - Mapper
 */
public interface CommentManagerMapper {

    /**
     * ----------------------------------
     * 查询
     */
    //根据id 查询评论信息
    CommentPo findCommentById(Integer id);

    //分页查询，评论信息，id 倒序输出
    List<CommentPo> findComments(Integer start,Integer num);
    //分页查询，根据新闻id ,　查询评论信息　，id倒序输出
    List<CommentPo> findCommentsByNid(Integer start,Integer num,Integer nid);
    //分页查询，根据用户id ,　查询评论信息　,id倒序输出
    List<CommentPo> findCommentsByUid(Integer start,Integer num,Integer uid);


    /**
     * ----------------------------------
     * 删除
     */
    //伪删除：修改评论status＝１
    Integer updateCommentStatus(Integer id,Integer status);






}
