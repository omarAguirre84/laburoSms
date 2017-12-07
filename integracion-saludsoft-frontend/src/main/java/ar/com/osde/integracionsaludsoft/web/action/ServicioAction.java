package ar.com.osde.integracionsaludsoft.web.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;

import com.opensymphony.xwork2.ActionSupport;

import ar.com.osde.framework.services.ServiceException;
import ar.com.osde.integracionsaludsoft.dto.ParametroDTO;
import ar.com.osde.integracionsaludsoft.dto.ServicioDTO;
import ar.com.osde.integracionsaludsoft.dto.ServicioFilter;
import ar.com.osde.integracionsaludsoft.dto.TipoInvocacionDTO;
import ar.com.osde.integracionsaludsoft.exception.ServiceValidationException;
import ar.com.osde.integracionsaludsoft.services.ParametroService;
import ar.com.osde.integracionsaludsoft.services.ServicioService;

/**
 * The Class ServicioAction.
 */
public class ServicioAction extends ActionSupport implements ParameterAware {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3261514599137342996L;

	/** The parameters. */
	private transient Map<String, String[]> parameters;

	/** The servicio service. */
	private transient ServicioService servicioService;

	/** The parametro service. */
	private transient ParametroService parametroService;

	/** The servicios. */
	private List<ServicioDTO> servicios;

	/** The servicio. */
	private ServicioDTO servicio;

	/** The filter. */
	private ServicioFilter filter;

	/** The parametros. */
	private List<ParametroDTO> parametros;

	/** The tipos invocacion. */
	private TipoInvocacionDTO[] tiposInvocacion = TipoInvocacionDTO.values();

	/**
	 * Index.
	 *
	 * @return the string
	 * @throws ServiceException
	 *             the service exception
	 */
	public String index() throws ServiceException {
		return SUCCESS;
	}

	/**
	 * Adds the.
	 *
	 * @return the string
	 * @throws ServiceValidationException
	 *             the service validation exception
	 * @throws ServiceException
	 *             the service exception
	 */
	public String add() throws ServiceValidationException, ServiceException {
		parametros = this.getParametroService().getAll();
		return SUCCESS;
	}

	/**
	 * Edits the.
	 *
	 * @return the string
	 * @throws ServiceValidationException
	 *             the service validation exception
	 * @throws ServiceException
	 *             the service exception
	 */
	public String edit() throws ServiceValidationException, ServiceException {
		Long id = null;
		if (parameters.get("id") != null && parameters.get("id").length > 0) {
			id = Long.parseLong(parameters.get("id")[0]);
		}
		parametros = this.getParametroService().getAll();
		servicio = this.getServicioService().getByID(id);
		return SUCCESS;
	}

	/**
	 * View.
	 *
	 * @return the string
	 * @throws ServiceValidationException
	 *             the service validation exception
	 * @throws ServiceException
	 *             the service exception
	 */
	public String view() throws ServiceValidationException, ServiceException {
		Long id = null;
		if (parameters.get("id") != null && parameters.get("id").length > 0) {
			id = Long.parseLong(parameters.get("id")[0]);
		}
		this.servicio = this.getServicioService().getByID(id);
		this.parametros = new ArrayList<ParametroDTO>(servicio.getParametros());

		return SUCCESS;
	}

	/**
	 * List.
	 *
	 * @return the string
	 * @throws ServiceException
	 *             the service exception
	 */
	public String listByFilter() throws ServiceException {
		servicios = this.getServicioService().getAllByFilter(filter);
		return SUCCESS;
	}

	/**
	 * Save.
	 *
	 * @return the string
	 * @throws ServiceException
	 *             the service exception
	 */
	public String save() throws ServiceException {
		servicio = this.getServicioService().save(servicio);
		return SUCCESS;
	}

	/**
	 * Update.
	 *
	 * @return the string
	 * @throws ServiceValidationException
	 *             the service validation exception
	 * @throws ServiceException
	 *             the service exception
	 */
	public String update() throws ServiceValidationException, ServiceException {
		servicio = this.getServicioService().update(servicio);
		return SUCCESS;
	}

