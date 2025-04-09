package com.mycom.myapp.auth.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mycom.myapp.auth.dao.LoginDao;
import com.mycom.myapp.user.dto.UserDto;

@Service
public class LoginServiceImpl implements LoginService{
	private final LoginDao loginDao;
	
	public LoginServiceImpl(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	//1. version1 : 10차시에서 예외처리를 배우기 전 
	//userDto를 받아서 -> string으로 변환 후 -> dao 실행 후 (db의 userdto가져온 후) -> 비교 후 userDto return 
//	@Override
//	public Optional<UserDto> login(UserDto userDto) {
//		UserDto dtoFromDB = loginDao.login(userDto.getUserEmail());
//		
//		if(dtoFromDB != null && userDto != null && userDto.getUserPassword().equals(dtoFromDB.getUserPassword())) {
//			return Optional.of(dtoFromDB);
//		}else {
//			
//		}
//		return Optional.empty();
//	}
	
	@Override
	public Optional<UserDto> login(UserDto userDto) {
		UserDto dtoFromDB = loginDao.login(userDto.getUserEmail());		
		try {
			if(userDto.getUserPassword().equals(dtoFromDB.getUserPassword())) {
				return Optional.of(dtoFromDB);
			}			
		}catch(Exception e) {
			e.printStackTrace();
			//todo : error 처리 (loginResultDto를 return 하게끔)
		}
		
		return Optional.empty();
		
	}
	
}
