package cn.hpu.yuan.ssm.mapper.manager;

import cn.hpu.yuan.ssm.model.vo.NewsVo;
import java.util.List;

/**
 * Created by yuan on 16-4-1.
 * 后台管理 - 新闻管理 - mapper接口
 */
public interface NewsManagerMapper {

    //根据新闻id，查询新闻（不要内容）
    NewsVo findNewsById(Integer id);
    //分页查询新闻 （不要内容）： 以id倒序排列
    List<NewsVo> findNews(Integer start,Integer num);
    //根据新闻id , 查询新闻内容
    String findNewsContentById(Integer id);
    //根据分类，分页查询新闻（不要内容）
    List<NewsVo> findNewsByCate(Integer start, Integer num,Integer cid);
    //根据来源，分页查询新闻（不要内容）


    //根据新闻id ， 修改新闻阅读量
    //根据新闻id,修改新闻标题
    //根据新闻id, 修改新闻来源
    //根据新闻id，修改新闻图片
    //根据新闻id,修改新闻时间
    //根据新闻id,修改分类

    //根据新闻id,删除新闻

    //手动添加新闻（前期）

}
