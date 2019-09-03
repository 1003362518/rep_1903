package com.emp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//��½������
/**
 * preHandle��ҵ��������������֮ǰ������;
   postHandle��ҵ��������������ִ����ɺ�,������ͼ֮ǰִ��;
   afterCompletion��DispatcherServlet��ȫ����������󱻵���,
   ������������Դ�� ��afterCompletion()ִ����ɺ�ʼ��Ⱦҳ��
 *preHandle-->/emp/conditonList(Controller��)-->postHandle-->
 *����ListEmp.jsp(html)-->afterCompletion --->��������ش�html
 */
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	/*
	 * return true ������ ���� ����ҵ������ ����/emp/conditionList
	 * return false ����,������ҵ������
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object user=request.getSession().getAttribute("user");
		if(user!=null)
			//�Ѿ���½��,����
			return true;
		//ת����Login.jsp
		//�󶨴�����Ϣ
		request.setAttribute("msg", "���ȵ�½");
		//request.getServletContext().getContextPath();
		//ת������������
		request.getRequestDispatcher("/user/toLogin").forward(request, response);;
		return false;
		
	}
	
	

}
