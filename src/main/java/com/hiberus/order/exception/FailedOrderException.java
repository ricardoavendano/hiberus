package com.hiberus.order.exception;

public class FailedOrderException extends Exception {

	private static final long serialVersionUID = 3992326806957425834L;

	private final Long id;

	public FailedOrderException(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
