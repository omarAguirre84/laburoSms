package ar.com.osde.integracionsaludsoft.bo.impl;

import java.net.URISyntaxException;
import java.util.Map;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;

import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.integracionsaludsoft.bo.ServicioBO;
import ar.com.osde.integracionsaludsoft.bo.TargetUrlResolverBO;
import ar.com.osde.integracionsaludsoft.entities.Servicio;
import ar.com.osde.integracionsaludsoft.exception.ValidationException;
import ar.com.osde.integracionsaludsoft.utils.Constants;
import ar.com.osde.integracionsaludsoft.utils.CustomError;
import ar.com.osde.integracionsaludsoft.utils.ResolverUtils;

/**
 * The Class GestionInternaTargetUrlResolverBOImpl.
 */
public class GestionInternaTargetUrlResolverBOImpl implements TargetUrlResolverBO {

	/** The servicio BO. */
	private ServicioBO servicioBO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.osde.integracionsaludsoft.bo.TargetUrlResolverBO#resolveUrl(java.
	 * lang.String, java.util.Map)
	 */
	public String resolveUrl(String codigoServicio, Map<String, String> info)
			throws BusinessException, ValidationException {
		Servicio srv = this.getServicioBO().getByCodigo(codigoServicio);
		if (srv == null) {
			throw new BusinessException(CustomError.UNABLE_TO_RECOVER_RESULTS.getDescription());
		}
		return this.resolveURLParameters(srv, info);
	}

	/**
	 * Resolve URL parameters.
	 *
	 * @param servicio
	 *            the srv
	 * @param info
	 *            the info
	 * @return the string
	 * @throws BusinessException
	 *             the business exception
	 */
	private String resolveURLParameters(Servicio servicio, Map<String, String> info) throws BusinessException {
		try {
			StringBuilder sb = new StringBuilder(servicio.getUrlGestionInterna());
			if (sb.toString().contains("?")) {
				sb.append("&");
			}else{
				sb.append('?');
			}
			sb.append(URLEncodedUtils.format(ResolverUtils.getNameValueList(info), Constants.URL_ENCODING.getDescription()));
			return new HttpGet(sb.toString()).getURI().toString();
		} catch (URISyntaxException e) {
			throw new BusinessException(CustomError.GESTION_INTERNA_MALFORMED_URL.getDescription(), e);
		}
	}

	/**
	 * Gets the servicio BO.
	 *
	 * @return the servicio BO
	 */
	public ServicioBO getServicioBO() {
		return servicioBO;
	}

	/**
	 * Sets the servicio BO.
	 *
	 * @param servicioBO
	 *            the new servicio BO
	 */
	public void setServicioBO(ServicioBO servicioBO) {
		this.servicioBO = servicioBO;
	}

}
