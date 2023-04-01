package com.edgar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.models.Order;
import com.edgar.repositories.OrderRepository;

@Service
public class OrderService {
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	public void saveOrder(Order order) {
		orderRepository.save(order);
    }
	
	
//	@Transactional
//	public Order createNewOrder(OrderRequest orderReq, Order order) {
//		
//		
//		
//	}
}
