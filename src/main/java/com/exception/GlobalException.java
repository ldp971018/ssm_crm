package com.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 * @author Steven
 *
 */
public class GlobalException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object hanlder,
			Exception e) {
		//记录日志
		e.printStackTrace();
		//错误消息 
		String msg = "很抱歉，系统发生异常了，请联系管理员";
		//判断实例是否为自定义的异常
		if (e instanceof MyException) {
			msg=((MyException)e).getMsg();
		}
		//响应用户错误提示
		ModelAndView mav = new ModelAndView();
		//返回错误消息
		mav.addObject("msg", msg);
		//响应错误提示页面
		mav.setViewName("error");
		return mav;
	}
}


