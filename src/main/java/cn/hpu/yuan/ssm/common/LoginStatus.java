package cn.hpu.yuan.ssm.common;

/**
 * Created by yuan on 16-4-5.
 * 用户登陆／管理员登陆　登陆状态
 */
public interface LoginStatus {

    //密码错误
    Integer PASS_ERROR=-1;

    //账号不存在
    Integer UNUM_NOT_HAVE=-2;

    //登陆失败
    Integer Login_ERROR=-3;
}
