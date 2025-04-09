package com.mycom.myapp.common;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class pageController {
	

	@GetMapping("/pages/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/pages/login")
	public String login() {
		return "login";
	}	

	
	@GetMapping("/pages/shopping")
	public String shopping() {
		return "shopping";
	}
	@GetMapping("/pages/board")
	public String board() {
		return "board";
	}
	
	//페이지 이동과 상관없는 테스트 용도
		//jackson, gson 두 library의 Local DateTime 객체의 json 문자열 비교 
		@GetMapping("/pages/json")
		@ResponseBody
		public LocalDateTime json() {
			return LocalDateTime.now();
		}
	
	
}
