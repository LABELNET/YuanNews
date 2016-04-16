package yuan.ssm.service.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yuan.ssm.common.status.ManagerConutStatus;
import yuan.ssm.dao.manager.CommentManagerMapper;
import yuan.ssm.dao.manager.ManagerCountMapper;
import yuan.ssm.other.PageJo;
import yuan.ssm.pojo.CommentPo;
import yuan.ssm.service.manager.CommentManager;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 业务层　－　后台管理 － 评论管理 - 接口实现
 */
public class CommentManagerImpl implements CommentManager{


    @Autowired
    private CommentManagerMapper commentManagerMapper;

    @Autowired
    private ManagerCountMapper managerCountMapper;

    /**
     * 最简单的分页实现
     * @param start　开始位置
     * @param num　数量
     * @return
     * @throws Exception
     */
    public List<CommentPo> managerFindList(Integer start, Integer num) throws Exception {
        return commentManagerMapper.findComments(start,num);
    }

    /**
     * 查询单条评论信息
     * @param id　查询的id
     * @return
     * @throws Exception
     */
    public CommentPo managerFindOne(Integer id) throws Exception {
        return commentManagerMapper.findCommentById(id);
    }

    /**
     * @deprecated 业务不需要
     * @param commentPo
     * @return
     * @throws Exception
     */
    public Integer managerInsertOne(CommentPo commentPo) throws Exception {
        return null;
    }

    /**
     * @deprecated  业务不需要
     * @param commentPo
     * @return
     * @throws Exception
     */
    public Integer managerUpdateOne(CommentPo commentPo) throws Exception {
        return null;
    }

    /**
     * 伪删除，修改评论status为１
     * @param id　删除的信息id
     * @return
     * @throws Exception
     */
    public Integer managerDeleteOne(Integer id) throws Exception {
        return commentManagerMapper.updateCommentStatus(id,1);
    }

    /**
     * 得到评论总数
     * @return
     * @throws Exception
     */
    public PageJo managerFindCount() throws Exception {
        return managerCountMapper.findCount(ManagerConutStatus.MANAGER_COMMENT_COUNT_TYPE);
    }
}
