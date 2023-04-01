package com.edgar.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="ordered_items")
public class ItemOrdered {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OREDERED_ITEM_ID")
	private Long id;
	
	
	@ManyToOne
	private Order order;
	
	@Column(name ="ORDERED_ITEM_QUANTITY")
	private Long quantity;
	
	private MenuItem menuItem;
	
	

}
