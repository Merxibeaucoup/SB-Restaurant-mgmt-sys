package com.edgar.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edgar.models.Item;


public interface ItemRepository  extends JpaRepository<Item, Long>{
	
	
	Optional<Item> findByName(String name);
	
	boolean existsByName(String name);

}
