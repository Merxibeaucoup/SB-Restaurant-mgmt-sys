package com.edgar.models;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
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
	
	@CreationTimestamp
	@Column(name = "date_booked")
	
	private LocalDateTime bookingDate;
	
	@NotNull
	private LocalDateTime reservationForDate;
	
	@NotNull
	private Boolean tableIsAvailable ;
	
	@OneToOne
	private RestaurantTable table;
	
	@OneToOne
	private Order order;

}
