package cn.hpu.yuan.ssm.controller;

import cn.hpu.yuan.ssm.common.LoggerUtil;
import cn.hpu.yuan.ssm.common.LoginStatus;
import cn.hpu.yuan.ssm.controller.constant.ManagerConstant;
import cn.hpu.yuan.ssm.service.manager.UserManager;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


/**
 * Created by yuan on 16-4-4.
 * 　控制器　－　后台管理　
 */

@Controller
public class ManagerController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private  ObjectMapper mapperJson;

    /**
     * 管理员登陆　action
     * @param unum
     * @param pass
     * @return
     */
    @RequestMapping(value = "/managerLogin",method= RequestMethod.POST)
    public @ResponseBody Integer managerLogin(HttpSession httpSession, @RequestParam String unum, @RequestParam String pass){
        LoggerUtil.print(ManagerConstant.LOG_MANAGER_CONTROLLER,unum,pass);
        try {
            Integer uid = userManager.managerLogin(unum, pass);
            if(uid>0){
                httpSession.setAttribute("uid",uid);
            }
            return uid;
        } catch (Exception e) {
            //异常处理
            e.printStackTrace();
            LoggerUtil.print(e.getMessage());
        }
        return LoginStatus.Login_ERROR;
    }

    /**
     * 后台主页面
     */
    @RequestMapping(value = "/managerIndex",method = RequestMethod.GET)
    public String managerIndex(@RequestParam Integer uid){
        LoggerUtil.print("主页　用户id : "+uid);
        //TODO 后台主页实现
        return ManagerConstant.MANAGER_INDEX;
    }

    /**
     * 管理员－登出
     */

    @RequestMapping("/managerLoginOut")
    public String managerLoginOut(HttpSession httpSession){
        httpSession.invalidate();
        //TODO 登出后转向哪里
        return ManagerConstant.MANAGER_INDEX;
    }


}
