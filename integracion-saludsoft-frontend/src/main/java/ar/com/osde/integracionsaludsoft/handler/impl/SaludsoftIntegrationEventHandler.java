package ar.com.osde.integracionsaludsoft.handler.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import ar.com.osde.framework.integration.cache.CacheAdminFactory;
import ar.com.osde.framework.integration.cache.CacheIntegrationError;
import ar.com.osde.framework.services.ServiceException;
import ar.com.osde.integracionsaludsoft.backend.integration.handler.common.UrlRequestType;
import ar.com.osde.integracionsaludsoft.dto.TipoInvocacionDTO;
import ar.com.osde.integracionsaludsoft.exception.ServiceValidationException;
import ar.com.osde.integracionsaludsoft.services.IntegrationService;
import ar.com.osde.integracionsaludsoft.services.ServicioService;
import ar.com.osde.integracionsaludsoft.utils.MapUtils;
import ar.com.osde.wf.integration.IntegrationEventHandler;
import ar.com.osde.wf.integration.events.IntegrationEvent;
import ar.com.osde.wf.integration.events.IntegrationResponse;
import ar.com.osde.wf.integration.events.impl.DetailNeededEvent;
import ar.com.osde.wf.integration.events.impl.PreInstantiationStageEvent;
import ar.com.osde.wf.integration.events.impl.URLRedirectIntegrationResponse;

/**
 * The Class SaludsoftIntegrationEventHandler.
 */
public class SaludsoftIntegrationEventHandler implements IntegrationEventHandler {

	/** The Constant logger. */
	private static final Logger LOGGER = Logger.getLogger(SaludsoftIntegrationEventHandler.class);

	/** The target url resolver BO. */
	private IntegrationService integrationService;

	/** The servicio service. */
	private ServicioService servicioService;

	private String urlHost;

	private String urlContext;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.osde.wf.integration.IntegrationEventHandler#handleIntegrationEvent
	 * (ar.com.osde.wf.integration.events.IntegrationEvent)
	 */
	@SuppressWarnings("unchecked")
	public IntegrationResponse handleIntegrationEvent(IntegrationEvent event) {
		IntegrationResponse response = null;
		String codigo = ServletActionContext.getRequest().getParameter("codigo");

		if (StringUtils.isNotBlank(codigo)) {
			try {
				if (event instanceof PreInstantiationStageEvent) {
					TipoInvocacionDTO tipoInvocacion = servicioService.getByCodigo(codigo).getTipoInvocacion();
					if (tipoInvocacion.equals(TipoInvocacionDTO.GET)) {
						response = this.processGetRequest(codigo, event);
					} else if (tipoInvocacion.equals(TipoInvocacionDTO.POST)) {
						response = this.processPostRequest(codigo, event);
					} else {
						LOGGER.error("Error: Tipo de invocaci\u00F3n no soportada");
						throw new IllegalArgumentException("Tipo de invocaci\u00F3n no soportada");
					}
				} else if (event instanceof DetailNeededEvent) {
					URLRedirectIntegrationResponse urlIntegration = new URLRedirectIntegrationResponse();
					urlIntegration.setUrl(integrationService.resolveTargetUrl(UrlRequestType.INFO_ADICIONAL, codigo,
							MapUtils.toParametrosMapWrapper(event.getEventInfo())));
					response = urlIntegration;
				} else {
					LOGGER.error("Error: Parametrizaci\u00F3n no soportada");
					throw new IllegalArgumentException("Parametrizaci\u00F3n no soportada");
				}
			} catch (ServiceException | CacheIntegrationError e) {
				LOGGER.error("Error: " + e.getMessage());
				throw new IllegalArgumentException(e);
			}
		} else {
			LOGGER.error("Error: C\u00F3digo de servicio incorrecto");
			throw new IllegalArgumentException("C\u00F3digo de servicio incorrecto");
		}

		return response;
	}

	/**
	 * Process get request.
	 *
	 * @param codigo
	 *            the codigo
	 * @param event
	 *            the event
	 * @return the integration response
	 * @throws ServiceValidationException
	 *             the service validation exception
	 * @throws ServiceException
	 *             the service exception
	 */
	@SuppressWarnings("unchecked")
	private IntegrationResponse processGetRequest(String codigo, IntegrationEvent event)throws ServiceValidationException, ServiceException {
		URLRedirectIntegrationResponse result = new URLRedirectIntegrationResponse();
		result.setUrl(integrationService.resolveTargetUrl(UrlRequestType.SERVICIO, codigo, MapUtils.toParametrosMapWrapper(event.getEventInfo())));
		return result;
	}

	/**
	 * Process post request.
	 *
	 * @param codigo
	 *            the codigo
	 * @param event
	 *            the event
	 * @return the integration response
	 * @throws CacheIntegrationError
	 *             the cache integration error
	 */
	private IntegrationResponse processPostRequest(String codigo, IntegrationEvent event) throws CacheIntegrationError {
		URLRedirectIntegrationResponse result = new URLRedirectIntegrationResponse();
		StringBuilder sb = new StringBuilder();
		sb.append(urlHost);
		sb.append(urlContext);
		// event.getEventInfo().remove("eventUser"); con http en lugar da jms, ya no da error
		StringBuilder url = new StringBuilder(
				CacheAdminFactory.getCacheHTTP().encodeInformationURL(sb.toString(), event.getEventInfo()));
		url.append("&codigo=");
		url.append(codigo);
		result.setUrl(url.toString());
		return result;
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

	/**
	 * Gets the servicio service.
	 *
	 * @return the servicio service
	 */
	public ServicioService getServicioService() {
		return servicioService;
	}

	/**
	 * Sets the servicio service.
	 *
	 * @param servicioService
	 *            the new servicio service
	 */
	public void setServicioService(ServicioService servicioService) {
		this.servicioService = servicioService;
	}

	public String getUrlHost() {
		return urlHost;
	}

	public void setUrlHost(String urlHost) {
		this.urlHost = urlHost;
	}

	public String getUrlContext() {
		return urlContext;
	}

	public void setUrlContext(String urlContext) {
		this.urlContext = urlContext;
	}

}
