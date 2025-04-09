package com.mycom.myapp.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.user.dto.UserDto;
import com.mycom.myapp.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	@ResponseBody
	public Map<String,String> register(UserDto userDto){
		return this.userService.register(userDto);		
	}
}
