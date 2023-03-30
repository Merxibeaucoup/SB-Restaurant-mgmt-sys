package com.edgar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edgar.models.Order;

public interface OrderRepository  extends JpaRepository<Order, Long>{

}
