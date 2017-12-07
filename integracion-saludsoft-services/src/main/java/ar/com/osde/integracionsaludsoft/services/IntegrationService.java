package ar.com.osde.integracionsaludsoft.services;

import javax.jws.WebService;

import ar.com.osde.framework.services.Service;
import ar.com.osde.framework.services.ServiceException;
import ar.com.osde.integracionsaludsoft.backend.integration.handler.common.UrlRequestType;
import ar.com.osde.integracionsaludsoft.exception.ServiceValidationException;
import ar.com.osde.integracionsaludsoft.utils.ParametrosMapWrapper;

/**
 * The Interface IntegrationService.
 */
@WebService
public interface IntegrationService extends Service {

	/**
	 * Resolve target url.
	 *
	 * @param type
	 *            the type
	 * @param codigoServicio
	 *            the codigo servicio
	 * @param mapWrapper
	 *            the map wrapper
	 * @return the string
	 * @throws ServiceException
	 *             the service exception
	 * @throws ServiceValidationException
	 *             the service validation exception
	 */
	String resolveTargetUrl(UrlRequestType type, String codigoServicio, ParametrosMapWrapper mapWrapper)
			throws ServiceException, ServiceValidationException;

}
