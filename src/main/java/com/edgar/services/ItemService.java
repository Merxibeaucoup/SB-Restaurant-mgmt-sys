package com.edgar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.exceptions.ItemAlreadyExistsException;
import com.edgar.exceptions.ItemDoesNotExistException;
import com.edgar.models.Item;
import com.edgar.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	/* Create new item */
	public Item addNewMenuItem(Item item) {
		if (!isExists(item.getName())) {
			return itemRepository.save(item);
		}

		else
			throw new ItemAlreadyExistsException("An item with given name " + item.getName() + "already exists");

	}

	/* Get one item by name */
	public Optional<Item> getMenuItem(String name) {
		if (isExists(name)) {
			return itemRepository.findByName(name);
		} else
			throw new ItemDoesNotExistException("No such item with given name  ::'" + name + "' does not exist");

	}
	
	/* Get one item by id */
	public Optional<Item> getMenuItem(Long id) {
		if (isExists(id)) {
			return itemRepository.findById(id);
		} else
			throw new ItemDoesNotExistException("No such item with given name  ::'" + id + "' does not exist");

	}
	
	
	/* Get all menu items */
	public List<Item> getMenuItems(){
		return itemRepository.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/** Item Utils **/

	// name
	public boolean isExists(String name) {
		return itemRepository.existsByName(name) ? true : false;

	}

	// id
	public boolean isExists(Long id) {
		return itemRepository.existsById(id) ? true : false;

	}

}
