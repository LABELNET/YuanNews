package yuan.ssm.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import yuan.ssm.other.DataBean;
import yuan.ssm.service.customer.UserService;
import yuan.ssm.service.manager.UserManager;
import yuan.ssm.service.mobile.UserAppService;
import yuan.ssm.vo.UserVo;

/**
 * ==================================================
 * <p/>
 * 版权：　软件工程.net12-1 原明卓
 * <p/>
 * 项目：　基于用户兴趣标签的新闻推荐系统
 * <p/>
 * 作者：　原明卓
 * <p/>
 * 版本：　1.1
 * <p/>
 * 创建日期：　16-5-5 下午3:41
 * <p/>
 * 功能描述： Android 客户端　数据 接口API
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */

@Controller
@RequestMapping("api/")
public class AndroidController {

    @Autowired
    private UserService userService; //用户service

    @Autowired
    private UserManager userManager;//用户manager


    @Autowired
    private UserAppService userAppService;//用户特殊service

    /**
     * 01.用户登录接口
     * @param unum 账户
     * @param pass 密码
     * @return json
     */
    @RequestMapping("login")
    public @ResponseBody String login(@RequestParam String unum,@RequestParam String pass){
        DataBean<UserVo> bean = new DataBean<UserVo>();
        try {
            UserVo vo = userService.userLogin(unum, pass);
            if(vo==null){
                bean.setCode(-1);
                bean.setMsg("登录失败");
            }else{
                bean.setCode(0);
                bean.setMsg("登录成功");
                bean.setData(vo);
            }
        } catch (Exception e) {
            bean.setCode(-3);
            bean.setMsg("系统错误");
        }
        return JSON.toJSONString(bean);
    }


    /**
     * 02.用户注册
     * @param unum 账户
     * @param pass 密码
     * @param nick 昵称
     * @return json
     */
    @RequestMapping("register")
    public @ResponseBody String register(@RequestParam String unum,@RequestParam String pass,@RequestParam String nick){
        DataBean<UserVo> bean = new DataBean<UserVo>();
        try {
            Integer integer = userService.userRegister(unum, pass, nick);
            if(integer==-2){
                bean.setCode(-2);
                bean.setMsg("参数不正确");
            }

            if(integer==-1){
                bean.setCode(-1);
                bean.setMsg("账户已存在");
            }

            if(integer>0){
                bean.setCode(0);
                bean.setMsg("注册成功");
            }
        } catch (Exception e) {
            bean.setCode(-3);
            bean.setMsg("系统错误");
        }
        return JSON.toJSONString(bean);
    }


    /**
     * 03.修改用户的昵称，性别信息
     * @param userVo
     * @return
     */
    @RequestMapping("updateUserIfo")
    public @ResponseBody String updateUserIfo(@ModelAttribute UserVo userVo){
        DataBean<UserVo> bean = new DataBean<UserVo>();
        userVo.setStatus(-1);
        try {
            Integer integer = userManager.managerUpdateUserIfo(userVo);
            if(integer==-1){
                bean.setCode(-1);
                bean.setMsg("参数不正确");
            }

            if(integer==-2){
                bean.setCode(-2);
                bean.setMsg(" 用户 id 有误");
            }

            if(integer>0){
                bean.setCode(0);
                bean.setMsg("修改成功");
            }


        } catch (Exception e) {
            bean.setCode(-3);
            bean.setMsg("系统错误");
        }
        return JSON.toJSONString(bean);
    }












































}
