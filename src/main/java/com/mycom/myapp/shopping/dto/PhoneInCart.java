package com.mycom.myapp.shopping.dto;

public class PhoneInCart {
	private int shoppingCartId;
	private int phoneId;
	private int buyCnt;	
	String phoneName;
	private int totalPrice;
	
	public PhoneInCart(int shoppingCartId, int phoneId, int buyCnt, String phoneName, int totalPrice) {
		super();
		this.shoppingCartId = shoppingCartId;
		this.phoneId = phoneId;
		this.buyCnt = buyCnt;
		this.phoneName = phoneName;
		this.totalPrice = totalPrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "PhoneInCart [shoppingCartId=" + shoppingCartId + ", phoneId=" + phoneId + ", buyCnt=" + buyCnt
				+ ", phoneName=" + phoneName + ",totalPrice=" + totalPrice + "]";
	}
	public int getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(int shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public int getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}
	public int getBuyCnt() {
		return buyCnt;
	}
	public void setBuyCnt(int buyCnt) {
		this.buyCnt = buyCnt;
	}
	public String getPhoneName() {
		return phoneName;
	}
	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}

}
