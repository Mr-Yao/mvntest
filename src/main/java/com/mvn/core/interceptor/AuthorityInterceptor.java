package com.mvn.core.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * mvntest
 *
 * @author Created by LiYao on 2017-03-07 21:02.
 */
@Component
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger(AuthorityInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.error("AuthorityInterceptor.preHandle");
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		logger.error("AuthorityInterceptor.postHandle");
		super.postHandle(request, response, handler, modelAndView);

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.error("AuthorityInterceptor.afterCompletion");
		if (ex instanceof ArithmeticException) {
			logger.error("ArithmeticException");
		}

	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.error("AuthorityInterceptor.afterCompletion");
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
}
