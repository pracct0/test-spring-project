package com.kim.app.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TestInterceptor implements HandlerInterceptor {

	private static Logger logger = Logger.getLogger(TestInterceptor.class.getName());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.debug("##::TestInterceptor: Performing operation before sending the request to the controller.");

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		logger.debug("##::TestInterceptor: Performing operation before sending the response to the client.");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		logger.debug("##::##::TestInterceptor: Performing operation after completing the request and response.");
	}
}
