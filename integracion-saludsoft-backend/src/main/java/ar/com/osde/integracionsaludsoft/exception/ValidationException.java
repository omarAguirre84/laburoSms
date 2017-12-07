package ar.com.osde.integracionsaludsoft.exception;

import ar.com.osde.framework.exception.FrameworkException;

/**
 * The Class ValidationException.
 */
public class ValidationException extends FrameworkException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 774616053834203994L;

	/**
	 * Instantiates a new validation exception.
	 */
	public ValidationException() {
		super();
	}

	/**
	 * Instantiates a new validation exception.
	 *
	 * @param message
	 *            the message
	 */
	public ValidationException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new validation exception.
	 *
	 * @param e
	 *            the e
	 */
	public ValidationException(Throwable e) {
		super(e);
	}

	/**
	 * Instantiates a new validation exception.
	 *
	 * @param message
	 *            the message
	 * @param e
	 *            the e
	 */
	public ValidationException(String message, Throwable e) {
		super(message, e);
	}

}
