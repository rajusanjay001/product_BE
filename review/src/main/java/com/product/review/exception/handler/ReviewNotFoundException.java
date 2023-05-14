package com.product.review.exception.handler;

public class ReviewNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public ReviewNotFoundException(String message) {
	        super(message);
	    }
}