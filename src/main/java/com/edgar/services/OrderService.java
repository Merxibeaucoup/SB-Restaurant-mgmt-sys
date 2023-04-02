package com.edgar.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.models.ItemOrdered;
import com.edgar.models.Order;
import com.edgar.repositories.OrderRepository;

@Service
public class OrderService {
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	public void saveOrder(Order order) {
		
		BigDecimal totalPrice = new BigDecimal("0.00");				
		Set<ItemOrdered> rawItems = order.getItemsOrdered();		

		for(ItemOrdered item : rawItems ) {
			
			item.setMenuItem(item.getMenuItem());
			item.setQuantity(item.getQuantity());
			item.setOrder(order);
			
			totalPrice = item.getMenuItem().getMenuItemPrice().add(totalPrice);
			
		}
		
		order.setOrderDate(LocalDateTime.now());	
		orderRepository.save(order);
    }
	
	

}
