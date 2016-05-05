package yuan.ssm.service.mobile;

/**
 * Created by yuan on 16-4-4.
 * 服务层　－　移动端　－　用户接口
 */
public interface UserAppService {

    //修改密码
    Integer updateUserPass(Integer id,String newPass) throws Exception;

    //修改头像
    Integer updateUserHead(Integer id,String newHead) throws Exception;

}