	/**
	 * Show.
	 *
	 * @return the string
	 * @throws ServiceException
	 *             the service exception
	 * @throws ServiceValidationException
	 *             the service validation exception
	 */
	public String show() throws ServiceException, ServiceValidationException {
		Long id = null;
		if (parameters.get("id") != null && parameters.get("id").length > 0) {
			id = Long.parseLong(parameters.get("id")[0]);
		}
		servicio = this.getServicioService().getByID(id);
		return SUCCESS;
	}

	/**
	 * Delete.
	 *
	 * @return the string
	 * @throws ServiceException
	 *             the service exception
	 */
	public String delete() throws ServiceException {
		Long id = null;
		if (parameters.get("id") != null && parameters.get("id").length > 0) {
			id = Long.parseLong(parameters.get("id")[0]);
		}
		servicio = this.getServicioService().getByID(id);
		this.getServicioService().delete(servicio);
		return SUCCESS;
	}

	/**
	 * List all.
	 *
	 * @return the string
	 * @throws ServiceException
	 *             the service exception
	 */
	public String list() throws ServiceException {
		servicios = this.getServicioService().getAll();
		return SUCCESS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.interceptor.ParameterAware#setParameters(java.util
	 * .Map)
	 */
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
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

	/**
	 * Gets the servicios.
	 *
	 * @return the servicios
	 */
	public List<ServicioDTO> getServicios() {
		return servicios;
	}

	/**
	 * Sets the servicios.
	 *
	 * @param servicios
	 *            the new servicios
	 */
	public void setServicios(List<ServicioDTO> servicios) {
		this.servicios = servicios;
	}

	/**
	 * Gets the filter.
	 *
	 * @return the filter
	 */
	public ServicioFilter getFilter() {
		return filter;
	}

	/**
	 * Sets the filter.
	 *
	 * @param filter
	 *            the new filter
	 */
	public void setFilter(ServicioFilter filter) {
		this.filter = filter;
	}

	/**
	 * Gets the servicio.
	 *
	 * @return the servicio
	 */
	public ServicioDTO getServicio() {
		return servicio;
	}

	/**
	 * Sets the servicio.
	 *
	 * @param servicio
	 *            the new servicio
	 */
	public void setServicio(ServicioDTO servicio) {
		this.servicio = servicio;
	}

	/**
	 * Gets the parametros.
	 *
	 * @return the parametros
	 */
	public List<ParametroDTO> getParametros() {
		Collections.sort(parametros, new Comparator<ParametroDTO>() {
			public int compare(ParametroDTO p1, ParametroDTO p2) {
				return p1.getDescripcion().compareToIgnoreCase(p2.getDescripcion());
			}
		});
		return parametros;
	}

	/**
	 * Sets the parametros.
	 *
	 * @param parametros
	 *            the new parametros
	 */
	public void setParametros(List<ParametroDTO> parametros) {
		this.parametros = parametros;
	}

	/**
	 * Gets the parametro service.
	 *
	 * @return the parametro service
	 */
	public ParametroService getParametroService() {
		return parametroService;
	}

	/**
	 * Sets the parametro service.
	 *
	 * @param parametroService
	 *            the new parametro service
	 */
	public void setParametroService(ParametroService parametroService) {
		this.parametroService = parametroService;
	}

	/**
	 * Gets the tipos invocacion.
	 *
	 * @return the tipos invocacion
	 */
	public TipoInvocacionDTO[] getTiposInvocacion() {
		return tiposInvocacion;
	}

	/**
	 * Sets the tipos invocacion.
	 *
	 * @param tiposInvocacion
	 *            the new tipos invocacion
	 */
	public void setTiposInvocacion(TipoInvocacionDTO[] tiposInvocacion) {
		this.tiposInvocacion = tiposInvocacion;
	}

}
