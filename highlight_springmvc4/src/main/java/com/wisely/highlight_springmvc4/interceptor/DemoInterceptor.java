package com.wisely.highlight_springmvc4.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DemoInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long starttime = System.currentTimeMillis();
		request.setAttribute("starttime", starttime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long starttime = (long) request.getAttribute("starttime");
		request.removeAttribute("starttime");
		long endtime = System.currentTimeMillis();
		System.out.println("处理时间为："+new Long(endtime-starttime)+"ms");
		request.setAttribute("handlingTime", endtime-starttime);
	}


	

}
