package com.edgar.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private Order order;
	
	@Column(name ="ORDERED_ITEM_QUANTITY")
	private Long quantity;
	
	
	@ManyToOne
	private MenuItem menuItem;
	
	

}
