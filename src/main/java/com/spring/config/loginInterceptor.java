package com.spring.config;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class loginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Object obj = request.getSession().getAttribute("userLogged");
		if(obj != null) {
			return true;
		}
		
		response.sendRedirect(request.getContextPath() + "/product/home");
		return false;
	}
}
