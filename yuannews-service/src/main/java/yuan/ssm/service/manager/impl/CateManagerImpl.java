package yuan.ssm.service.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yuan.ssm.common.status.UpdateStatus;
import yuan.ssm.dao.manager.CateManagerMapper;
import yuan.ssm.dao.manager.ManagerCountMapper;
import yuan.ssm.other.PageJo;
import yuan.ssm.service.manager.CateManager;
import yuan.ssm.vo.CateVo;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 业务层　－　后台管理 － 分类管理 - 接口实现
 */
public class CateManagerImpl implements CateManager {


    @Autowired
    private CateManagerMapper cateManagerMapper;

    /**
     * 分类查询 - 全部分类信息，没有分页
     * @param start　开始位置
     * @param num　数量
     * @return
     * @throws Exception
     */
    public List<CateVo> managerFindList(Integer start, Integer num) throws Exception {
        return cateManagerMapper.findCates();
    }

    /**
     * 查询单条分类信息
     * @param id　查询的id
     * @return
     * @throws Exception
     */
    public CateVo managerFindOne(Integer id) throws Exception {
        return cateManagerMapper.findCateById(id);
    }

    /**
     *
     * @param cateVo
     * @return
     * @throws Exception
     */
    public Integer managerInsertOne(CateVo cateVo) throws Exception {
        if(cateVo.getContent()==null){
            return UpdateStatus.UPDATE_FAIL;
        }
        return cateManagerMapper.insertCate(cateVo.getContent());
    }

    /**
     * 更新一个
     * @param cateVo　分类实体
     * @return
     * @throws Exception
     */
    public Integer managerUpdateOne(CateVo cateVo) throws Exception {
        if (cateVo.getId()<=0){
            return UpdateStatus.UPDATE_ID_ZORE;
        }

        if(cateVo.getContent()==null){
            return UpdateStatus.UPDATE_FAIL;
        }
        return cateManagerMapper.updateCate(cateVo.getId(),cateVo.getContent());
    }

    /**
     * 分类删除实现
     * @param id　删除的信息id
     * @return
     * @throws Exception
     */
    public Integer managerDeleteOne(Integer id) throws Exception {
        return cateManagerMapper.deleteCate(id);
    }

    /**
     *　查询总数
     * @return
     * @throws Exception
     * @deprecated 业务不需要，没必要实现
     * @see CateManagerMapper
     */
    public PageJo managerFindCount() throws Exception {
        return null;
    }
}
