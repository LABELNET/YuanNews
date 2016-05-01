package yuan.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import yuan.ssm.other.PageVo;
import yuan.ssm.pojo.CSCustom;
import yuan.ssm.pojo.NewsCustom;
import yuan.ssm.service.customer.NewsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 控制器－用户端-用户中心
 * 功能：用户中心页面及其功能
 */

@Controller
@RequestMapping("/user")
public class CustomerController {

    //主页
    private final String INDEX_PAGE="index";

    //每页数量
    private final int PAGE_NUM=15;
    //ID
    private final int idType=2;
    //阅读
    private final int rnumType=3;
    //点赞
    private final int zanType=4;
    //评论
    private final int commentType=5;

    private final int newsNormalType=6; //正常类型
    private final int newsCateType=7; //分类类型
    private final int newsSourceType=8; //来源类型


    @Autowired
    private NewsService newsService;



    @RequestMapping("/pageIndex")
    public ModelAndView pageIndex(@ModelAttribute PageVo pageVo) throws Exception {
        ModelAndView andView = new ModelAndView();
        //页面
        andView.setViewName(INDEX_PAGE);
        List<NewsCustom> customByComment =new ArrayList<NewsCustom>();
        //list数据
        switch (pageVo.getType()){
            case idType:
                customByComment.addAll(getIDNews(pageVo.getnType()));
                break;
            case rnumType:
                break;
            case zanType:
                break;
            case commentType:
                break;
        }

        //总数

        //分类/来源数据
        CSCustom sourceIfo = newsService.findCateSourceIfo();
        andView.addObject("sourceIfo",sourceIfo);
        return andView;
    }


    /**
     * 正常类型数据查询
     * @param nType
     * @return
     */
    private List<NewsCustom> getIDNews(int nType) {
        List<NewsCustom> customByComment =new ArrayList<NewsCustom>();
        switch (nType){
            case newsNormalType:
                break;
            case newsCateType:
                break;
            case newsSourceType:
                break;
        }
       return customByComment;
    }


    public ModelAndView cateIndex(){
      return null;
    }

    public ModelAndView sourceIndex(){
        return  null;
    }




}
