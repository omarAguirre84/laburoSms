package ar.com.osde.integracionsaludsoft.utils;

import ar.com.osde.framework.services.ServiceException;

/**
 * The Class RuntimeExceptionHandlerAspect.
 */
public class RuntimeExceptionHandlerAspect {

	/**
	 * Handle exception.
	 *
	 * @param ex
	 *            the ex
	 * @throws Throwable
	 *             the throwable
	 */
	public void handleException(RuntimeException ex) throws ServiceException {
		throw new ServiceException(ex);
	}

}