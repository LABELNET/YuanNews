package yuan.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import yuan.ssm.common.config.ConfigConstant;
import yuan.ssm.common.constant.ManagerConstant;
import yuan.ssm.other.PageJo;
import yuan.ssm.pojo.NewsPo;
import yuan.ssm.service.manager.NewsManager;

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
 * 创建日期：　16-4-13 下午1:04
 * <p/>
 * 功能描述： 新闻管理页面控制器，实现新闻管理页面新闻管理
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
@Controller
@RequestMapping("/manager")
public class NewsController {


     @Autowired
     private NewsManager newsManager;

     private int pageNum= ConfigConstant.MANAGER_NEWS_PAGE_NUM;

     @RequestMapping("/managerNewsPage")
     public ModelAndView managerNewsPage(Integer p) throws Exception {
         if(p<0){
             p=1;
         }
         int currentPage=p;
         p=pageNum*(p-1);
         List<NewsPo> newsPos = newsManager.managerFindList(p, pageNum);
         PageJo pageJo = newsManager.managerFindCount();
         ModelAndView mav=new ModelAndView();
         mav.addObject("count",pageJo.getAllCount());
         mav.addObject("newsPos",newsPos);
         mav.addObject("currentPage",currentPage);
         mav.setViewName(ManagerConstant.MANAGER_NEWS_PAGE);
         return mav;
     }




}
