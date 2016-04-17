package yuan.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import yuan.ssm.common.config.ConfigConstant;
import yuan.ssm.common.constant.ManagerConstant;
import yuan.ssm.other.PageJo;
import yuan.ssm.pojo.NewsPo;
import yuan.ssm.pojo.NewsPoCustom;
import yuan.ssm.service.manager.NewsManager;
import yuan.ssm.vo.NewsVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 新闻管理主页
     * @param p　当前页面
     * @return
     * @throws Exception
     */
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

    /**
     * 添加新闻
     * @param newsVo　新闻vo
     * @return
     * @throws Exception
     */
     @RequestMapping("/managerInsertNews")
     public @ResponseBody Integer managerInsertNews(@ModelAttribute NewsVo newsVo) throws Exception {
         return newsManager.managerInsertNews(newsVo);
     }

    /**
     * 查询单条新闻
     * @param id　新闻id
     * @return
     * @throws Exception
     */
    @RequestMapping("/managerNewsOne")
    public @ResponseBody NewsPoCustom managerNewsOne(@RequestParam Integer id) throws Exception{
        return newsManager.managerFindNews(id);
    }

    /**
     * 删除新闻
     * @param id　新闻id
     * @return
     * @throws Exception
     */
    @RequestMapping("/managerDeleteNews")
    public @ResponseBody Integer managerDeleteNews(@RequestParam Integer id) throws Exception {
        return newsManager.managerDeleteOne(id);
    }

    /**
     * 更新新闻
     * @param newsPo　新闻模型
     * @return
     */
    @RequestMapping("/managerUpdateNews")
    public @ResponseBody Integer managerUpdateNews(@ModelAttribute NewsPo newsPo) throws Exception {
       return newsManager.managerUpdateOne(newsPo);
    }

    /**
     * 查询新闻内容
     * @param id　新闻id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/managerFindNewsContent",method = RequestMethod.POST)
    public @ResponseBody Map<String,String> managerFindNewsContent(@RequestParam Integer id) throws Exception {
        String content = newsManager.managerFindNewsContent(id);
        Map<String,String> maps=new HashMap<String, String>();
        maps.put("content",content);
        return maps;
    }


}
