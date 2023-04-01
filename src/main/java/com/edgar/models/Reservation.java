package com.edgar.models;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Reservation {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reservationId;
	
	@NotNull
	private String reservationPerson;
	
	@Email
	private String reservationPersonEmail;
	
	@NotNull
	private LocalDateTime reservationDateTime;
	
	@NotNull
	private Boolean tableIsAvailable ;
	
	@OneToOne
	private RestaurantTable table;
	
	@OneToOne
	private Order order;

}
