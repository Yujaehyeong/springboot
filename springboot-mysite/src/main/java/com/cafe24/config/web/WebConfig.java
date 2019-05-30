package com.cafe24.config.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cafe24.config.web.MVCConfig;
import com.cafe24.config.web.SecurityConfig;
import com.cafe24.mysite.config.MessageConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({ "com.cafe24.mysite.controller" })
@Import({ MVCConfig.class , SecurityConfig.class, MessageConfig.class, FileUploadConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {
}
