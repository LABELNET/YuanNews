package yuan.ssm.service.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yuan.ssm.common.status.UpdateStatus;
import yuan.ssm.dao.manager.SourceManagerMapper;
import yuan.ssm.other.PageJo;
import yuan.ssm.service.manager.SourceManager;
import yuan.ssm.vo.SourceVo;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 业务层　－　后台管理 － 来源管理 - 接口实现
 */
public class SourceManagerImpl implements SourceManager{


    @Autowired
    private SourceManagerMapper sourceManagerMapper;


    /**
     * 新闻来源　分页查询，
     * @param start　开始位置
     * @param num　数量
     * @return
     * @throws Exception
     */
    public List<SourceVo> managerFindList(Integer start, Integer num) throws Exception {
        return sourceManagerMapper.findSources(start,num);
    }

    /**
     * 查询单个来源信息
     * @param id　查询的id
     * @return
     * @throws Exception
     */
    public SourceVo managerFindOne(Integer id) throws Exception {
        if(id<0){
            id=1;
        }
        return sourceManagerMapper.findSourceOne(id);
    }

    /**
     * 新添加一个来源信息
     * @param sourceVo　来源信息模型
     * @return
     * @throws Exception
     */
    public Integer managerInsertOne(SourceVo sourceVo) throws Exception {
        if(sourceVo==null){
            return UpdateStatus.UPDATE_FAIL;
        }
        return sourceManagerMapper.insertSource(sourceVo.getSource());
    }

    /**
     * 修改信息
     * @param sourceVo　来源信息模型
     * @return
     * @throws Exception
     */
    public Integer managerUpdateOne(SourceVo sourceVo) throws Exception {
        if(sourceVo==null){
            return UpdateStatus.UPDATE_FAIL;
        }
        return sourceManagerMapper.updateSourceContent(sourceVo.getId(),sourceVo.getSource());
    }

    /**
     * 删除信息
     * @param id　删除的信息id
     * @return
     * @throws Exception
     */
    public Integer managerDeleteOne(Integer id) throws Exception {
        if(id<0){
            return id;
        }
        return sourceManagerMapper.deleteSourceContent(id);
    }

    /**
     * 查询来源信息总数（这里不实现，不需要分页）
     * @return
     * @throws Exception
     */
    public PageJo managerFindCount() throws Exception {
        return null;
    }


}
