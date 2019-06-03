package com.cafe24.config.web;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cafe24.config.web.MVCConfig;
import com.cafe24.config.web.SecurityConfig;
import com.cafe24.mysite.config.MessageConfig;
import com.cafe24.mysite.security.AuthInterceptor;
import com.cafe24.mysite.security.AuthLoginInterceptor;
import com.cafe24.mysite.security.AuthLogoutInterceptor;
import com.cafe24.mysite.security.AuthUserHandlerMethodArgumentResolver;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({ "com.cafe24.mysite.controller" })
@Import({ MVCConfig.class , SecurityConfig.class, MessageConfig.class, FileUploadConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {
	
	//
	//	Argument Resolver
	//
	@Bean
	public AuthUserHandlerMethodArgumentResolver authUserHandlerMethodArgumentResolver() {
		return new AuthUserHandlerMethodArgumentResolver();
	}
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(authUserHandlerMethodArgumentResolver());
	}
	
	@Bean
	public AuthLoginInterceptor authLoginInterceptor() {
		return new AuthLoginInterceptor();
	}
	
	@Bean
	public AuthLogoutInterceptor authLogoutInterceptor() {
		return new AuthLogoutInterceptor();
	}
	
	@Bean
	public AuthInterceptor authInterceptor() {
		return new AuthInterceptor();
	}
	//
	//	InterCeptor
	//
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry
		.addInterceptor(authLoginInterceptor())
		.addPathPatterns("/user/auth");
		
		registry
		.addInterceptor(authLogoutInterceptor())
		.addPathPatterns("/user/logout");
		
		registry
		.addInterceptor(authInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/user/auth")
		.excludePathPatterns("/user/logout")
		.excludePathPatterns("/assets/**");
	}
	
}
