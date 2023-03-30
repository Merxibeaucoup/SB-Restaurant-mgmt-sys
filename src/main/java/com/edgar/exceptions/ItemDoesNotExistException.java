package com.edgar.exceptions;

public class ItemDoesNotExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemDoesNotExistException(String message) {
		super(message);
	}

}
