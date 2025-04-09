package com.mycom.myapp.shopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.myapp.order.dao.OrderDao;
import com.mycom.myapp.phone.dao.PhoneDao;
import com.mycom.myapp.phone.dto.Phone;
import com.mycom.myapp.shopping.dao.ShoppingDao;
import com.mycom.myapp.shopping.dto.PhoneInCart;

@Service
public class ShoppingService {
	private final ShoppingDao shoppingDao;	
	private final PhoneDao phoneDao;
	private final OrderDao orderDao;
	
	public ShoppingService(ShoppingDao shoppingDao, PhoneDao phoneDao, OrderDao orderDao) {
		this.shoppingDao = shoppingDao;
		this.phoneDao = phoneDao;
		this.orderDao = orderDao;
	}
	
	public int addToCart(int cartId, int phoneId) {
		int buyCnt = getCnt(cartId,phoneId)  + 1;
		
		return this.shoppingDao.addToCart(cartId, phoneId,buyCnt);
	}
	
	//cart에 있는 phone 정보를 service 에서 가공
	public List<PhoneInCart> listPhonesInCart(int shoppingcartId){
		List<PhoneInCart> phoneList = new ArrayList<>();
		List<Phone> phoneListTmp = this.shoppingDao.listPhonesInCart(shoppingcartId);		
		for(Phone phone : phoneListTmp) {
			int buyCnt = getCnt(shoppingcartId,phone.getPhoneId());
			int totalPrice = buyCnt*phone.getPhonePrice();
			
			PhoneInCart phoneInCart = new PhoneInCart(shoppingcartId,phone.getPhoneId(),buyCnt,phone.getPhoneName(), totalPrice );					
			phoneList.add(phoneInCart);
		}
		return phoneList; 
	}
	
	
	public int getCnt(int shoppingcart_id,int phoneid) {
		//어려웠던 것 ,,,트러블 슈팅하기
		Integer count =this.shoppingDao.getCnt(shoppingcart_id, phoneid); 
		return (count!=null) ? count:0;
	}
	
	public int purchase(int cartId) {
		//장바구니의 phone들 재고 삭제
		List<Phone> phonesInCart = this.shoppingDao.listPhonesInCart(cartId);
		for(Phone phone: phonesInCart) {
			Phone updatedPhone = new Phone(phone.getPhoneId(), phone.getPhoneName(),phone.getPhonePrice(), phone.getPhoneMaker(), phone.getPhoneRemain()-getCnt(cartId,phone.getPhoneId()));					
			phoneDao.updatePhone(updatedPhone);
		}
		//장바구니 clear
		
		this.shoppingDao.clearCart(cartId);
		
		//주문 테이블 수정
		
		this.orderDao.insertOrder(cartId);					
		for(Phone phone: phonesInCart) {
			this.orderDao.insertOrder2(this.orderDao.getOrderId(),phone.getPhoneId());
		}
		
		
		return 0;
		
	}
	//updatdCnt는 service layer에서 구현후 전달
	public int updateCart(int cartId, int phoneId) {
		int updatedCnt = getCnt(cartId,phoneId) + 1;
		return this.shoppingDao.updateCart(cartId, phoneId, updatedCnt);
	}
	
	//updatedRemain은 service layer에서 구현후 전달
	//todo : 수정 필요 (phoneDao 의존성 주입)
	public int updateRemain(int cartId, int phoneId, int quantity) {
		int updatedRemain = phoneDao.detailPhone(phoneId).getPhoneRemain();
		return this.shoppingDao.updateRemain(cartId, phoneId, quantity, updatedRemain);
	}
	
	public int clearCart(int shoppingCartId) {
		return this.shoppingDao.clearCart(shoppingCartId);
	}
}
