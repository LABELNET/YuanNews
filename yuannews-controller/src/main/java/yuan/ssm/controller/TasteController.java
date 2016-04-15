package yuan.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import yuan.ssm.common.config.ConfigConstant;
import yuan.ssm.common.constant.ManagerConstant;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.other.PageJo;
import yuan.ssm.service.manager.TasteManager;
import yuan.ssm.vo.TasteVo;

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
 * 创建日期：　16-4-15 下午10:22
 * <p/>
 * 功能描述： 兴趣管理 Controller
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */


@Controller
@RequestMapping(value = "/manager")
public class TasteController {

    @Autowired
    private TasteManager tasteManager;

    private Integer pageNum= ConfigConstant.MANAGER_TASTE_PAGE_NUM; //每页加载的数量


    /**
     * 兴趣管理主页
     * @param p 当前页数
     * @return 数据列表，数据总数，当前页数
     */
    @RequestMapping(value = "/managerTastePage",method = RequestMethod.GET)
    public ModelAndView managerTastePage(@RequestParam Integer p) throws Exception {
       if(p<0) p=1;
        int currentPage=p;
        LoggerUtil.print(p);
        p=pageNum*(p-1);
        List<TasteVo> tasteVos = tasteManager.managerTasteList(p, pageNum);
        LoggerUtil.print(tasteVos);
        PageJo pageJo = tasteManager.managerTasteCount();
        LoggerUtil.print(pageJo.getAllCount());
        ModelAndView mav=new ModelAndView();
        mav.addObject("tasteVos",tasteVos);
        mav.addObject("count",pageJo.getAllCount());
        mav.addObject("currentPage",currentPage);
        mav.setViewName(ManagerConstant.MANAGER_TASTE_PAGE);
        return mav;
    }




}
