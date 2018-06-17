package br.com.gol.utilityservice.cep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.gol.utilityservice.commons.exception.AbstractUtilityServiceException;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public final class UtilityServiceCepException extends AbstractUtilityServiceException {

	private static final String ERROR = "utilityservice.cep";

	public UtilityServiceCepException(String message, Exception e) {
		super(message, e);
	}

	@Override
	public String getError() {
		return ERROR;
	}

}
