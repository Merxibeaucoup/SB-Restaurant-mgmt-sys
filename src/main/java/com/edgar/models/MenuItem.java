package com.edgar.models;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.edgar.models.enums.ItemType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name ="menu_items")
public class MenuItem {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long menuItemId;
	
	@NotNull
	private String menuItemName;
	
	@Column(columnDefinition="TEXT")
	private String menuItemDescription;
	
	@Positive
	private BigDecimal menuItemPrice;
	
	@PositiveOrZero
	private Integer menuItemStockAmount;
	
	private Boolean menuItemInstock;
	
	@Enumerated(EnumType.STRING)
	private ItemType menuItemType;

}
