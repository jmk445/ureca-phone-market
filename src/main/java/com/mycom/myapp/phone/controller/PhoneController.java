package com.mycom.myapp.phone.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.phone.dto.Phone;
import com.mycom.myapp.phone.service.PhoneService;

//Controller는 항상 front와 back 연결 
//url mapping은 front와 약속

//client의 ajax 요청에 대해 Phonecontroller는 java 객체를 json으로 응답해 줘야한다.
//Spring은 이를 자동화 해줌. @ResponseBody <- 이하에 있는 모든 응답에 대해서 json으로 응답이 된다.  
@Controller
@RequestMapping("/phones")
//@ResponseBody -> phoneMain() jsp로 분기되어야하기 때문에 이렇게 못함 -> 개별 method에 
public class PhoneController {
	private final PhoneService phoneService;
	
	public PhoneController(PhoneService phoneService) {
		this.phoneService = phoneService;
	}
	
	//index.html의 도서관리 링크 대응
	//phones.jsp로 이동
//	@GetMapping(value="/")
//	public String phoneMain() {
//		return "phones";
//	}
		
	//목록 : 	/phones/list,   		get,  X,		, list.jsp
	@GetMapping("/list")
	@ResponseBody
	public List<Phone> listPhone(Model model) {
		List<Phone> phoneList = phoneService.listPhone();	
		return phoneList;		
	}
	
	//상세 : 	/phones/detail, 		get,  phoneId	, detailForm.jsp
	@GetMapping(value="/detail/{phoneId}")
	@ResponseBody
	public Phone detailPhone(@PathVariable int phoneId) {
		System.out.println(phoneId);
		Phone phone = phoneService.detailPhone(phoneId);
		
		return phone;		
	}
	
	//등록 : 	/phones/insert, 		post, phone, insertResult.jsp
	@PostMapping(value="/insert")
	@ResponseBody
	public Map<String, String> insertPhone(Phone phone) {
		System.out.println(phone);
		int ret = phoneService.insertPhone(phone);
		System.out.println(ret);		
		Map<String, String> map = new HashMap<>();
        if (ret == 1) {
            map.put("result", "success");
        } else {
            map.put("result", "fail");
        }
        
        return map;	
	}
	//수정 : 	/phones/update, 		post, phone, updateResult.jsp
	@PostMapping(value="/update")
	@ResponseBody
	public Map<String, String> updatePhone(Phone phone) {
		System.out.println(phone);
		int ret = phoneService.updatePhone(phone);
		System.out.println(ret);
		Map<String, String> map = new HashMap<>();
        if (ret == 1) {
            map.put("result", "success");
        } else {
            map.put("result", "fail");
        }
        
        return map;		
	}
	//삭제 : 	/phones/delete, 		get,  phoneId	, deleteResult.jsp
	@GetMapping(value="/delete/{phoneId}")
	@ResponseBody
	public Map<String, String> deletePhone(@PathVariable int phoneId, Model model) {
		System.out.println(phoneId);
		int ret = phoneService.deletePhone(phoneId);	
		Map<String, String> map = new HashMap<>();
        if (ret == 1) {
            map.put("result", "success");
        } else {
            map.put("result", "fail");
        }
        
        return map;	
	}
	
	//insertForm.jsp는 ajax로 구현하기 때문에 json을 보내주면 되기 때문에 필요 x
//	//원래 raw하게 할때 는 insertForm.jsp요청은 list.jsp 파일에서 바로 호출(href)했다. but 이제는 Controller를 거쳐서 이동
//	//등록화면 :	/phones/insertForm,	get,	X,	insertForm.jsp
//	@GetMapping(value="/insertForm")
//	public String insertForm() {
//		return "insertForm";
//	}
}
