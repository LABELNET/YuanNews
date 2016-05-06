package yuan.ssm.service.manager;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 业务层　－　后台管理－主页业务层
 * 管理主页显示：　
 * １.用户总数，新闻总数，留言总数，兴趣总数统计
 * 2.最新的爬虫Log
 */
public interface IndexManager {


    /**
     * 获取总数
     * @param type
     * @return
     * @throws Exception
     */
    Integer getCount(Integer type) throws Exception;

    /**
     * 获取爬虫的日志信息
     * @return
     * @throws Exception
     */
    List<String> getLogs() throws Exception;

}
