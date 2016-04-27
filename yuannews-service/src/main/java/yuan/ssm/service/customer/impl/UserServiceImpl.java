package yuan.ssm.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yuan.ssm.dao.customer.UserMapper;
import yuan.ssm.service.customer.UserService;
import yuan.ssm.vo.TasteVo;
import yuan.ssm.vo.UserVo;

import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 业务层－用户端－用户服务- 接口实现
 */
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    //检查账户是否存在
    public boolean isCheckUnum(String unum) throws Exception {
        return userMapper.CheckUserUnum(unum)>0;
    }

    //用户登陆
    public UserVo userLogin(String unum, String pass) throws Exception {
        if(isCheckUnum(unum)){
            return userMapper.loginCheckPass(unum,pass);
        }
       return null;
    }

    //注册
    public Integer userRegister(String unum, String pass, String nick) throws Exception {
        if(isCheckUnum(unum)){
           return userMapper.registerUser(unum,pass,nick);
        }
        return -1;
    }

    //查询兴趣标签是否存在
    public boolean userCheckTaste(String label, Integer id) throws Exception {
        return userMapper.userCheckTaste(label,id)>0;
    }

    //添加兴趣标签
    public Integer userAddTasteLabel(String label, Integer id) throws Exception {
        return userMapper.userAddTasteLabel(label,id);
    }

    //查询兴趣标签总数
    public Integer userSelectTasteCount(Integer id) throws Exception {
        return userMapper.userSelectTasteCount(id);
    }

    //查询用户所有兴趣
    public List<TasteVo> userSelectTasteById(Integer id) throws Exception {
        return userMapper.userSelectTasteById(id);
    }

    //删除用户兴趣
    public Integer userDeleteTasteById(Integer tid) throws Exception {
        return userMapper.userDeleteTaste(tid);
    }


    //分页查询所有兴趣标签
    public List<TasteVo> selectTaste(Integer start, Integer num) throws Exception {
        return null;
    }

    //点赞
    public Integer userZanNews(Integer uid, Integer nid, Integer status) throws Exception {
        if(status==0){
           return userMapper.userNewsZan(uid,nid);
        }else if(status==1){
            return userMapper.userNewsSuperZan(uid,nid);
        }
        return -1;
    }

    //评论
    public Integer userCommentNews(Integer uid, Integer nid, String content) throws Exception {
        return userMapper.userNewsComment(uid, nid, content);
    }
}
