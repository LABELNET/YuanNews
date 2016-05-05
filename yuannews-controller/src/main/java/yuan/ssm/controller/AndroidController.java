package yuan.ssm.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import yuan.ssm.other.DataBean;
import yuan.ssm.service.customer.UserService;
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
    private UserService userService;

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
            bean.setCode(-2);
            bean.setMsg("系统错误");
        }
        return JSON.toJSONString(bean);
    }


}
