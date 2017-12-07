package ar.com.osde.integracionsaludsoft.entities;

import java.util.Date;
import java.util.Set;

import ar.com.osde.framework.entities.FrameworkEntity;

/**
 * The Class Servicio.
 */
public class Servicio implements FrameworkEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4410839070189835034L;

	/** The id. */
	private Long id;

	/** The nombre. */
	private String nombre;

	/** The codigo. */
	private String codigo;

	/** The url servicio. */
	private String urlServicio;

	/** The url gestion interna. */
	private String urlGestionInterna;

	/** The url info adicional. */
	private String urlInfoAdicional;

	/** The tipo invocacion. */
	private TipoInvocacion tipoInvocacion;

	/** The registra actividad. */
	private Boolean registraActividad;

	/** The created by. */
	private String createdBy;

	/** The date created. */
	private Date dateCreated;

	/** The updated by. */
	private String updatedBy;

	/** The last updated. */
	private Date lastUpdated;

	/** The parametros. */
	private Set<Parametro> parametros;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre
	 *            the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the codigo.
	 *
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Sets the codigo.
	 *
	 * @param codigo
	 *            the new codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Gets the url servicio.
	 *
	 * @return the url servicio
	 */
	public String getUrlServicio() {
		return urlServicio;
	}

	/**
	 * Sets the url servicio.
	 *
	 * @param urlServicio
	 *            the new url servicio
	 */
	public void setUrlServicio(String urlServicio) {
		this.urlServicio = urlServicio;
	}

	/**
	 * Gets the url gestion interna.
	 *
	 * @return the url gestion interna
	 */
	public String getUrlGestionInterna() {
		return urlGestionInterna;
	}

	/**
	 * Sets the url gestion interna.
	 *
	 * @param urlGestionInterna
	 *            the new url gestion interna
	 */
	public void setUrlGestionInterna(String urlGestionInterna) {
		this.urlGestionInterna = urlGestionInterna;
	}

	/**
	 * Gets the url info adicional.
	 *
	 * @return the url info adicional
	 */
	public String getUrlInfoAdicional() {
		return urlInfoAdicional;
	}

	/**
	 * Sets the url info adicional.
	 *
	 * @param urlInfoAdicional
	 *            the new url info adicional
	 */
	public void setUrlInfoAdicional(String urlInfoAdicional) {
		this.urlInfoAdicional = urlInfoAdicional;
	}

	/**
	 * Gets the tipo invocacion.
	 *
	 * @return the tipo invocacion
	 */
	public TipoInvocacion getTipoInvocacion() {
		return tipoInvocacion;
	}

	/**
	 * Sets the tipo invocacion.
	 *
	 * @param tipoInvocacion
	 *            the new tipo invocacion
	 */
	public void setTipoInvocacion(TipoInvocacion tipoInvocacion) {
		this.tipoInvocacion = tipoInvocacion;
	}

	/**
	 * Gets the registra actividad.
	 *
	 * @return the registra actividad
	 */
	public Boolean getRegistraActividad() {
		return registraActividad;
	}

	/**
	 * Sets the registra actividad.
	 *
	 * @param registraActividad
	 *            the new registra actividad
	 */
	public void setRegistraActividad(Boolean registraActividad) {
		this.registraActividad = registraActividad;
	}

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy
	 *            the new created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the date created.
	 *
	 * @return the date created
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * Sets the date created.
	 *
	 * @param dateCreated
	 *            the new date created
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * Gets the last updated.
	 *
	 * @return the last updated
	 */
	public Date getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * Sets the last updated.
	 *
	 * @param lastUpdated
	 *            the new last updated
	 */
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/**
	 * Gets the updated by.
	 *
	 * @return the updated by
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * Sets the updated by.
	 *
	 * @param updatedBy
	 *            the new updated by
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * Gets the parametros.
	 *
	 * @return the parametros
	 */
	public Set<Parametro> getParametros() {
		return parametros;
	}

	/**
	 * Sets the parametros.
	 *
	 * @param parametros
	 *            the new parametros
	 */
	public void setParametros(Set<Parametro> parametros) {
		this.parametros = parametros;
	}

}
