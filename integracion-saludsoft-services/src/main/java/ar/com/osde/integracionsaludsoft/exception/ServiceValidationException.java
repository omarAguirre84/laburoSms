package ar.com.osde.integracionsaludsoft.exception;

import ar.com.osde.framework.services.ServiceException;

/**
 * The Class ServiceValidationException.
 */
public class ServiceValidationException extends ServiceException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1205457348673884240L;

	/**
	 * Instantiates a new service validation exception.
	 */
	public ServiceValidationException() {
	}

	/**
	 * Instantiates a new service validation exception.
	 *
	 * @param message
	 *            the message
	 */
	public ServiceValidationException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new service validation exception.
	 *
	 * @param e
	 *            the e
	 */
	public ServiceValidationException(Throwable e) {
		super(e);
	}

	/**
	 * Instantiates a new service validation exception.
	 *
	 * @param message
	 *            the message
	 * @param e
	 *            the e
	 */
	public ServiceValidationException(String message, Throwable e) {
		super(message, e);
	}

}
