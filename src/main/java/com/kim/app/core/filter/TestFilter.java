package com.kim.app.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Component
public class TestFilter implements Filter {

	private static Logger logger = Logger.getLogger(TestFilter.class.getName());

	@Override
	public void destroy() {

		logger.debug("##::TestFilter: Performing TestFilter's destroy method.");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		logger.debug("##::TestFilter: Performing TestFilter's doFilter method.");

		logger.debug("######::Remote Host: " + arg0.getRemoteHost());
		logger.debug("######::Remote Address: " + arg0.getRemoteAddr());

		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

		logger.debug("##::TestFilter: Performing TestFilter's init method.");
	}

}
