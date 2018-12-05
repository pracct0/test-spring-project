package com.kim.app.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends BaseSystemException {

	private static final long serialVesionUID = 1L;

	private String customMessage = "######::Resource Not Found.";

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String message) {

		super(message);
	}

	public ResourceNotFoundException(String message, Throwable cause) {

		super(message, cause);
	}

	@Override
	public String getCustomMessage() {

		return customMessage;
	}

}
