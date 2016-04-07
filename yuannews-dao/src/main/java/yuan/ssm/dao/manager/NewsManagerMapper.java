package yuan.ssm.dao.manager;

import org.apache.ibatis.annotations.Param;
import yuan.ssm.pojo.NewsPo;
import yuan.ssm.vo.NewsVo;

import java.util.List;

/**
 * Created by yuan on 16-4-1.
 * 后台管理 - 新闻管理 - mapper接口
 */
public interface NewsManagerMapper {


    /**
     * --------------------------------------
     * 查询
     */
    //根据新闻id，查询新闻（不要内容）
    NewsPo findNewsById(Integer id) throws Exception;
    //分页查询新闻 （不要内容）： 以id倒序排列
    List<NewsPo> findNews(Integer start, Integer num) throws Exception;
    //根据新闻id , 查询新闻内容
    String findNewsContentById(Integer id) throws Exception;
    //根据分类，分页查询新闻（不要内容）
    List<NewsPo> findNewsByCate(Integer start, Integer num,Integer cid) throws Exception;
    //根据来源，分页查询新闻（不要内容）
    List<NewsPo> findNewsBySource(Integer start, Integer num,Integer sid) throws Exception;


    /**
     * --------------------------------------
     * 修改
     */

    //根据新闻id ， 修改新闻阅读量
    Integer updateNewsRnum(Integer id,Integer rnum) throws Exception;
    //根据新闻id,修改新闻标题
    Integer updateNewsTitle(@Param("id") Integer id, @Param("title") String title) throws Exception;
    //根据新闻id, 修改新闻来源
    Integer updateNewsSource(Integer id,Integer sid) throws Exception;
    //根据新闻id，修改新闻图片
    Integer updateNewsImg(@Param("id") Integer id,@Param("img") String img) throws Exception;
    //根据新闻id,修改新闻时间
    Integer updateNewsTime(@Param("id") Integer id,@Param("dt") String dt) throws Exception;
    //根据新闻id,修改分类
    Integer updateNewsCate(Integer id,Integer cid) throws Exception;


    /**
     * --------------------------------------
     * 删除
     */
    //根据新闻id,删除新闻
    Integer deleteNewsById(Integer id) throws Exception;



    /**
     * --------------------------------------
     * 添加
     */
    //手动添加新闻（前期）
    Integer insertNews(NewsVo newsVo) throws Exception;

}
