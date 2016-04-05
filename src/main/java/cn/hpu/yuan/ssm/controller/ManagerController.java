package cn.hpu.yuan.ssm.controller;

import cn.hpu.yuan.ssm.service.manager.UserManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yuan on 16-4-4.
 * 　控制器　－　后台管理　
 */

@Controller
public class ManagerController {

    @Autowired
    private UserManager userManager;


    @RequestMapping(value = "/managerLogin",method= RequestMethod.POST)
    public String managerLogin(String unum,String pass){
        Integer userId=0;

        try {
             userId = userManager.managerLogin(unum, pass);

        } catch (Exception e) {
            //异常处理
            e.printStackTrace();
        }

        return new String(userId+"");
    }

}
