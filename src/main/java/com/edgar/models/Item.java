package com.edgar.models;

import java.math.BigDecimal;

import com.edgar.models.enums.ItemType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="order_items")
public class Item {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ITEM_ID")
	private Long id;
	
	@ManyToOne
	private Order order;
	
	@Column(name ="ITEM_QUANTITY")
	private Long quantity;
	
	@Column(name ="ITEM_PRICE")
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	@Column(name ="ITEM_TYPE")
	private ItemType itemType;

}
