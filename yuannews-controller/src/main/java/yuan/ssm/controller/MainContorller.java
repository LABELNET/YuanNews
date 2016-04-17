package yuan.ssm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yuan on 16-3-30.
 * 用户端　－　主页控制器－主页
 * 功能：　主页显示，主页内容请求等
 */

@Controller
public class MainContorller {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String Index(){
        return "index";
    }
}
