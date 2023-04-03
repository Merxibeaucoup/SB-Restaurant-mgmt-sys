package com.edgar.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.models.ItemOrdered;
import com.edgar.models.Order;
import com.edgar.models.enums.TableStatus;
import com.edgar.repositories.OrderRepository;

@Service
public class OrderService {
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	
	
	
	public void saveOrder(Order order, Set<ItemOrdered> items) {
		
		
		BigDecimal totalPrice = new BigDecimal("0.00");					
		/* set belonging order*/
		items.stream().forEach(itemOrder -> itemOrder.setOrder(order));	
		items.stream().forEach(itemP -> itemP.getMenuItem().getMenuItemPrice().add(totalPrice));
		items.stream().forEach(itemM -> itemM.setMenuItem(itemM.getMenuItem()));	
		
		
		
		order.setTotalPrice(totalPrice);
		order.setItemsOrdered(items);
		order.setOrderDate(LocalDateTime.now());
		order.getTable().setStatus(TableStatus.OCCUPIED);
		orderRepository.save(order);
    }
	
	

}


//for(ItemOrdered item : rawItems ) {
//	
//	item.setMenuItem(item.getMenuItem());
//	item.setQuantity(item.getQuantity());
//	item.setOrder(order);
//	
//	totalPrice = item.getMenuItem().getMenuItemPrice().add(totalPrice);
//	Set<ItemOrdered> rawItems = order.getItemsOrdered();	
//}
