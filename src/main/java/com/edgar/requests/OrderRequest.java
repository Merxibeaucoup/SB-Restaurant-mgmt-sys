package com.edgar.requests;

import java.time.LocalDate;
import java.util.List;

import com.edgar.models.Item;
import com.edgar.models.RestaurantTable;

import lombok.Data;

@Data
public class OrderRequest {
	
	private List<Item> items;
    private double totalPrice;
    private RestaurantTable table;
    private LocalDate orderDate;

}
