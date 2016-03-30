package cn.hpu.yuan.ssm.filter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yuan on 16-3-30.
 * 过滤拦截器示例
 */
public class LoginHandlerIntercepter implements HandlerInterceptor {


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
        if(requestURI.indexOf("editClientIfo.action")>0){
            //说明处在编辑的页面
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            if(username!=null){
                //登陆成功的用户
                return true;
            }else{
                //没有登陆，转向登陆界面
                request.getRequestDispatcher("/login.jsp").forward(request,arg1);
                return false;
            }
        }else{
            return true;
        }
    }
}
