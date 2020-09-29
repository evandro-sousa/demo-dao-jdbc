package br.com.bdExecption;

public class DBExceptionIntegridade extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DBExceptionIntegridade(String msg) {
		super(msg);
	}
}
