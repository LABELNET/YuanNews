package yuan.ssm.dao.manager;

import org.apache.ibatis.annotations.Param;
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
     * type :
     *    1. User
     *    2. News
     *    3. Comment
     *    4. Liked
     *    5. Taste
     */
    PageJo findUserCount(@Param("type") Integer type) throws Exception;

    /**
     * ......
     */
}
