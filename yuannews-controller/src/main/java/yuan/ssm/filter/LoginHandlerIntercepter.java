package yuan.ssm.filter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yuan on 16-3-30.
 * 过滤拦截器示例
 *
 * 作用　：　用户在访问后台主页的时候，进行登陆判断
 * 　　　　　如果登陆过，直接进行主页，否则转向登陆页，让其登陆
 */
public class LoginHandlerIntercepter implements HandlerInterceptor {

    private static final String INTERCEPTER_ACTION="managerIndex.action";
    private static final String INRERCEPTER_FORWARD="/manager/LoginManger.jsp";
    private static final String SESSION_ATTRIBUTE_KEY="uid";

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object arg2, Exception arg3)
            throws Exception {
    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        // TODO Auto-generated method stub
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1,
                             Object arg2) throws Exception {
        String requestURI = request.getRequestURI();
        if(requestURI.indexOf(INTERCEPTER_ACTION)>0){
            //访问后台主页
            HttpSession session = request.getSession();
            Integer uid = (Integer) session.getAttribute(SESSION_ATTRIBUTE_KEY);
            if(uid!=null){
                //登陆成功的用户
                return true;
            }else{
                //没有登陆，转向登陆界面
//                request.getRequestDispatcher(INRERCEPTER_FORWARD).forward(request,arg1);
                arg1.sendRedirect(INRERCEPTER_FORWARD);
                return false;
            }
        }else{
            return true;
        }
    }
}
