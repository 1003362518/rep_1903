package com.emp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//登陆拦截器
/**
 * preHandle在业务处理器处理请求之前被调用;
   postHandle在业务处理器处理请求执行完成后,生成视图之前执行;
   afterCompletion在DispatcherServlet完全处理完请求后被调用,
   可用于清理资源等 。afterCompletion()执行完成后开始渲染页面
 *preHandle-->/emp/conditonList(Controller层)-->postHandle-->
 *生成ListEmp.jsp(html)-->afterCompletion --->向浏览器回传html
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
	 * return true 不拦截 放行 调用业务主件 比如/emp/conditionList
	 * return false 拦截,不调用业务主件
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object user=request.getSession().getAttribute("user");
		if(user!=null)
			//已经登陆了,放行
			return true;
		//转发到Login.jsp
		//绑定错误信息
		request.setAttribute("msg", "请先登陆");
		//request.getServletContext().getContextPath();
		//转发不带工程名
		request.getRequestDispatcher("/user/toLogin").forward(request, response);;
		return false;
		
	}
	
	

}
