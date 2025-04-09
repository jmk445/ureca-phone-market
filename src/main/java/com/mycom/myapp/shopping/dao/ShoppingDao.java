package com.mycom.myapp.shopping.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.phone.dto.Phone;

@Mapper
public interface ShoppingDao {	
	public int addToCart(int cartId, int phoneId,int buyCnt);
	List<Phone> listPhonesInCart(int shoppingcartId);
	Integer getCnt(int shoppingcart_id,int phoneid);	
	//updatdCnt는 service layer에서 구현후 전달
	int updateCart(int cartId, int phoneId, int updatedCnt);
	//updatedRemain은 service layer에서 구현후 전달
	int updateRemain(int cartId, int phoneId, int quantity,int updatedRemain);
	int clearCart(int shoppingCartId);
	
}
