package yuan.ssm.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yuan.ssm.other.DataBean;
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

@RequestMapping("Api/")
public class AndroidController {



    @RequestMapping("login")
    public @ResponseBody String login(@ModelAttribute UserVo userVo){
        DataBean<UserVo> bean = new DataBean<UserVo>();
        bean.setT(userVo);
        return JSON.toJSONString(bean);
    }



}
