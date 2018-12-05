package com.kim.app.core.exception;

public abstract class BaseSystemException extends RuntimeException implements BaseException {

	public BaseSystemException() {

		super();
	}

	public BaseSystemException(String message) {

		super(message);
	}

	public BaseSystemException(String message, Throwable cause) {

		super(message, cause);
	}
}
