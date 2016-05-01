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



    @Autowired
    private NewsService newsService;


    @RequestMapping("/pageIndex")
    public ModelAndView pageIndex(@ModelAttribute PageVo pageVo) throws Exception {

        if(pageVo.getP()<0){
            pageVo.setP(1);
        }
        int p=pageVo.getP();
        pageVo.setStart((p-1)*PAGE_NUM);//开始页面
        pageVo.setNum(PAGE_NUM);//每页总数

        ModelAndView andView = new ModelAndView();
        //当前页面
        andView.addObject("currectIndex",p); //当前页面
        //页面
        andView.setViewName(INDEX_PAGE);//页面对象
        List<NewsCustom> customByComment =new ArrayList<NewsCustom>();
        //list数据
        switch (pageVo.getType()){
            case idType:
                customByComment.addAll(newsService.getIdNews(pageVo));
                break;
            case rnumType:
                customByComment.addAll(newsService.getRnumNews(pageVo));
                break;
            case zanType:
                customByComment.addAll(newsService.getZanNews(pageVo));
                break;
            case commentType:
                customByComment.addAll(newsService.getCommentNews(pageVo));
                break;
        }
        andView.addObject("customs",customByComment);
        //总数
        andView.addObject("count",newsService.getNewsCount());
        //分类/来源数据
        CSCustom sourceIfo = newsService.findCateSourceIfo();
        andView.addObject("sourceIfo",sourceIfo);
        return andView;
    }


}
