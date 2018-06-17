package br.com.gol.utilityservice.commons.exception;

import org.apache.commons.lang.exception.ExceptionUtils;

import br.com.gol.utilityservice.commons.model.ApiError;

public abstract class AbstractUtilityServiceException extends Exception {

	abstract public String getError();

	protected AbstractUtilityServiceException(String message, Exception e) {
		super(message, e);
	}

	public final ApiError parse() {
		ApiError error = new ApiError();
		error.setError(getError());
		error.setErrorDescription(super.getMessage());
		error.setException(super.getClass().getName());
		error.setStackTrace(ExceptionUtils.getFullStackTrace(super.getCause()));
		return error;
	}

}
