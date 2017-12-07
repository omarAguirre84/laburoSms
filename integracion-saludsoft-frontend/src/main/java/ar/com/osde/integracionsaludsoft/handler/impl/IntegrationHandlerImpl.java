package ar.com.osde.integracionsaludsoft.handler.impl;

import java.io.Reader;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.framework.integration.gateway.rest.AdvanceRestIntegrationGateWay;
import ar.com.osde.integracionsaludsoft.handler.IntegrationHandler;
import ar.com.osde.integracionsaludsoft.handler.RequestHandler;

/**
 * The Class IntegrationHandlerImpl.
 */
public class IntegrationHandlerImpl implements IntegrationHandler {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(IntegrationHandlerImpl.class);

	/** The gateway for common services. */
	private AdvanceRestIntegrationGateWay gateway;

	/** The request handler. */
	private RequestHandler requestHandler;

	/**
	 * Handler event common service.
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws BusinessException
	 *             the business exception
	 */
	public void handlerCommonServiceEvent(Reader request, Writer response) throws BusinessException {
		try {
			getGateway().execute(request, response);
		} catch (Exception e) {
			LOGGER.error("Error al enviar el evento -" + e.getMessage());
			throw new BusinessException(e);
		}
	}

	/**
	 * Handler event GI service.
	 *
	 * @param request
	 *            the request
	 * @return the string
	 * @throws BusinessException
	 *             the business exception
	 */
	public String handlerGIServiceRequest(HttpServletRequest request) throws BusinessException {
		try {
			return requestHandler.handlerRequest(request);
		} catch (Exception e) {
			LOGGER.error("Error al mandar el request al servidor -" + e.getMessage());
			throw new BusinessException(e);
		}
	}

	/**
	 * Gets the common service gateway.
	 *
	 * @return the common service gateway
	 */
	public AdvanceRestIntegrationGateWay getGateway() {
		return gateway;
	}

	/**
	 * Sets the common service gateway.
	 *
	 * @param gateway
	 *            the new gateway
	 */
	public void setGateway(AdvanceRestIntegrationGateWay gateway) {
		this.gateway = gateway;
	}

	/**
	 * Gets the request handler.
	 *
	 * @return the request handler
	 */
	public RequestHandler getRequestHandler() {
		return requestHandler;
	}

	/**
	 * Sets the request handler.
	 *
	 * @param requestHandler
	 *            the new request handler
	 */
	public void setRequestHandler(RequestHandler requestHandler) {
		this.requestHandler = requestHandler;
	}

}
