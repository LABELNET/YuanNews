package yuan.ssm.dao.customer;

import yuan.ssm.pojo.NewsCustom;

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

    //单个兴趣查询
    List<NewsCustom> findNewsCustomByTaste(String taste,Integer start,Integer num);

    //多个兴趣查询
    List<NewsCustom> findNewsCustomByTastes(String taste,String taste1,Integer start,Integer num);



    /**
     * 02. 推荐
     * １．推荐　兴趣标签　（相同用户的兴趣标签，出现次数多的）
     * ２．推荐　新闻　，阅读量小于５０的　
     * ３．推荐　相关用户（看做不做）
     */

    /**
     * 03.
     */




}
