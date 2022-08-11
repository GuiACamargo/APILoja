package com.gft.loja.exception;

public class LojaException extends RuntimeException {

	private static final long serialVersionUID = -7461723216573927617L;
	
	private String message;

	public LojaException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
