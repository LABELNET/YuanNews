package yuan.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import yuan.ssm.common.config.ConfigConstant;
import yuan.ssm.common.constant.ManagerConstant;
import yuan.ssm.other.PageJo;
import yuan.ssm.pojo.CommentPo;
import yuan.ssm.service.manager.CommentManager;

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
 * 创建日期：　16-4-17 上午11:27
 * <p/>
 * 功能描述： 评论信息管理
 * 功能：　评论管理页面，分页查询，删除，修改等
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
@Controller
@RequestMapping("/manager")
public class CommentController {

    @Autowired
    private CommentManager commentManager;

    private int pageNum=ConfigConstant.MANAGER_COMMENT_PAGE_NUM;

    /**
     * 评论管理主页
     * @param p　分页
     * @return
     */
    @RequestMapping("/managerCommentPage")
    public ModelAndView managerCommentPage(Integer p) throws Exception {
        if(p<0){
            p=1;
        }
        int currentPage=p;
        p=pageNum*(p-1);
        List<CommentPo> commentPos = commentManager.managerFindList(p, pageNum);
        PageJo pageJo = commentManager.managerFindCount();
        ModelAndView mav=new ModelAndView();
        mav.addObject("commentPos",commentPos);
        mav.addObject("count",pageJo.getAllCount());
        mav.addObject("currentPage",currentPage);
        mav.setViewName(ManagerConstant.MANAGER_COMMENT_PAGR);
        return mav;
    }

    /**
     * 删除评论
     * @param id　评论id
     * @return
     * @throws Exception
     */
    @RequestMapping("/managerDeleteComment")
    public @ResponseBody Integer managerDeleteComment(@RequestParam Integer id) throws Exception{
       return commentManager.managerDeleteOne(id);
    }


    /**
     * 获得单条评论信息
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/managerCommentFind")
    public @ResponseBody CommentPo managerCommentFind(@RequestParam Integer id) throws Exception{
        return commentManager.managerFindOne(id);
    }

}
