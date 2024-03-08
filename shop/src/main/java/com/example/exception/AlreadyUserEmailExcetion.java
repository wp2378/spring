package com.example.exception;

public class AlreadyUserEmailExcetion extends ShopException {

	
	private static final long serialVersionUID = 5262059607451542051L;

	public AlreadyUserEmailExcetion(String message) {
		super(message);
	}
}
