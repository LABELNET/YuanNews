package yuan.ssm.service.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yuan.ssm.common.status.ManagerConutStatus;
import yuan.ssm.common.status.UpdateStatus;
import yuan.ssm.dao.manager.ManagerCountMapper;
import yuan.ssm.dao.manager.NewsManagerMapper;
import yuan.ssm.other.PageJo;
import yuan.ssm.pojo.NewsPo;
import yuan.ssm.service.manager.NewsManager;
import yuan.ssm.vo.NewsVo;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 业务层　－　后台管理 － 新闻管理 - 接口实现
 */
public class NewsManagerImpl implements NewsManager{


    @Autowired
    private NewsManagerMapper newsManagerMapper;

    @Autowired
    private ManagerCountMapper managerCountMapper;

    /**
     * 新闻分页查询
     * @param start　开始位置
     * @param num　数量
     * @return
     * @throws Exception
     */
    public List<NewsPo> managerFindList(Integer start, Integer num) throws Exception {
        return newsManagerMapper.findNews(start,num);
    }

    /**
     * 查询单条信息
     * @param id　查询的id
     * @return
     * @throws Exception
     */
    public NewsPo managerFindOne(Integer id) throws Exception {
        if(id<0){
           id=1;
        }
        return newsManagerMapper.findNewsById(id);
    }

    /**
     * 新增加一条 - 业务类型不符合
     * @deprecated
     * @param newsPo
     * @return
     * @throws Exception
     * @see #managerInsertNews(NewsVo)
     */
    public Integer managerInsertOne(NewsPo newsPo) throws Exception {
        return newsManagerMapper.insertNews(newsPo);
    }

    /**
     * 修改新闻信息
     * @param newsPo
     * @return
     * @throws Exception
     */
    public Integer managerUpdateOne(NewsPo newsPo) throws Exception {
        int status= UpdateStatus.UPDATE_FAIL;


        Integer id=newsPo.getId();
        if(id<=0){
            return status;
        }

        if(newsPo.getTitle()!=null){
            status=newsManagerMapper.updateNewsTitle(id,newsPo.getTitle());
        }

        if(newsPo.getSid()!=null || newsPo.getSid()!=0){
            status=newsManagerMapper.updateNewsSource(id,newsPo.getSid());
        }

        if (newsPo.getCid()!=null || newsPo.getCid()!=0){
            status=newsManagerMapper.updateNewsCate(id,newsPo.getCid());
        }

        if(newsPo.getDt()!=null){
            status=newsManagerMapper.updateNewsTime(id,newsPo.getDt());
        }

        return status;
    }

    /**
     * 删除新闻信息
     * @param id　删除的信息id
     * @return
     * @throws Exception
     */
    public Integer managerDeleteOne(Integer id) throws Exception {
        return newsManagerMapper.deleteNewsById(id);
    }

    /**
     * 分页，查询新闻总数
     * @return
     * @throws Exception
     */
    public PageJo managerFindCount() throws Exception {
        return managerCountMapper.findCount(ManagerConutStatus.MANAGER_NEWS_COUNT_TYPE);
    }

    /**
     * 新添加新闻
     * @param newsVo
     * @return
     * @throws Exception
     */
    public Integer managerInsertNews(NewsVo newsVo) throws Exception {
        return newsManagerMapper.insertNews(newsVo);
    }

}
