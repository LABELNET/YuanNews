package yuan.ssm.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
 * 版本：　1.0
 * <p/>
 * 创建日期：　16-5-5 下午6:40
 * <p/>
 * 功能描述： 客户端接口-新闻，分类，来源，标签接口实现
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
@Controller
@RequestMapping("api/")
public class AndroidNController {


    /**
     * 分页查询新闻列表
     * @param p
     * @return
     */
    @RequestMapping("getNesList")
    public @ResponseBody String getNesList(@RequestParam Integer p){



        DataBean<UserVo> bean = new DataBean<UserVo>();
        try{

        } catch (Exception e) {
            bean.setCode(-3);
            bean.setMsg("系统错误");
        }
        return JSON.toJSONString(bean);
    }


}
