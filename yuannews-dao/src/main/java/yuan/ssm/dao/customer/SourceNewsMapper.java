package yuan.ssm.dao.customer;

import org.apache.ibatis.annotations.Param;
import yuan.ssm.pojo.NewsCustom;

import java.util.List;

/**
 * ==================================================
 * <p/>
 * 版权：　软件工程.net12-1 原明卓
 * <p/>
 * 项目：　基于用户兴趣标签的新闻推荐系统
 * <p/>
 * 作者：　原明卓
 * <p/>
 * 版本：　1.0
 * <p/>
 * 创建日期：　16-4-25 下午11:44
 * <p/>
 * 功能描述： 实现来源新闻信息查询
 * 1.id
 * 2.点赞
 * 3.评论
 * 4.阅读
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public interface SourceNewsMapper {

    /**
     * 根据来源，查询新闻信息,id倒序输出
     * @param start 开始
     * @param num 数量
     * @param source 来源
     * @return 新闻信息集合
     * @throws Exception
     */
    List<NewsCustom> findNewsBySourceId(@Param("start") Integer start, @Param("num") Integer num, @Param("source") String source) throws Exception;


    /**
     * 根据来源，查询新闻信息,点赞倒序输出
     * @param start 开始
     * @param num 数量
     * @param source 来源
     * @return 新闻信息集合
     * @throws Exception
     */
    List<NewsCustom> findNewsBySourceZan(@Param("start") Integer start, @Param("num") Integer num, @Param("source") String source) throws Exception;

    /**
     * 根据来源，查询新闻信息,评论倒序输出
     * @param start 开始
     * @param num 数量
     * @param source 来源
     * @return 新闻信息集合
     * @throws Exception
     */
    List<NewsCustom> findNewsBySourceComment(@Param("start") Integer start, @Param("num") Integer num, @Param("source") String source) throws Exception;


    /**
     * 根据来源，查询新闻信息,阅读量倒序输出
     * @param start 开始
     * @param num 数量
     * @param source 来源
     * @return 新闻信息集合
     * @throws Exception
     */
    List<NewsCustom> findNewsBySourceRnum(@Param("start") Integer start, @Param("num") Integer num, @Param("source") String source) throws Exception;




}
