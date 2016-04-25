package yuan.ssm.dao.customer;

import org.apache.ibatis.annotations.Param;
import yuan.ssm.pojo.NewsCustom;
import yuan.ssm.vo.CateVo;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 用户端－新闻mapper接口
 */
public interface NewsMapper {

    /**
     * 01.查询与显示
    模糊查询　：　分别根据用户兴趣进行模糊查询，多个用户兴趣让其进行随机的获得兴趣，后进行查询
    但是最基本的根据兴趣查询新闻，在此实现；　
    分页查询；　根据阅读量，进行从高到低排序　，阅读量大于５０的
     */
//
//    //单个兴趣查询
//    List<NewsCustom> findNewsCustomByTaste(String taste,Integer start,Integer num);
//
//    //多个兴趣查询
 //   List<NewsCustom> findNewsCustomByTastes(String taste, String taste1, Integer start, Integer num);
//




    /**
     * 02. 推荐
     * １．推荐　兴趣标签　（相同用户的兴趣标签，出现次数多的）
     * ２．推荐　新闻　，阅读量小于５０的　
     * ３．推荐　相关用户（看做不做）
     */



    //--------------------------------上面是推荐的mapper,下面是普通信息展示----------------------------------

    /**
     * 新闻主界面信息显示查询，id排序
     * @param start 开始
     * @param num 总数
     * @return List
     * @throws Exception
     */
    List<NewsCustom> findNewsCustom(@Param("start") Integer start,@Param("num") Integer num) throws Exception;


    /**
     * 查询所有的分类信息
     *
     */
    List<CateVo> findAllCates() throws Exception;




}
