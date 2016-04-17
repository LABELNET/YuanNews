package yuan.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import yuan.ssm.common.config.ConfigConstant;
import yuan.ssm.common.constant.ManagerConstant;
import yuan.ssm.other.PageJo;
import yuan.ssm.pojo.LikedPo;
import yuan.ssm.service.manager.LikedManager;

import java.util.List;

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
 * 创建日期：　16-4-17 上午11:23
 * <p/>
 * 功能描述： 点赞管理控制器，实现点赞的管理功能
 *　功能：主页分页加载，删除点赞
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
@Controller
@RequestMapping("/manager")
public class LikedController {


    @Autowired
    private LikedManager likedManager;

    private int pageNum= ConfigConstant.MANAGER_LIKED_PAGE_NUM;

    /**
     * 点赞管理主页
     * 数据：　list , 当前页，总数
     * @param p　页数
     * @return
     */
    @RequestMapping("/managerLikedPage")
    public ModelAndView managerLikedPage(@RequestParam Integer p) throws Exception {
        if(p<0){
           p=1;
        }
        int currPage=p;
        p=pageNum*(p-1);
        ModelAndView mav=new ModelAndView();
        List<LikedPo> likedPos = likedManager.managerFindList(p, pageNum);
        PageJo pageJo = likedManager.managerFindCount();
        mav.addObject("likedPos",likedPos);
        mav.addObject("currentPage",currPage);
        mav.addObject("count",pageJo.getAllCount());
        mav.setViewName(ManagerConstant.MANAGER_LIKED_PAGE);
        return mav;
    }

    @RequestMapping("/managerDeleteLiked")
    public Integer managerDeleteLiked(@RequestParam Integer id) throws Exception{
       return likedManager.managerDeleteOne(id);
    }

}
