package com.edgar.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edgar.models.MenuItem;


public interface MenuItemRepository  extends JpaRepository<MenuItem, Long>{
	
	
	Optional<MenuItem> findByName(String name);
	
	boolean existsByName(String name);

}
