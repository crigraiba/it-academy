package com.example.controller.exception;

public class ShopCapacityReachedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ShopCapacityReachedException() {
		super("No es poden afegir més quadres.");
	}
	
}
