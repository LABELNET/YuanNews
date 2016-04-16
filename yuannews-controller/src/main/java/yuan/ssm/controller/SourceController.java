package yuan.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import yuan.ssm.common.config.ConfigConstant;
import yuan.ssm.common.constant.ManagerConstant;
import yuan.ssm.common.util.LoggerUtil;
import yuan.ssm.other.PageJo;
import yuan.ssm.service.manager.SourceManager;
import yuan.ssm.vo.SourceVo;

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
 * 创建日期：　16-4-16 下午8:27
 * <p/>
 * 功能描述： 新闻来源控制器，实现新闻管理页面的业务需求实现
 * <p>
 * <p/>
 * 功能更新历史：
 * <p>
 * ==================================================
 */
@Controller
@RequestMapping("/manager")
public class SourceController {


    @Autowired
    private SourceManager sourceManager;

    //每页显示的数量
    private int pageNum= ConfigConstant.MANAGER_SOURCE_PAGE_NUM;

    /**
     * 新闻来源管理主页
     * @return 数据，页面，当前页面
     */
    @RequestMapping("/managerSourcePage")
    public ModelAndView managerSourcePage(Integer p) throws Exception {
        if(p<0){
            p=1;
        }
        int currentPage=p;
        p=pageNum*(p-1);
        List<SourceVo> sourceVos = sourceManager.managerFindList(p,pageNum);
        LoggerUtil.print(sourceVos);
        PageJo pageJo = sourceManager.managerFindCount();
        LoggerUtil.print(pageJo.getAllCount());
        ModelAndView mav=new ModelAndView();
        mav.setViewName(ManagerConstant.MANAGER_SOURCE_PAGR);
        mav.addObject("sourceVos",sourceVos);
        mav.addObject("count",pageJo.getAllCount());
        mav.addObject("currentPage",currentPage);
        return mav;
    }


}
