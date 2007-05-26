package br.com.fastorder.facade;

public class ManagerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 154598282172903926L;

	/**
	 * Constroi uma DaoException vazia.
	 */
	public ManagerException() {
		super();
	}

	/**
	 * Constroi uma DaoException com uma mensagem.
	 * 
	 * @param message
	 *            mensagem da excecao.
	 */
	public ManagerException(String message) {
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
	public ManagerException(String message, Throwable cause) {
		super(message, cause);
		this.setStackTrace(cause.getStackTrace());
	}

	/**
	 * Constroi uma DaoException com uma causa.
	 * 
	 * @param cause
	 *            causa da excecao.
	 */
	public ManagerException(Throwable cause) {
		super(cause);
		this.setStackTrace(cause.getStackTrace());
	}
	
}
