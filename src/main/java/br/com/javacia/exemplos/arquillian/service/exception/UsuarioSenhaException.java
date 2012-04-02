package br.com.javacia.exemplos.arquillian.service.exception;

public class UsuarioSenhaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsuarioSenhaException() {
		super();
	}

	public UsuarioSenhaException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsuarioSenhaException(String message) {
		super(message);
	}

	public UsuarioSenhaException(Throwable cause) {
		super(cause);
	}

}
