package com.cafe24.jblog.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.cafe24.jblog.service.UserService;
import com.cafe24.jblog.vo.UserVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		ApplicationContext ac = 
				WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		// WebApplicationContext에 담겨있는 객체를 받아서 사용
		UserService userService = ac.getBean(UserService.class);
		UserVo userVo = new UserVo(id, password);
		
		UserVo authUser = userService.getUser(userVo);
		if(authUser == null) {
			System.out.println("authUser == null : "+request.getContextPath()+"리다이렉트함");
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
		}
		
		//session 처리
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		System.out.println(request.getContextPath()+"리다이렉트함");
		response.sendRedirect(request.getContextPath()+"/");
		
		
		return false; // true일때 뒤에 컨트롤러 연결된 것이 없으면 에러남
		
	}
}