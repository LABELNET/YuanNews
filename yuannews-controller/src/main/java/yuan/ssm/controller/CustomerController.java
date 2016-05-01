package yuan.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import yuan.ssm.other.PageVo;
import yuan.ssm.pojo.CSCustom;
import yuan.ssm.pojo.NewsCustom;
import yuan.ssm.service.customer.NewsService;
import yuan.ssm.service.customer.UserService;
import yuan.ssm.vo.UserVo;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 16-4-4.
 * 控制器－用户端-用户中心
 * 功能：用户中心页面及其功能
 */

@Controller
@RequestMapping("/html")
public class CustomerController {

    //主页
    private final String INDEX_PAGE="html/index";

    //登陆页面
    private final String LOGIN_PAGE="html/login/login";

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

    @Autowired
    private UserService userService;


    /**
     * 新闻有关的列表页面
     * 包括：
     * 显示页面；
     * 当前页面；
     * 新闻总数；
     * 当前类型：普通，分类，来源；
     * 列表数据；
     * 页面标题；
     * 分类和来源信息；
     * 当前加载的类型：点赞，阅读，评论，普通
     * @param pageVo
     * @return
     * @throws Exception
     */
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
        andView.addObject("count",newsService.getNewsCount().getAllCount());
        //分类/来源数据
        CSCustom sourceIfo = newsService.findCateSourceIfo();
        andView.addObject("sourceIfo",sourceIfo);
        andView.addObject("title",pageVo.getTitle()==null?"新闻推荐":pageVo.getTitle());
        andView.addObject("ntype",pageVo.getnType());
        andView.addObject("type",pageVo.getType());
        return andView;
    }

    /**
     * 用户登陆页面
     * @return
     */
    @RequestMapping("login/userLoginPage")
    public String userLoginPage(){
        return LOGIN_PAGE;
    }

    /**
     * 用户登陆
     * @param session
     * @param unum
     * @param pass
     * @return 登陆成功 1 ，失败-1
     * @throws Exception
     */
    @RequestMapping("login/userLogin")
    public @ResponseBody Integer userLogin(HttpSession session, @RequestParam String unum,@RequestParam String pass) throws Exception {
        UserVo vo = userService.userLogin(unum, pass);
        if(vo!=null) {
            session.setAttribute("user", vo);
            return 1;
        }else{
            return -1;
        }
    }

    /**
     * 用户登出
     * @param session
     * @return
     */
    @RequestMapping("login/userLoignout")
    public @ResponseBody Integer userLoignout(HttpSession session){
        session.invalidate();
        return 0;
    }



}
