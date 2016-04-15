package yuan.ssm.service.manager.impl;

import yuan.ssm.service.manager.TasteManager;
import yuan.ssm.vo.TasteVo;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 业务层　－　后台管理 － 兴趣管理 - 接口实现
 */
public class TasteManagerImpl implements TasteManager{
    public List<TasteVo> managerTasteList(Integer start, Integer num) throws Exception {
        return null;
    }

    public TasteVo managerTaste(Integer id) throws Exception {
        return null;
    }

    public Integer insertTaste(String label, Integer uid) throws Exception {
        return null;
    }

    public Integer deleteTaste(Integer id) throws Exception {
        return null;
    }

    public Integer updateTaste(String label, Integer id) {
        return null;
    }
}
