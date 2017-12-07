package ar.com.osde.integracionsaludsoft.handler;

import java.io.Reader;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import ar.com.osde.framework.business.exception.BusinessException;

/**
 * The Interface IntegrationBO.
 */
public interface IntegrationHandler {

	/**
	 * Handler event.
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws BusinessException
	 *             the business exception
	 */
	void handlerCommonServiceEvent(Reader request, Writer response) throws BusinessException;

	/**
	 * Handler GI service request.
	 *
	 * @param request
	 *            the request
	 * @return the string
	 * @throws BusinessException
	 *             the business exception
	 */
	String handlerGIServiceRequest(HttpServletRequest request) throws BusinessException;

}
