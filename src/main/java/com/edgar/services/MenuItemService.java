package com.edgar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.exceptions.ItemAlreadyExistsException;
import com.edgar.exceptions.ItemDoesNotExistException;
import com.edgar.models.MenuItem;
import com.edgar.repositories.MenuItemRepository;

@Service
public class MenuItemService {

	@Autowired
	private MenuItemRepository menuitemRepository;

	/* Create new menu item */
	public MenuItem addNewMenuItem(MenuItem item) {
		if (!isExists(item.getMenuItemName())) {
			return menuitemRepository.save(item);
		}

		else
			throw new ItemAlreadyExistsException("An item with given name " + item.getMenuItemName() + "already exists");

	}

	/* Get one item by name */
	public Optional<MenuItem> getMenuItemByName(String name) {
		if (isExists(name)) {
			return menuitemRepository.findByName(name);
		} else
			throw new ItemDoesNotExistException("No such item with given name  ::'" + name + "' does not exist");

	}
	
	/* Get one item by id */
	public Optional<MenuItem> getMenuItemById(Long id) {
		if (isExists(id)) {
			return menuitemRepository.findById(id);
		} else
			throw new ItemDoesNotExistException("No such item with given name  ::'" + id + "' does not exist");

	}
	
	
	
	
	/* Get all menu items */
	public List<MenuItem> getMenuItems(){
		return menuitemRepository.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/** Item Utils **/

	// name
	public boolean isExists(String name) {
		return menuitemRepository.existsByName(name) ? true : false;

	}

	// id
	public boolean isExists(Long id) {
		return menuitemRepository.existsById(id) ? true : false;

	}

}
