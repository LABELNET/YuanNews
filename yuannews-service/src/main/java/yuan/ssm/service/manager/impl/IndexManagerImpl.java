package yuan.ssm.service.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yuan.ssm.common.util.FileTool;
import yuan.ssm.dao.manager.ManagerCountMapper;
import yuan.ssm.service.manager.IndexManager;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 业务层　－　后台管理 － 主页业务层 - 接口实现
 */
public class IndexManagerImpl implements IndexManager{


    @Autowired
    private ManagerCountMapper managerCountMapper;

    /**
     * 得到总数
     * @param type
     * @return
     * @throws Exception
     */
    public Integer getCount(Integer type) throws Exception {
        switch (type){
            case 2:
                return managerCountMapper.findCount(2).getAllCount(); //新闻
            case 5:
                return managerCountMapper.findCount(5).getAllCount(); //兴趣标签
            case 3:
                return managerCountMapper.findCount(3).getAllCount(); //评论总数
            case 1:
                return managerCountMapper.findCount(1).getAllCount();//用户总数
            default:
                return managerCountMapper.findCount(2).getAllCount();
        }
    }

    /**
     * 得到日志集合
     * @return
     * @throws Exception
     */
    public List<String> getLogs() throws Exception {
        return FileTool.readData();
    }


}
