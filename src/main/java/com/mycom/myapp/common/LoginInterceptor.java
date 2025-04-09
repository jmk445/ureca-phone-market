package com.mycom.myapp.common;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycom.myapp.user.dto.UserDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	private final String jsonStr = "{\"result\":\"login\"}"; // \: " 를 사용하기 위해 escape 문자 준거임
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//userdto가 null 이 아니라면, 
		System.out.println("LoginInterceptor >>>>>" + request.getRequestURI());
		
		HttpSession session = request.getSession();
		
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		if(userDto == null) { //즉, login상태가 아닐때
			if("true".equals(request.getHeader("ajax"))) {
				System.out.println("LoginInterceptor >>>>> ajax request");
				response.getWriter().write(jsonStr);
			}
			else {
				System.out.println("LoginInterceptor >>>>> page request");
				response.sendRedirect("/pages/login");
			}
			return false;
		}
		
		return true;
		
	}
}
