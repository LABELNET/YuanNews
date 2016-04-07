package yuan.ssm.dao.manager;

import yuan.ssm.other.PageJo;

/**
 * Created by yuan on 16-4-7.
 * 数据层－后台管理－统计相关的mapper
 */
public interface ManagerCountMapper {

    /**
     * 分页信息：　
     *　用户，新闻，评论，点赞，兴趣　：
     * 目前：　查询总数即可，后续需要拓展的话，编写PageJo类和mapper.xml
     */
    PageJo findUserCount() throws Exception;

    PageJo findNewsCount() throws Exception;

    PageJo findCommentCount() throws Exception;

    PageJo findLikedCount() throws Exception;

    PageJo findTasteCount() throws Exception;

    /**
     * ......
     */
}
