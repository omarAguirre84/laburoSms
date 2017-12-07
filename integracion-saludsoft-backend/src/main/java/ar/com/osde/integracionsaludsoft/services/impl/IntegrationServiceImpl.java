package ar.com.osde.integracionsaludsoft.services.impl;

import java.util.Map;

import javax.jws.WebService;

import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.framework.services.ServiceException;
import ar.com.osde.integracionsaludsoft.backend.integration.handler.common.UrlRequestType;
import ar.com.osde.integracionsaludsoft.bo.TargetUrlResolverBO;
import ar.com.osde.integracionsaludsoft.exception.ServiceValidationException;
import ar.com.osde.integracionsaludsoft.exception.ValidationException;
import ar.com.osde.integracionsaludsoft.services.IntegrationService;
import ar.com.osde.integracionsaludsoft.utils.ParametrosMapWrapper;

/**
 * The Class IntegrationServiceImpl.
 */
@WebService(endpointInterface = "ar.com.osde.integracionsaludsoft.services.IntegrationService", serviceName = "IntegrationService")
public class IntegrationServiceImpl implements IntegrationService {

	/** The resolvers. */
	private Map<UrlRequestType, TargetUrlResolverBO> resolvers;

	public String resolveTargetUrl(UrlRequestType type, String codigoServicio, ParametrosMapWrapper mapWrapper)throws ServiceException {
		try {
			return this.getResolvers().get(type).resolveUrl(codigoServicio, mapWrapper.getMap());
		} catch (ValidationException e) {
			throw new ServiceValidationException(e.getMessage(), e);
		} catch (BusinessException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * Gets the resolvers.
	 *
	 * @return the resolvers
	 */
	public Map<UrlRequestType, TargetUrlResolverBO> getResolvers() {
		return resolvers;
	}

	/**
	 * Sets the resolvers.
	 *
	 * @param resolvers
	 *            the resolvers
	 */
	public void setResolvers(Map<UrlRequestType, TargetUrlResolverBO> resolvers) {
		this.resolvers = resolvers;
	}

}
