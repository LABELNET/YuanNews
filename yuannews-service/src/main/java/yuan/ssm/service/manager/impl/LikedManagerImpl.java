package yuan.ssm.service.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yuan.ssm.common.status.ManagerConutStatus;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.dao.manager.LikedManagerMapper;
import yuan.ssm.dao.manager.ManagerCountMapper;
import yuan.ssm.other.PageJo;
import yuan.ssm.pojo.LikedPo;
import yuan.ssm.service.manager.LikedManager;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 业务层　－　后台管理 － 点赞管理 - 接口实现
 */
public class LikedManagerImpl implements LikedManager {

    @Autowired
    private LikedManagerMapper likedManagerMapper;

    @Autowired
    private ManagerCountMapper managerCountMapper;


    /**
     * 点赞，分页查询
     * @param start　开始位置
     * @param num　数量
     * @return
     * @throws Exception
     */
    public List<LikedPo> managerFindList(Integer start, Integer num) throws Exception {
        return likedManagerMapper.findLikeds(start,num);
    }


    /**
     * 删除某个点赞信息
     * @param id　删除的信息id
     * @return
     * @throws Exception
     */
    public Integer managerDeleteOne(Integer id) throws Exception {
        Integer likeds = likedManagerMapper.deleteLikeds(id);
        LoggerUtil.print(likeds);
        return likeds;
    }

    /**
     * 点赞总数
     * @return
     * @throws Exception
     */
    public PageJo managerFindCount() throws Exception {
        return managerCountMapper.findCount(ManagerConutStatus.MANAGER_LIKED_COUNT_TYPE);
    }

    /**
     * 下面的方法没有使用，业务需求不需要
     * @deprecated
     * @param id　查询的id
     * @return
     * @throws Exception
     */
    public LikedPo managerFindOne(Integer id) throws Exception {
        return null;
    }

    /**
     * @deprecated 业务不需要
     * @param likedPo
     * @return
     * @throws Exception
     */
    public Integer managerInsertOne(LikedPo likedPo) throws Exception {
        return null;
    }

    /**
     * @deprecated  业务不需要
     * @param likedPo
     * @return
     * @throws Exception
     */
    public Integer managerUpdateOne(LikedPo likedPo) throws Exception {
        return null;
    }

}
