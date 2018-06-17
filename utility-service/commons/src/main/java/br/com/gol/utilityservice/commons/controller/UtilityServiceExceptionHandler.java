package br.com.gol.utilityservice.commons.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import br.com.gol.utilityservice.commons.exception.AbstractUtilityServiceException;
import br.com.gol.utilityservice.commons.model.ApiError;

@ControllerAdvice
public final class UtilityServiceExceptionHandler {

	private static final Log logger = LogFactory.getLog(UtilityServiceExceptionHandler.class);

	@ExceptionHandler(AbstractUtilityServiceException.class)
	protected ResponseEntity<ApiError> handleException(AbstractUtilityServiceException e, WebRequest request) {
		logger.error("Handling error: " + e.getClass().getSimpleName() + ", " + e.getMessage());
		return new ResponseEntity<ApiError>(e.parse(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
