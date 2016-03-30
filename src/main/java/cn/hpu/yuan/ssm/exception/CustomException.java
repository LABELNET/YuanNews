package cn.hpu.yuan.ssm.exception;


/**
 * Created by yuan on 16-3-30.
 * 配置异常统一处理拦截实体类
 */
public class CustomException extends Exception {
	
	private String msg;
	
	public CustomException(String msg) {
      super(msg);
      this.msg=msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
