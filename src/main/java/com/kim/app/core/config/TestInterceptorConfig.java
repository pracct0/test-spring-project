package com.kim.app.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.kim.app.core.interceptor.TestInterceptor;

@Component
public class TestInterceptorConfig extends WebMvcConfigurerAdapter {

	@Autowired
	TestInterceptor testInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(testInterceptor);
	}
}
