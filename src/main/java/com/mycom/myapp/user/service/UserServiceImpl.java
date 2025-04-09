package com.mycom.myapp.user.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mycom.myapp.user.dao.UserDao;
import com.mycom.myapp.user.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	private final UserDao userDao;
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public Map<String, String> register(UserDto userDto) {
		Map<String,String> map = new HashMap<>();
		
		int ret = this.userDao.register(userDto);
		
		if(ret == 1) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		return map;
	}

}
