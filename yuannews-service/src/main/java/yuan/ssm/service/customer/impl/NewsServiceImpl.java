package yuan.ssm.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yuan.ssm.common.newsenum.ServiceEnum;
import yuan.ssm.dao.customer.CateNewsMapper;
import yuan.ssm.dao.customer.NewsMapper;
import yuan.ssm.dao.customer.SourceNewsMapper;
import yuan.ssm.dao.manager.ManagerCountMapper;
import yuan.ssm.other.PageJo;
import yuan.ssm.other.PageVo;
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

    @Autowired
    private ManagerCountMapper countMapper;


    private final int newsNormalType=6; //正常类型
    private final int newsCateType=7; //分类类型
    private final int newsSourceType=8; //来源类型

    /**
     * 查询分类和来源信息
     * @return
     * @throws Exception
     */
    public CSCustom findCateSourceIfo() throws Exception {
        CSCustom csCustom=new CSCustom();
        csCustom.setCateVos(newsMapper.findAllCates());
        csCustom.setSourceVos(newsMapper.findAllSources());
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

    /**
     * 普通查询
     * @param pageVo
     * @return
     * @throws Exception
     */
    public List<NewsCustom> getIdNews(PageVo pageVo) throws Exception {

        switch (pageVo.getnType()){
            case newsNormalType:
               return findId(pageVo,ServiceEnum.normal);
            case newsCateType:
                return findId(pageVo,ServiceEnum.cate);
            case newsSourceType:
                return findId(pageVo,ServiceEnum.source);
            default:
                return null;
        }
    }

    private List<NewsCustom> findId(PageVo pageVo,ServiceEnum serviceEnum) throws Exception {
       return findCustomById(pageVo.getStart(),pageVo.getNum(),pageVo.getTitle(),serviceEnum);
    }

    /**
     * 阅读量查询
     * @param pageVo
     * @return
     * @throws Exception
     */
    public List<NewsCustom> getRnumNews(PageVo pageVo) throws Exception {
        switch (pageVo.getnType()){
            case newsNormalType:
                return  findRnum(pageVo,ServiceEnum.normal);
            case newsCateType:
                return  findRnum(pageVo,ServiceEnum.cate);
            case newsSourceType:
                return findRnum(pageVo,ServiceEnum.source);
            default:
                return null;
        }
    }

    private List<NewsCustom> findRnum(PageVo pageVo, ServiceEnum cate) throws Exception {
       return findCustomByRnum(pageVo.getStart(),pageVo.getNum(),pageVo.getTitle(),cate);
    }


    /**
     * 评论数查询
     * @param pageVo
     * @return
     * @throws Exception
     */
    public List<NewsCustom> getCommentNews(PageVo pageVo) throws Exception {
        switch (pageVo.getnType()){
            case newsNormalType:
               return findComment(pageVo,ServiceEnum.normal);
            case newsCateType:
               return findComment(pageVo,ServiceEnum.cate);
            case newsSourceType:
               return findComment(pageVo,ServiceEnum.source);
            default:
                return null;
        }
    }

    private List<NewsCustom> findComment(PageVo pageVo, ServiceEnum normal) throws Exception {
        return findCustomByComment(pageVo.getStart(),pageVo.getNum(),pageVo.getTitle(),normal);
    }

    /**
     * 点赞数
     * @param pageVo
     * @return
     * @throws Exception
     */
    public List<NewsCustom> getZanNews(PageVo pageVo) throws Exception {
        switch (pageVo.getnType()){
            case newsNormalType:
                return findZan(pageVo,ServiceEnum.normal);
            case newsCateType:
                return findZan(pageVo,ServiceEnum.cate);
            case newsSourceType:
                return findZan(pageVo,ServiceEnum.source);
            default:
                return null;
        }
    }

    /**
     * 点赞查询
     * @param pageVo
     * @param source
     * @return
     * @throws Exception
     */
    private List<NewsCustom> findZan(PageVo pageVo, ServiceEnum source) throws Exception {
        return findCustomByZan(pageVo.getStart(),pageVo.getNum(),pageVo.getTitle(),source);
    }

    /**
     * 获取新闻总数
     * @return
     * @throws Exception
     */
    public PageJo getNewsCount() throws Exception {
        return countMapper.findCount(2);
    }

    /**
     * 修改新闻的阅读量
     * @param nid 新闻id
     * @return
     * @throws Exception
     */
    public Integer updateNewsRnum(Integer nid) throws Exception {
        return newsMapper.updateNewsRnum(nid);
    }


    /**
     * 获取新闻的列表-根据id，批量查询
     * @param nids 新闻id
     * @param type 查询类型
     * @return 数据
     * @throws Exception
     */
    public List<NewsCustom> getNidsNews(List<Integer> nids,Integer type) throws Exception {

        switch (type){
            case 2:
                return newsMapper.findNewsByIds(nids);
            case 3:
                return newsMapper.findNewsByRnum(nids);
            case 4:
                return newsMapper.findNewsByZan(nids);
            case 5:
                return newsMapper.findNewsByComment(nids);
            default:
                return newsMapper.findNewsByIds(nids);
        }
    }


}
