package br.com.fastorder.dao;

/**
 * 
 * @author Diogo Cabral de Almeida
 *
 */
public class DaoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4126647460949509507L;

	/**
	 * Constroi uma DaoException vazia.
	 */
	public DaoException() {
		super();
	}

	/**
	 * Constroi uma DaoException com uma mensagem.
	 * 
	 * @param message
	 *            mensagem da excecao.
	 */
	public DaoException(String message) {
		super(message);
	}

	/**
	 * Constroi uma DaoException com uma mensagem e uma causa.
	 * 
	 * @param message
	 *            mensagem da excecao.
	 * @param cause
	 *            causa da excecao.
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
		this.setStackTrace(cause.getStackTrace());
	}

	/**
	 * Constroi uma DaoException com uma causa.
	 * 
	 * @param cause
	 *            causa da excecao.
	 */
	public DaoException(Throwable cause) {
		super(cause);
		this.setStackTrace(cause.getStackTrace());
	}
	
}
