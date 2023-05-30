package br.com.quintinodigital.sistemafinanceiroapi.exception;

public class IndexOutOfBoundsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public IndexOutOfBoundsException(String mensagem) {
		super(mensagem);
	}
	
	public IndexOutOfBoundsException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}

}
