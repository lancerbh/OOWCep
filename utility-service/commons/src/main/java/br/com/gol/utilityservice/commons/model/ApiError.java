package br.com.gol.utilityservice.commons.model;

import io.swagger.annotations.ApiModelProperty;

public class ApiError extends JsonObject {

	@ApiModelProperty(value = "Tipo do erro retornado", required = true, example = "utilityservice.commons")
	private String error;
	@ApiModelProperty(value = "Descrição do erro", required = true, example = " / by zero")
	private String errorDescription;
	@ApiModelProperty(value = "Exceção ocorrida", required = true, example = "java.lang.ArithmeticException")
	private String exception;
	@ApiModelProperty(value = "Rastreamento do erro", required = true, example = "Será exibido o conteúdo de java.lang.Exception#printStackTrace()")
	private String stackTrace;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public static final ApiError create(String error, String errorDescription, String exception, String stackTrace) {
		ApiError e = new ApiError();
		e.setError(error);
		e.setErrorDescription(errorDescription);
		e.setException(exception);
		e.setStackTrace(stackTrace);
		return e;
	}

}
