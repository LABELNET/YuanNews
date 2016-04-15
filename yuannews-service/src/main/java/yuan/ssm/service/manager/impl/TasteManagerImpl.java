package yuan.ssm.service.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yuan.ssm.common.status.ManagerConutStatus;
import yuan.ssm.dao.manager.ManagerCountMapper;
import yuan.ssm.dao.manager.TasteManagerMapper;
import yuan.ssm.other.PageJo;
import yuan.ssm.service.manager.TasteManager;
import yuan.ssm.vo.TasteVo;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 业务层　－　后台管理 － 兴趣管理 - 接口实现
 */
public class TasteManagerImpl implements TasteManager{


    @Autowired
    private TasteManagerMapper tasteManagerMapper;

    @Autowired
    private ManagerCountMapper managerCountMapper;


    /**
     * 分页获得
     * @param start 开始
     * @param num　总数
     * @return
     * @throws Exception
     */
    public List<TasteVo> managerTasteList(Integer start, Integer num) throws Exception {
        return tasteManagerMapper.findTasteList(start,num);
    }

    /**
     * 获取单个兴趣信息
     * @param id　兴趣id
     * @return 兴趣实体
     * @throws Exception
     */
    public TasteVo managerTaste(Integer id) throws Exception {
        return tasteManagerMapper.findTasteById(id);
    }

    /**
     * 添加兴趣信息
     * @param label　兴趣内容
     * @param uid　　用户id
     * @return 1,0
     * @throws Exception
     */
    public Integer managerInsertTaste(String label, Integer uid) throws Exception {
        return tasteManagerMapper.insertTasteByUidAndLabel(label,uid);
    }

    /**
     * 删除兴趣id
     * @param id 兴趣id
     * @return 1,0
     * @throws Exception
     */
    public Integer managerDeleteTaste(Integer id) throws Exception {
        return tasteManagerMapper.deleteTasteById(id);
    }

    /**
     * 更新兴趣
     * @param label 兴趣内容
     * @param id　１,0
     * @return １，0
     */
    public Integer managerUpdateTaste(String label, Integer id) throws Exception{
        return tasteManagerMapper.updateTasteById(label,id);
    }

    /**
     * 查询请求总数
     * @return
     * @throws Exception
     */
    public PageJo managerTasteCount() throws Exception{
        return managerCountMapper.findCount(ManagerConutStatus.MANAGER_TASTE_COUNT_TYPE);
    }

}
