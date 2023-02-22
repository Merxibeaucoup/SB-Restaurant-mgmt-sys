package com.edgar.models;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name ="orders")
public class Order {
	
	
	@Id
	private Long id;
	
	@CreationTimestamp
	@Column(nullable = true, name ="ORDER_DATE")
	private LocalDateTime orderDate;
	
	
	@Column(name ="ORDER_TOTAL_PRICE")
	private Double totalPrice;
	
	
	@JoinColumn(name = "TABLE_ID")
    @ManyToOne(cascade = CascadeType.DETACH)
    @Nonnull
	private RestaurantTable table;
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "order", orphanRemoval = true)
	private Set<Item> items;

}
