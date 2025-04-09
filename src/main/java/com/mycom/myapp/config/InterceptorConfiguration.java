package com.mycom.myapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mycom.myapp.common.LoginInterceptor;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
	
	@Autowired
	LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns(
			"/",
			"/index.html", //static도 다 넣어줘야 된다. 이미지도 로그인에 걸려서 안나오게 된다.
			"/favicon.ico",
			"/assets/**",
			"/pages/login", // page 요청
			"/pages/register", 	// page 요청					
			"/auth/**", 	// 로그인 ajax 요청
			"/users/**",		// 회원가입 ajax 요청
			"/nav_bar.html"
		);
	}
}
