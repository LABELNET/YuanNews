package yuan.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import yuan.ssm.common.constant.ManagerConstant;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.service.manager.CateManager;
import yuan.ssm.vo.CateVo;

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
 * 创建日期：　16-4-17 上午11:25
 * <p/>
 * 功能描述： 分类管理控制器
 * 功能：分类管理页面实现，增删改查实现
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
@Controller
@RequestMapping("/manager")
public class CateController {


    @Autowired
    private CateManager cateManager;

    /**
     * 分类信息管理页面
     * @return 数据，页面
     */
    @RequestMapping("/managerCatePage")
    public ModelAndView managerCatePage() throws Exception {
        List<CateVo> cateVos = cateManager.managerFindList(0, 0);
        LoggerUtil.print(cateVos);
        ModelAndView mav=new ModelAndView();
        mav.setViewName(ManagerConstant.MANAGER_CATE_PAGE);
        mav.addObject("cateVos",cateVos);
        return mav;
    }

    /**
     * 添加新闻来源
     * @return
     */
    @RequestMapping(value = "/managerCateInsert",method = RequestMethod.POST)
    public @ResponseBody
    Integer managerCateInsert(@ModelAttribute CateVo cateVo) throws Exception {
        return cateManager.managerInsertOne(cateVo);
    }

    /**
     * 修改新闻来源信息
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/managerCateUpdate",method = RequestMethod.POST)
    public @ResponseBody Integer managerCateUpdate(@ModelAttribute CateVo cateVo) throws Exception {
        return cateManager.managerUpdateOne(cateVo);
    }

    /**
     * 删除 新闻来源
     */
    @RequestMapping(value = "/managerCateDelete")
    public @ResponseBody Integer managerCateDelete(@RequestParam Integer id) throws Exception {
        return cateManager.managerDeleteOne(id);
    }


    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/managerCateFind")
    public @ResponseBody CateVo managerCateFind(@RequestParam Integer id) throws Exception {
        return cateManager.managerFindOne(id);
    }


}
