package com.kim.app.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TestTable2NotFoundException extends BaseSystemException {

	private static final long serialVesionUID = 1L;

	private String customMessage = "######::User Not Found.";

	public TestTable2NotFoundException(String message) {

		super(message);
	}

	public TestTable2NotFoundException(String message, Throwable cause) {

		super(message, cause);
	}

	public TestTable2NotFoundException() {
		super();
	}

	@Override
	public String getCustomMessage() {

		return customMessage;
	}

}
