package com.mycom.myapp.order.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.myapp.order.dao.OrderDao;
import com.mycom.myapp.order.dto.Order;
import com.mycom.myapp.phone.dto.Phone;

@Service
public class OrderService {
	private final OrderDao orderDao;
	public OrderService(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
    public List<Order> listOrders() {
    	return this.orderDao.listOrders();
    }
    

//    public boolean insertOrder(int shoppingCartId, List<Phone> phoneList) {
//    	return this.orderDao.insertOrder(shoppingCartId, phoneList);
//    }
}
