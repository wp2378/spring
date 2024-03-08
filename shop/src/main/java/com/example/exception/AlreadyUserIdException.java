package com.example.exception;

public class AlreadyUserIdException extends ShopException {

	
	private static final long serialVersionUID = 7531624245625201188L;

	public AlreadyUserIdException (String message) {
		super(message);
	}
}
