package yuan.ssm.service.customer;

import yuan.ssm.other.PageJo;
import yuan.ssm.other.PageVo;
import yuan.ssm.pojo.NewsCustom;
import yuan.ssm.service.base.ServiceBase;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 业务层－用户端－新闻服务接口
 */
public interface NewsService extends ServiceBase<NewsCustom> {

    /**
     * 其他拓展在此实现 ：
     * 1.搜索
     * 2.详情页
     */

    /**
     * 普通点赞
     * @param pageVo
     * @return
     * @throws Exception
     */
    List<NewsCustom> getIdNews(PageVo pageVo) throws Exception;

    /**
     * 阅读
     * @param pageVo
     * @return
     * @throws Exception
     */
    List<NewsCustom> getRnumNews(PageVo pageVo) throws Exception;

    /**
     * 评论
     * @param pageVo
     * @return
     * @throws Exception
     */
    List<NewsCustom> getCommentNews(PageVo pageVo) throws Exception;

    /**
     * 点赞
     * @param pageVo
     * @return
     * @throws Exception
     */
    List<NewsCustom> getZanNews(PageVo pageVo) throws Exception;

    /**
     * 总数
     * @return
     * @throws Exception
     */
    PageJo getNewsCount() throws Exception;

    /**
     * 某个新闻的阅读量+1
     * @param nid 新闻id
     * @return
     * @throws Exception
     */
    Integer updateNewsRnum(Integer nid) throws Exception;


    /**
     * 根据新闻的id进行批量查询
     * @param nids
     * @return
     * @throws Exception
     */
    List<NewsCustom> getNidsNews(List<Integer> nids) throws Exception;


}
