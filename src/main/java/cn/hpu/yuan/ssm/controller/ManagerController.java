package cn.hpu.yuan.ssm.controller;

import cn.hpu.yuan.ssm.service.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yuan on 16-4-4.
 * 　控制器　－　后台管理　
 */

@Controller
public class ManagerController {

    private static final String MANAGER_INDEX="manager/index";

    @Autowired
    private UserManager userManager;

    @RequestMapping(value = "/managerLogin",method= RequestMethod.POST)
    public ModelAndView managerLogin(String unum,String pass){
        ModelAndView modelAndView=new ModelAndView();
        Integer userId=0;
        try {
             userId = userManager.managerLogin(unum, pass);
        } catch (Exception e) {
            //异常处理
            e.printStackTrace();
            System.out.printf("错误　：　"+e.getMessage());
        }
        modelAndView.addObject("uid",userId);
        modelAndView.setViewName(MANAGER_INDEX);

        return modelAndView;
    }

}
