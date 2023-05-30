package br.com.quintinodigital.sistemafinanceiroapi.exception;

public class EmptyResultDataAccessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EmptyResultDataAccessException(String mensagem) {
		super(mensagem);
	}
	
	public EmptyResultDataAccessException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}

}
