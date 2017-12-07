package ar.com.osde.integracionsaludsoft.handler.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.framework.context.ContextHolder;
import ar.com.osde.framework.entities.organization.Cap;
import ar.com.osde.framework.entities.organization.Filial;
import ar.com.osde.framework.entities.user.impl.UserIntranet;
import ar.com.osde.framework.services.ServiceException;
import ar.com.osde.integracionsaludsoft.backend.integration.handler.common.RequestMapConstants;
import ar.com.osde.integracionsaludsoft.backend.integration.handler.common.UrlRequestType;
import ar.com.osde.integracionsaludsoft.handler.RequestHandler;
import ar.com.osde.integracionsaludsoft.services.IntegrationService;
import ar.com.osde.integracionsaludsoft.utils.ParametrosMapWrapper;

/**
 * The Class SaludsoftIntegrationRequestHandler.
 */
public class SaludsoftIntegrationRequestHandler implements RequestHandler {

	/** The integration service. */
	private IntegrationService integrationService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.osde.integracionsaludsoft.backend.integration.handler.
	 * RequestHandler#handlerRequest(javax.servlet.http.HttpServletRequest)
	 */
	public String handlerRequest(HttpServletRequest request) throws BusinessException {
		try {
			return integrationService.resolveTargetUrl(UrlRequestType.GESTION_INTERNA, request.getParameter("codigo"),
					generateContextInfo());
		} catch (ServiceException e) {
			throw new BusinessException(e);
		}
	}

	/**
	 * Generate context info.
	 *
	 * @return the hash map
	 * @throws BusinessException
	 *             the business exception
	 */
	private ParametrosMapWrapper generateContextInfo() throws BusinessException {
		ParametrosMapWrapper pmw = new ParametrosMapWrapper();
		HashMap<String, String> map = new HashMap<String, String>();
		UserIntranet userIntranet = (UserIntranet) ContextHolder.getContext().getCurrentUser();
		String nombreUsuario = userIntranet.getLastName().concat(" ").concat(userIntranet.getFirstName());
		String username = userIntranet.getUserName();
		String codFilial = null;
		String codCap = null;
		Cap cap = userIntranet.getLoginCap();
		if (cap != null) {
			codCap = cap.getCode();
			Filial filial = cap.getFilial();
			if (filial != null) {
				codFilial = filial.getCode();
			}
		}
		map.put(RequestMapConstants.USERNAME_USUARIO_RESPONSABLE, username);
		map.put(RequestMapConstants.NOMBRE_USUARIO_RESPONSABLE, nombreUsuario);
		map.put(RequestMapConstants.ID_CAP_USUARIO_RESPONSABLE, codCap);
		map.put(RequestMapConstants.ID_FILIAL_USUARIO_RESPONSABLE, codFilial);
		pmw.setMap(map);
		
		return pmw;
	}

	/**
	 * Gets the integration service.
	 *
	 * @return the integration service
	 */
	public IntegrationService getIntegrationService() {
		return integrationService;
	}

	/**
	 * Sets the integration service.
	 *
	 * @param integrationService
	 *            the new integration service
	 */
	public void setIntegrationService(IntegrationService integrationService) {
		this.integrationService = integrationService;
	}

}
