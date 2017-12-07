package ar.com.osde.integracionsaludsoft.utils;

/**
 * The Class Constants.
 */
public enum Constants {

	/** The Constant INFO_ADICIONAL_ID_ACTIVIDAD_EXTERNA_PARAM. */
	INFO_ADICIONAL_ID_ACTIVIDAD_EXTERNA_PARAM("id_actividad_externa"),

	/** The Constant INFO_ADICIONAL_USERNAME_PARAM. */
	INFO_ADICIONAL_USERNAME_PARAM("username"),

	/** The Constant INFO_ADICIONAL_CODIGO_SERVICIO_PARAM. */
	INFO_ADICIONAL_CODIGO_SERVICIO_PARAM("codigo_servicio"),

	/** The Constant GESTION_INTERNA_USERNAME_USUARIO_RESPONSABLE. */
	GESTION_INTERNA_USERNAME_PARAM("username"),

	/** The Constant GESTION_INTERNA_NOMBRE_USUARIO_RESPONSABLE. */
	GESTION_INTERNA_NOMBRE_PARAM("nombre"),

	/** The Constant GESTION_INTERNA_ID_CAP_USUARIO_RESPONSABLE. */
	GESTION_INTERNA_ID_CAP_PARAM("id_cap"),

	/** The Constant GESTION_INT_ID_FILIAL_USUARIO_RESPONSABLEE. */
	GESTION_INTERNA_ID_FILIAL_PARAM("id_filial"),

	/** The Constant URL_ENCODING. */
	URL_ENCODING("UTF-8");

	/** The description. */
	private final String description;

	/**
	 * Instantiates a new constant.
	 *
	 * @param description
	 *            the description
	 */
	private Constants(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
