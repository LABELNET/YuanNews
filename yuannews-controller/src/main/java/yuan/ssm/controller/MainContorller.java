package yuan.ssm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yuan on 16-3-30.
 */

@Controller
public class MainContorller {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String Index(){
        return "index";
    }
}
