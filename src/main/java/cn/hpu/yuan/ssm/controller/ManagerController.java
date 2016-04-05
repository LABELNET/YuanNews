package cn.hpu.yuan.ssm.controller;

import cn.hpu.yuan.ssm.common.LoggerUtil;
import cn.hpu.yuan.ssm.controller.constant.ManagerConstant;
import cn.hpu.yuan.ssm.model.vo.UserVo;
import cn.hpu.yuan.ssm.service.manager.UserManager;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;


/**
 * Created by yuan on 16-4-4.
 * 　控制器　－　后台管理　
 */
@RequestMapping(value = "/manager")
@Controller
public class ManagerController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private  ObjectMapper mapperJson;

    /**
     * 管理员登陆　action
     */
    @RequestMapping(value = "/managerLogin",method= RequestMethod.POST)
    public @ResponseBody Integer managerLogin(HttpSession httpSession, @RequestParam String unum, @RequestParam String pass) throws Exception {
        LoggerUtil.print(ManagerConstant.LOG_MANAGER_CONTROLLER,unum,pass);
        Integer uid = userManager.managerLogin(unum, pass);

            if(uid>0){
                httpSession.setAttribute(ManagerConstant.SESSION_ATTRIBUTE_KEY,uid);
            }

        return uid;
    }

    /**
     * 后台主页面
     */
    @RequestMapping(value = "/managerIndex",method = RequestMethod.GET)
    public ModelAndView managerIndex(HttpSession httpSession) throws Exception {
        Integer uid= (Integer) httpSession.getAttribute(ManagerConstant.SESSION_ATTRIBUTE_KEY);
        LoggerUtil.print("主页　用户id : "+uid);

        UserVo userVo = userManager.managerFindUserIfo(uid);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject(ManagerConstant.MANAGER_INDEX_MV_KEY,userVo);
        modelAndView.setViewName(ManagerConstant.MANAGER_INDEX);
        //TODO 后台主页实现
        return modelAndView;
    }

    /**
     * 管理员－登出
     * 登出转向　登陆页面
     */
    @RequestMapping("/managerLoginOut")
    public String managerLoginOut(HttpSession httpSession){
        httpSession.invalidate();
        return ManagerConstant.MANAGER_REDRICT_LOGIN;
    }

    /**
     * 后台管理－用户管理
     */
    public String managerUserPage(){




        return ManagerConstant.MAGAGER_USER_PAGE;
    }





}
