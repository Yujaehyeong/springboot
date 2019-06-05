package com.cafe24.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.jblog.security.AuthUser;

@Controller
public class MainController {
	
	@RequestMapping({"/", "/main"})
	public String showMain() {
		return "main/index";
	}
	
}
