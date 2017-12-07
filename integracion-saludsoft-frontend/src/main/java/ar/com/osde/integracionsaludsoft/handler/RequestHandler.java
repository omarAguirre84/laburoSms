package ar.com.osde.integracionsaludsoft.handler;

import javax.servlet.http.HttpServletRequest;

import ar.com.osde.framework.business.exception.BusinessException;

/**
 * The Interface RequestHandler.
 */
public interface RequestHandler {

	/**
	 * Handler request.
	 *
	 * @param request
	 *            the request
	 * @return the string
	 * @throws BusinessException
	 *             the business exception
	 */
	String handlerRequest(HttpServletRequest request) throws BusinessException;

}
