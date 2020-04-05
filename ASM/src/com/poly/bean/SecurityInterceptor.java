package com.poly.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, 
		 HttpServletResponse response, Object handler) throws Exception{
		HttpSession session = request.getSession();
		 if (request.getSession().getAttribute("USER") == null) {
		        response.sendRedirect("../login.htm");
		        return false;
		    }
		return true;
 }
}
