package com.mycom.myapp.phone.dto;

public class Phone {
	int phoneId;
	String phoneName;
	int phonePrice;
	String phoneMaker;
	int phoneRemain;
		
	public Phone() {}
	@Override
	public String toString() {
		return "Phone [phoneId=" + phoneId + ", phoneName=" + phoneName + ",phoneprice="+phonePrice+",phonemaker="+phonePrice+"phoneremain="+phoneRemain+"]";
	}

	public Phone(int phoneId,String phoneName) {
		this.phoneId = phoneId;
		this.phoneName = phoneName;
	}
	
	public Phone(int phoneId, String name, int price, String maker, int remain) {
		this.phoneId = phoneId;
		this.phoneName = name;
		this.phonePrice = price;
		this.phoneMaker = maker;
		this.phoneRemain = remain;
	}

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneName() {
		return phoneName;
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}
	public int getPhonePrice() {
		return phonePrice;
	}
	public void setPhonePrice(int phonePrice) {
		this.phonePrice = phonePrice;
	}
	public String getPhoneMaker() {
		return phoneMaker;
	}
	public void setPhoneMaker(String phoneMaker) {
		this.phoneMaker = phoneMaker;
	}
	public int getPhoneRemain() {
		return phoneRemain;
	}
	public void setPhoneRemain(int phoneRemain) {
		this.phoneRemain = phoneRemain;
	}
	
	
	
	
	
}
