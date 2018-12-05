package com.kim.app.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BaseExceptionController {

	@ExceptionHandler(value = TestTable2NotFoundException.class)
	public ResponseEntity<Object> handleVoiceCallNotFoundExceptionHandler(TestTable2NotFoundException exception) {

		return new ResponseEntity<>(exception.getCustomMessage(), HttpStatus.NOT_FOUND);
	}
}
