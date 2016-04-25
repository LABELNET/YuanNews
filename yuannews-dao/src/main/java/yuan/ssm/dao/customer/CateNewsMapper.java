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
 * 创建日期：　16-4-25 下午11:41
 * <p/>
 * 功能描述： 实现分类信息查询显示
 * 1.分类id 倒序排序输出
 * 2.点赞从高到底
 * 3.评论从高到底
 * 4.阅读量从高到底排序
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
public interface CateNewsMapper {


    /**
     * 根据分类，查询新闻信息,id倒序输出
     * @param start
     * @param num
     * @param cate
     * @return
     * @throws Exception
     */
    List<NewsCustom> findNewsByCateId(@Param("start") Integer start, @Param("num") Integer num,@Param("cate") String cate) throws Exception;


    /**
     * 根据分类，查询新闻信息,点赞倒序输出
     * @param start
     * @param num
     * @param cate
     * @return
     * @throws Exception
     */
    List<NewsCustom> findNewsByCateZan(@Param("start") Integer start, @Param("num") Integer num,@Param("cate") String cate) throws Exception;


    /**
     * 根据分类，查询新闻信息,评论数倒序输出
     * @param start
     * @param num
     * @param cate
     * @return
     * @throws Exception
     */
    List<NewsCustom> findNewsByCateComment(@Param("start") Integer start, @Param("num") Integer num,@Param("cate") String cate) throws Exception;


    /**
     * 根据分类，查询新闻信息,阅读量倒序输出
     * @param start
     * @param num
     * @param cate
     * @return
     * @throws Exception
     */
    List<NewsCustom> findNewsByCateRnum(@Param("start") Integer start, @Param("num") Integer num,@Param("cate") String cate) throws Exception;


}
