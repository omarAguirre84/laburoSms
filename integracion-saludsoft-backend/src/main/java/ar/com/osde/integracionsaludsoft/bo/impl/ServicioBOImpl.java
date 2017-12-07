package ar.com.osde.integracionsaludsoft.bo.impl;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.framework.context.ContextHolder;
import ar.com.osde.framework.persistence.exception.PersistenceException;
import ar.com.osde.integracionsaludsoft.bo.ServicioBO;
import ar.com.osde.integracionsaludsoft.dao.ServicioDAO;
import ar.com.osde.integracionsaludsoft.dto.ServicioFilter;
import ar.com.osde.integracionsaludsoft.entities.Servicio;
import ar.com.osde.integracionsaludsoft.exception.ValidationException;
import ar.com.osde.integracionsaludsoft.utils.CustomError;

/**
 * The Class ServicioBOImpl.
 */
public class ServicioBOImpl implements ServicioBO {

	/** The servicio DAO. */
	private ServicioDAO servicioDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.osde.integracionsaludsoft.bo.ServicioBO#getAll()
	 */
	public List<Servicio> getAll() throws BusinessException {
		return this.getServicioDAO().getAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.osde.integracionsaludsoft.bo.ServicioBO#getAllByFilter(ar.com.osde
	 * .integracionsaludsoft.dto.ServicioFilter)
	 */
	public List<Servicio> getAllByFilter(ServicioFilter filter) throws BusinessException, ValidationException {
		if (filter == null) {
			throw new ValidationException(CustomError.REQUIRED_FILTER.getDescription());
		}
		try {
			return this.getServicioDAO().getAllByFilter(filter).getResult();
		} catch (PersistenceException e) {
			throw new ValidationException(CustomError.UNABLE_TO_RECOVER_RESULTS.getDescription(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.osde.integracionsaludsoft.bo.ServicioBO#getAllById(java.lang.Long)
	 */
	public Servicio getByID(Long id) throws BusinessException, ValidationException {
		if (id == null) {
			throw new ValidationException(CustomError.REQUIRED_ID.getDescription());
		}
		return this.getServicioDAO().getById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.osde.integracionsaludsoft.bo.ServicioBO#getByCodigo(java.lang.
	 * String)
	 */
	public Servicio getByCodigo(String codigo) throws BusinessException, ValidationException {
		if (StringUtils.isBlank(codigo)) {
			throw new ValidationException(CustomError.REQUIRED_CODE_FOR_SEARCH.getDescription());
		}
		return this.getServicioDAO().getByCodigo(codigo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.osde.integracionsaludsoft.bo.ServicioBO#save(ar.com.osde.
	 * integracionsaludsoft.entities.Servicio)
	 */
	public Servicio save(Servicio servicio) throws BusinessException, ValidationException {
		Date hoy = new Date();
		servicio.setDateCreated(hoy);
		servicio.setLastUpdated(hoy);
		String username = ContextHolder.getContext().getCurrentUser().getUserName();
		servicio.setCreatedBy(username);
		servicio.setUpdatedBy(username);
		this.validate(servicio);
		try {
			return this.getServicioDAO().saveNew(servicio);
		} catch (PersistenceException e) {
			throw new ValidationException(CustomError.UNABLE_TO_UPDATE_DB.getDescription(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.osde.integracionsaludsoft.bo.ServicioBO#update(ar.com.osde.
	 * integracionsaludsoft.entities.Servicio)
	 */
	public Servicio update(Servicio servicio) throws BusinessException, ValidationException {
		if (servicio == null) {
			throw new ValidationException(CustomError.REQUIRED_SERVICE.getDescription());
		}
		servicio.setLastUpdated(new Date());
		servicio.setUpdatedBy(ContextHolder.getContext().getCurrentUser().getUserName());
		Servicio srv = this.getServicioToUpdate(servicio);
		this.validate(srv);
		try {
			return this.getServicioDAO().saveOrUpdate(srv);
		} catch (PersistenceException e) {
			throw new ValidationException(CustomError.UNABLE_TO_UPDATE_SERVICE.getDescription(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.osde.integracionsaludsoft.bo.ServicioBO#delete(ar.com.osde.
	 * integracionsaludsoft.entities.Servicio)
	 */
	public void delete(Servicio servicio) throws BusinessException {
		this.getServicioDAO().delete(servicio);
	}

	/**
	 * Gets the servicio to update.
	 *
	 * @param servicio
	 *            the servicio
	 * @return the servicio to update
	 */
	private Servicio getServicioToUpdate(Servicio servicio) {
		Servicio result = this.getServicioDAO().getById(servicio.getId());
		result.setCodigo(servicio.getCodigo());
		result.setNombre(servicio.getNombre());
		result.setUrlGestionInterna(servicio.getUrlGestionInterna());
		result.setUrlInfoAdicional(servicio.getUrlInfoAdicional());
		result.setUrlServicio(servicio.getUrlServicio());
		result.setTipoInvocacion(servicio.getTipoInvocacion());
		result.setRegistraActividad(servicio.getRegistraActividad());
		result.getParametros().clear();
		result.setParametros(servicio.getParametros());
		result.setLastUpdated(servicio.getLastUpdated());
		result.setUpdatedBy(servicio.getUpdatedBy());

		return result;
	}

	/**
	 * Validate.
	 *
	 * @param servicio
	 *            the servicio
	 * @throws ValidationException
	 *             the validation exception
	 */
	private void validate(Servicio servicio) throws ValidationException {
		if (StringUtils.isEmpty(servicio.getCodigo())) {
			throw new ValidationException(CustomError.REQUIRED_CODE.getDescription());
		}
		if (StringUtils.isEmpty(servicio.getNombre())) {
			throw new ValidationException(CustomError.REQUIRED_NAME.getDescription());
		}

		validateURLServicio(servicio);
		validateURLGestionInterna(servicio);
		validateURLInfoAdicional(servicio);

		if (CollectionUtils.isEmpty(servicio.getParametros())) {
			throw new ValidationException(CustomError.REQUIRED_ONE_PARAM_AT_LEAST.getDescription());
		}
	}

	/**
	 * Validate URL info adicional.
	 *
	 * @param servicio
	 *            the servicio
	 * @throws ValidationException
	 *             the validation exception
	 */
	private void validateURLInfoAdicional(Servicio servicio) throws ValidationException {
		String urlInfoAdicional = servicio.getUrlInfoAdicional();
		if (!StringUtils.isEmpty(urlInfoAdicional) && !this.isValidURL(urlInfoAdicional)) {
			throw new ValidationException(CustomError.INFO_ADICIONAL_MALFORMED_URL.getDescription());
		}
	}

	/**
	 * Validate URL gestion interna.
	 *
	 * @param servicio
	 *            the servicio
	 * @throws ValidationException
	 *             the validation exception
	 */
	private void validateURLGestionInterna(Servicio servicio) throws ValidationException {
		String urlGestionInterna = servicio.getUrlGestionInterna();
		if (!StringUtils.isEmpty(urlGestionInterna) && !this.isValidURL(urlGestionInterna)) {
			throw new ValidationException(CustomError.GESTION_INTERNA_MALFORMED_URL.getDescription());
		}
	}

	/**
	 * Validate URL servicio.
	 *
	 * @param servicio
	 *            the servicio
	 * @throws ValidationException
	 *             the validation exception
	 */
	private void validateURLServicio(Servicio servicio) throws ValidationException {
		if (StringUtils.isEmpty(servicio.getUrlServicio())) {
			throw new ValidationException(CustomError.REQUIRED_SERVICE_URL.getDescription());
		} else if (!this.isValidURL(servicio.getUrlServicio())) {
			throw new ValidationException(CustomError.SERVICIO_MALFORMED_URL.getDescription());
		}
	}

	/**
	 * Valida URL.
	 *
	 * @param url
	 *            the url
	 * @return true, if is valid URL
	 */
	private boolean isValidURL(String url) {
		URL u = null;

		try {
			u = new URL(url);
		} catch (MalformedURLException e) {
			return false;
		}

		try {
			u.toURI();
		} catch (URISyntaxException e) {
			return false;
		}

		return true;
	}

	/**
	 * Gets the servicio DAO.
	 *
	 * @return the servicio DAO
	 */
	public ServicioDAO getServicioDAO() {
		return servicioDAO;
	}

	/**
	 * Sets the servicio DAO.
	 *
	 * @param servicioDAO
	 *            the new servicio DAO
	 */
	public void setServicioDAO(ServicioDAO servicioDAO) {
		this.servicioDAO = servicioDAO;
	}

}
