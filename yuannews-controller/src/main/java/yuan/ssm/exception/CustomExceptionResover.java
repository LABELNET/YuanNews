package yuan.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yuan on 16-3-30.
 * 配置异常统一处理拦截类
 */
public class CustomExceptionResover implements HandlerExceptionResolver{

    public ModelAndView resolveException(HttpServletRequest arg0,
                                         HttpServletResponse arg1, Object arg2, Exception ex) {
//		解析出异常类型；
//		如果该异常类型是系统自定义的异常，直接取出异常信息并展示；
//		如果该异常类型不是自定义的异常，则构造一个自定义的异常类型信息；
        CustomException customException=null;
        if(ex instanceof CustomException){
            //是自定义异常类
            customException=(CustomException) ex;
        }else{
            customException=new CustomException("未知错误:"+ex.getMessage());
        }
        String msg=customException.getMsg();
        ModelAndView andView = new ModelAndView();
        andView.addObject("msg", msg);
        andView.setViewName("/error");
        return andView;
    }
}
