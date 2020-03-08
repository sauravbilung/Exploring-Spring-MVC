package com.psl.util;

import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Calendar cal=Calendar.getInstance();
		int dayOfWeek =cal.get(Calendar.DAY_OF_WEEK);
		if(dayOfWeek == 1){
			response.getWriter().write("This website is closed on Sunday, Please try on any other day");
		return false;	
		}  
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// this method would be called after Spring MVC executes the request handler method for the request
		System.out.println("HandlerInterceptorAdapter : Spring MVC called postHandle() for"
                + request.getRequestURI().toString()); 
	}	

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//this method would be called after the response object is produced by the view for the request
		System.out.println("HandlerInterceptorAdapter : Spring MVC called afterCompletion() for"
				                                         + request.getRequestURI().toString()); 
	}	
}
