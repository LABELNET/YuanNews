package yuan.ssm.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import yuan.ssm.common.util.DateUtil;
import yuan.ssm.common.util.FontImageUtil;
import yuan.ssm.common.util.StringUtil;
import yuan.ssm.dao.customer.NewsMapper;
import yuan.ssm.dao.customer.UserMapper;
import yuan.ssm.dao.manager.ManagerCountMapper;
import yuan.ssm.other.CommentJo;
import yuan.ssm.pojo.NewsCustom;
import yuan.ssm.service.customer.UserService;
import yuan.ssm.vo.TasteVo;
import yuan.ssm.vo.UserVo;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by yuan on 16-4-4.
 * 业务层－用户端－用户服务- 接口实现
 */
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private ManagerCountMapper managerCountMapper;

    //检查账户是否存在
    public boolean isCheckUnum(String unum) throws Exception {
        Integer integer = userMapper.CheckUserUnum(unum);
        if(integer==null){
            return true;
        }else {
           return integer>0;
        }
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
        if(unum==null){
            return -2;
        }
        if(isCheckUnum(unum)){
            String  head="/image/head/moren.jpg";
            try {
                String imgName = DateUtil.getDateFileName()+ UUID.randomUUID() +".png";
                String font= StringUtil.getCharString(nick);
                FontImageUtil.createImage(font,imgName);
                head="/image/head/"+imgName;
            }catch (Exception e){
            }
           return userMapper.registerUser(unum,pass,nick,head);
        }
        return -1;
    }

    //查询兴趣标签是否存在
    public boolean userCheckTaste(String label, Integer id) throws Exception {
        Integer integer = userMapper.userCheckTaste(label, id);
        if(integer==null){
            return false;
        }else{
            return integer>0;
        }
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
    public Set<String> selectTaste(Integer start, Integer num, Integer uid) throws Exception {
        Set<String> tastes = userMapper.selectTaste(start, num, uid);
        if(uid!=0){
            //根据用户的兴趣进行全部兴趣的去重操作
            List<TasteVo> tasteVos = userSelectTasteById(uid);
            for (TasteVo tasteVo: tasteVos){
                if(tastes.contains(tasteVo.getLabel())){
                    tastes.remove(tasteVo.getLabel());
                }
            }
        }
        return tastes;
    }

    /**
     * 查询总数
     * @return
     * @throws Exception
     */
    public Integer selectTasteCount() throws Exception {
        return managerCountMapper.findCount(5).getAllCount();
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

    public NewsCustom selectNewsDetailById(Integer nid) throws Exception {
        return newsMapper.findNewsDetailById(nid);
    }

    public List<String> selectLikedByNid(Integer nid) throws Exception {
        return newsMapper.findLikedByNid(nid);
    }

    public List<CommentJo> selectComments(Integer start, Integer num, Integer nid) throws Exception {
        return newsMapper.findComment(start, num, nid);
    }

    public Integer selectZanStatus(Integer uid, Integer nid) throws Exception {
        Integer integer = userMapper.userZanStatus(uid, nid);
        if(integer==null){
            return 0;
        }else{
            return integer;
        }
    }
}
