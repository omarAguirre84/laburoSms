package ar.com.osde.integracionsaludsoft.bo.impl;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;

import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.integracionsaludsoft.bo.ServicioBO;
import ar.com.osde.integracionsaludsoft.bo.TargetUrlResolverBO;
import ar.com.osde.integracionsaludsoft.entities.Servicio;
import ar.com.osde.integracionsaludsoft.exception.ValidationException;
import ar.com.osde.integracionsaludsoft.utils.Constants;
import ar.com.osde.integracionsaludsoft.utils.CustomError;

/**
 * The Class ServicioTargetUrlResolverBOImpl.
 */
public class ServicioTargetUrlResolverBOImpl implements TargetUrlResolverBO {

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
		Servicio servicio = this.getServicioBO().getByCodigo(codigoServicio);
		if (servicio == null) {
			throw new BusinessException(CustomError.UNABLE_TO_RECOVER_RESULTS.getDescription());
		}
		return this.resolveURLParameters(servicio, info);
	}

	/**
	 * Gets the all parameters.
	 *
	 * @param srv
	 *            the srv
	 * @param info
	 *            the info
	 * @return the all parameters
	 * @throws BusinessException
	 *             the business exception
	 */
	private List<NameValuePair> getAllParameters(Servicio srv, final Map<String, String> info)
			throws BusinessException {
		return srv.getParametros().stream().map(param -> {
			NameValuePair nvp = new NameValuePair() {
				public String getValue() {
					return info.get(param.name());
				}

				public String getName() {
					return param.getNombre();
				}
			};
			return nvp;
		}).collect(Collectors.toList());
	}

	/**
	 * Resolve URL parameters.
	 *
	 * @param srv
	 *            the srv
	 * @param info
	 *            the info
	 * @return the string
	 * @throws BusinessException
	 *             the business exception
	 */
	private String resolveURLParameters(Servicio srv, Map<String, String> info) throws BusinessException {
		if (org.springframework.util.CollectionUtils.isEmpty(srv.getParametros())) {
			throw new BusinessException(CustomError.SERVICIO_MALFORMED_URL.getDescription());
		}
		try {
			StringBuilder sb = new StringBuilder(srv.getUrlServicio());
			if (sb.toString().contains("?")) {
				sb.append("&");
			}else{
				sb.append('?');
			}
			sb.append(URLEncodedUtils.format(getAllParameters(srv, info), Constants.URL_ENCODING.getDescription()));
			return new HttpGet(sb.toString()).getURI().toString();
		} catch (URISyntaxException e) {
			throw new BusinessException(CustomError.SERVICIO_MALFORMED_URL.getDescription(), e);
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
