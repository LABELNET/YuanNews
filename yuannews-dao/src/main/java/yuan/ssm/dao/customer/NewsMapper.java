package yuan.ssm.dao.customer;

import org.apache.ibatis.annotations.Param;
import yuan.ssm.other.CommentJo;
import yuan.ssm.pojo.NewsCustom;
import yuan.ssm.vo.CateVo;
import yuan.ssm.vo.LikedVo;
import yuan.ssm.vo.SourceVo;

import java.util.List;
import java.util.Set;

/**
 * Created by yuan on 16-4-4.
 * 用户端－新闻mapper接口
 */
public interface NewsMapper {


    /**
     * 推荐原理：
     *      推荐模块计算共分为三部分：

            点赞：相同兴趣的用户，点赞了那些文章；

            评论：相同兴趣的用户，评论了那些文章；

             兴趣标签：检索
     */

    /**
     * 01.点赞表：根据用户id查询新闻id
     */
    Set<Integer> findZanNid(@Param("uid") Integer uid) throws Exception;

    /**
     * 02.评论表：根据用户id ，查询评论的新闻id
     * @param uid
     * @return
     * @throws Exception
     */
    Set<Integer> findCommentNid(@Param("uid") Integer uid) throws Exception;

    /**
     * 03.新闻表：根据用户兴趣，模糊查询新闻id
     * @param label 兴趣标签
     * @return
     * @throws Exception
     */
    Set<Integer> findNewsByLabel(@Param("label") String label) throws Exception;

    /**
     * 04.根据新闻ids，批量查询新闻
     * @param list
     * @return
     * @throws Exception
     */
    List<NewsCustom> findNewsByIds(@Param("list") List<Integer> list) throws Exception;


    //--------------------------------上面是推荐的mapper,下面是普通信息展示----------------------------------


    /**
     * 查询所有的分类信息
     *
     */
    List<CateVo> findAllCates() throws Exception;

    /**
     * 查询所有的来源信息
     * @return
     * @throws Exception
     */
    List<SourceVo> findAllSources() throws Exception;



    /**
     * 新闻主界面信息显示查询，id排序
     * @param start 开始
     * @param num 总数
     * @return List
     * @throws Exception
     */
    List<NewsCustom> findNewsCustom(@Param("start") Integer start,@Param("num") Integer num) throws Exception;



    /**
     * 点赞高低排序查询
     * @param start
     * @param num
     * @return
     * @throws Exception
     */
    List<NewsCustom> findNewsCustomByZan(@Param("start") Integer start,@Param("num") Integer num) throws Exception;


    /**
     * 评论高低排序
     * @param start
     * @param num
     * @return
     * @throws Exception
     */
    List<NewsCustom> findNewsCustomByComment(@Param("start") Integer start,@Param("num") Integer num) throws Exception;


    /**
     * 按照阅读量进行排序
     * @param start
     * @param num
     * @return
     * @throws Exception
     */
    List<NewsCustom> findNewsCustomByRnum(@Param("start") Integer start,@Param("num") Integer num) throws Exception;


  //------------------------------------新闻详情页面--------------------------------------------------

    /**
     * 查询策略：
     *   1.不分，直接根据id查询，返回NewsCustom对象
     *   2.查询新闻的点赞的用户头像
     *   3.评论内容
     */

    /**
     * 根据id查询新闻
     * @param nid 新闻id
     * @return
     * @throws Exception
     */
    NewsCustom findNewsDetailById(@Param("nid") Integer nid) throws Exception;


    /**
     * 根据新闻id，查询所有的点赞用户头像
     * @param nid 新闻id
     * @return
     * @throws Exception
     */
    List<String> findLikedByNid(@Param("nid")Integer nid) throws Exception;

    /**
     * 根据新闻id，查询所有的点赞用户信息
     * @param nid
     * @return
     * @throws Exception
     */
    List<LikedVo> findLikedNid(@Param("nid")Integer nid) throws Exception;

    /**
     * 根据新闻
     * @param start 开始
     * @param num 数量
     * @param nid 新闻id
     * @return
     * @throws Exception
     */
    List<CommentJo> findComment(@Param("start")Integer start, @Param("num")Integer num, @Param("nid")Integer nid) throws Exception;


    Integer updateNewsRnum(@Param("nid") Integer nid) throws Exception;


}
