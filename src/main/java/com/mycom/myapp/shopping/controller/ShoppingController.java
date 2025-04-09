package com.mycom.myapp.shopping.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.shopping.dto.PhoneInCart;
import com.mycom.myapp.shopping.service.ShoppingService;

@Controller
@RequestMapping("/shopping")
public class ShoppingController {
	private final ShoppingService shoppingService;
	

	public ShoppingController(ShoppingService shoppingService) {
		this.shoppingService = shoppingService;
	}
		
//	@GetMapping(value="/")	
//	public String shoppingMain() {
//		return "shopping";
//	}
	
	@GetMapping(value ="/getCart")
	@ResponseBody
	public List<PhoneInCart> getCart(Model model){
		List<PhoneInCart> phoneList = shoppingService.listPhonesInCart(1);
		return phoneList;
	}
	
	@GetMapping(value="/addCart/{phoneId}")
	@ResponseBody
	public Map<String, String>  addCart(@PathVariable int phoneId) {
		int ret = this.shoppingService.addToCart(1, phoneId);
		Map<String, String> map = new HashMap<>();
		 if (ret == 1) {
	            map.put("result", "success");
	        } else {
	            map.put("result", "fail");
	        }
	        
	        return map;	
	}
	
	@GetMapping(value="/purchase")
	@ResponseBody
	public Map<String, String>  purchase() {
		int ret = this.shoppingService.purchase(1);
		Map<String, String> map = new HashMap<>();
		if (ret == 1) {
            map.put("result", "success");
        }else {
            map.put("result", "fail");
        }
        
        return map;	
	}
	
//	/processPurchase.jsp
}
