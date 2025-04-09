package com.mycom.myapp.user.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.mycom.myapp.user.dto.UserDto;


public interface UserService {
	
	public Map<String,String> register(UserDto userDto);
	
}
