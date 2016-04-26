package yuan.ssm.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yuan.ssm.common.newsenum.ServiceEnum;
import yuan.ssm.dao.customer.CateNewsMapper;
import yuan.ssm.dao.customer.NewsMapper;
import yuan.ssm.dao.customer.SourceNewsMapper;
import yuan.ssm.pojo.CSCustom;
import yuan.ssm.pojo.NewsCustom;
import yuan.ssm.service.customer.NewsService;

import java.util.List;

/**
 * Created by yuan on 16-4-4
 * 业务层－用户端－新闻服务- 接口实现
 */
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private CateNewsMapper cateNewsMapper;

    @Autowired
    private SourceNewsMapper sourceNewsMapper;

    /**
     * 查询分类和来源信息
     * @return
     * @throws Exception
     */
    public CSCustom findCateSourceIfo() throws Exception {
        CSCustom csCustom=new CSCustom();
        csCustom.setCateVos(csCustom.getCateVos());
        csCustom.setSourceVos(csCustom.getSourceVos());
        return csCustom;
    }

    /**
     * 查询新闻数据id倒序
     * @param start 开始
     * @param num 数量
     * @param cs 条件/分类或来源
     * @param type
     * @return
     * @throws Exception
     */
    public List<NewsCustom> findCustomById(Integer start, Integer num, String cs, ServiceEnum type) throws Exception {
        switch (type){
            case normal:
               return newsMapper.findNewsCustom(start, num);
            case cate:
               return cateNewsMapper.findNewsByCateId(start,num,cs);
            case source:
               return sourceNewsMapper.findNewsBySourceId(start,num,cs);
            default:
               return null;
        }

    }

    /**
     * @see #findCustomById
     * @param start 开始
     * @param num 数量
     * @param cs 条件/分类或来源
     * @param type
     * @return
     * @throws Exception
     */
    public List<NewsCustom> findCustomByZan(Integer start, Integer num, String cs, ServiceEnum type) throws Exception {

        switch (type){
            case normal:
                return newsMapper.findNewsCustomByZan(start,num);
            case cate:
                return cateNewsMapper.findNewsByCateZan(start,num,cs);
            case source:
                return sourceNewsMapper.findNewsBySourceZan(start,num,cs);
            default:
                return null;
        }
    }

    /**
     * @see #findCustomById
     * @param start 开始
     * @param num 数量
     * @param cs 条件/分类或来源
     * @param type
     * @return
     * @throws Exception
     */
    public List<NewsCustom> findCustomByComment(Integer start, Integer num, String cs, ServiceEnum type) throws Exception {

        switch (type){
            case normal:
                return newsMapper.findNewsCustomByComment(start,num);
            case cate:
                return cateNewsMapper.findNewsByCateComment(start,num,cs);
            case source:
                return sourceNewsMapper.findNewsBySourceComment(start,num,cs);
            default:
                return null;
        }
    }

    /**
     * @see #findCustomById
     * @param start 开始
     * @param num 数量
     * @param cs 条件/分类或来源
     * @param type
     * @return
     * @throws Exception
     */
    public List<NewsCustom> findCustomByRnum(Integer start, Integer num, String cs, ServiceEnum type) throws Exception {

        switch (type){
            case normal:
               return newsMapper.findNewsCustomByRnum(start,num);
            case cate:
                return cateNewsMapper.findNewsByCateRnum(start,num,cs);
            case source:
                return sourceNewsMapper.findNewsBySourceRnum(start,num,cs);
            default:
                return null;
        }


    }
}
