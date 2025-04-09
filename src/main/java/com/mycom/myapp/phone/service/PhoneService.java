package com.mycom.myapp.phone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.myapp.phone.dao.PhoneDao;
import com.mycom.myapp.phone.dto.Phone;

@Service
public class PhoneService {
	private final PhoneDao phoneDao;
	public PhoneService(PhoneDao phoneDao) {
		this.phoneDao = phoneDao;
	}
	
	public int insertPhone(Phone phone) {
		return (phoneDao.insertPhone(phone));		
    }

    public Phone detailPhone(int phoneId) {
    	return (phoneDao.detailPhone(phoneId));
    }

    public List<Phone> listPhone() {
    	return (phoneDao.listPhone());
    }


    public int updatePhone(Phone phone) {
    	return (phoneDao.updatePhone(phone));
    }
	
    public int deletePhone(int phoneId) {
    	return phoneDao.deletePhone(phoneId);
    }
    
	
}
