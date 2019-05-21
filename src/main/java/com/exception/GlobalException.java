package com.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * ȫ���쳣������
 * @author Steven
 *
 */
public class GlobalException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object hanlder,
			Exception e) {
		//��¼��־
		e.printStackTrace();
		//������Ϣ 
		String msg = "�ܱ�Ǹ��ϵͳ�����쳣�ˣ�����ϵ����Ա";
		//�ж�ʵ���Ƿ�Ϊ�Զ�����쳣
		if (e instanceof MyException) {
			msg=((MyException)e).getMsg();
		}
		//��Ӧ�û�������ʾ
		ModelAndView mav = new ModelAndView();
		//���ش�����Ϣ
		mav.addObject("msg", msg);
		//��Ӧ������ʾҳ��
		mav.setViewName("error");
		return mav;
	}
}


