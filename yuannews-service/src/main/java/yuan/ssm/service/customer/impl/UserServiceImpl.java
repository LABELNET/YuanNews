package yuan.ssm.service.customer.impl;

import yuan.ssm.service.customer.UserService;
import yuan.ssm.vo.TasteVo;
import yuan.ssm.vo.UserVo;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 业务层－用户端－用户服务- 接口实现
 */
public class UserServiceImpl implements UserService {

    public boolean isCheckUnum(String unum) throws Exception {
        return false;
    }

    public UserVo userLogin(String unum, String pass) throws Exception {
        return null;
    }

    public Integer userRegister(String unum, String pass, String nick) throws Exception {
        return null;
    }

    public Integer userCheckTaste(String label, Integer id) throws Exception {
        return null;
    }

    public Integer userAddTasteLabel(String label, Integer id) throws Exception {
        return null;
    }

    public Integer userSelectTasteCount(Integer id) throws Exception {
        return null;
    }

    public List<TasteVo> userSelectTasteById(Integer id) throws Exception {
        return null;
    }

    public Integer userDeleteTasteById(Integer id, Integer tid) throws Exception {
        return null;
    }

    public List<TasteVo> selectTaste(Integer start, Integer num) throws Exception {
        return null;
    }

    public Integer userZanNews(Integer uid, Integer nid, Integer status) throws Exception {
        return null;
    }

    public Integer userCommentNews(Integer uid, Integer nid, String content) throws Exception {
        return null;
    }
}
