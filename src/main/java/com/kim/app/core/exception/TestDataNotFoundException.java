package com.kim.app.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TestDataNotFoundException extends BaseSystemException {

	private static final long serialVesionUID = 1L;

	private String customMessage = "######::TestData Not Found.";

	public TestDataNotFoundException(String message) {

		super(message);
	}

	public TestDataNotFoundException(String message, Throwable cause) {

		super(message, cause);
	}

	public TestDataNotFoundException() {
		super();
	}

	@Override
	public String getCustomMessage() {

		return customMessage;
	}

}
