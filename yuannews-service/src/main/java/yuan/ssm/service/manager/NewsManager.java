package yuan.ssm.service.manager;

import yuan.ssm.pojo.NewsPo;
import yuan.ssm.pojo.NewsPoCustom;
import yuan.ssm.service.base.ManagerBase;
import yuan.ssm.vo.NewsVo;

/**
 * Created by yuan on 16-4-4.
 * 业务层　－　后台管理－ 新闻管理
 */
public interface NewsManager extends ManagerBase<NewsPo>{

    /**
     * 其他业务方法在此拓展实现
     */

    //添加新闻信息
    Integer managerInsertNews(NewsVo newsVo) throws Exception;

    //根据新闻id，查询新闻内容
    String managerFindNewsContent(Integer id) throws Exception;

    //返回单条新闻内容，包括分类（id,content）,来源（id,source）
    NewsPoCustom managerFindNews(Integer id) throws Exception;


}
