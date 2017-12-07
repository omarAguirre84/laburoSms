package ar.com.osde.integracionsaludsoft.utils;

/**
 * Custom error messages.
 */
public enum CustomError {

	/** The required filter. */
	REQUIRED_FILTER(0, "Debe ingresar un filtro"),

	/** The unable to recover results. */
	UNABLE_TO_RECOVER_RESULTS(1, "Error al obtener los resultados de la BD"),

	/** The unable to update db. */
	UNABLE_TO_UPDATE_DB(2, "Error al guardar en la BD"),

	/** The required service. */
	REQUIRED_SERVICE(3, "El servicio a actualizar no debe ser null"),

	/** The unable to update service. */
	UNABLE_TO_UPDATE_SERVICE(4, "Error al actualizar el servicio en la BD"),

	/** The required id. */
	REQUIRED_ID(5, "Debe ingresar el ID"),

	/** The required code for search. */
	REQUIRED_CODE_FOR_SEARCH(6, "Debe ingresar el c\u00F3digo, si desea buscar por c\u00F3digo"),

	/** The required name. */
	REQUIRED_NAME(7, "Debe ingresar el nombre"),

	/** The required service url. */
	REQUIRED_SERVICE_URL(8, "Debe ingresar la URL del servicio"),

	/** The required creation user. */
	REQUIRED_CREATION_USER(9, "Debe ingresar por qui\u00E9n fue creado"),

	/** The required update user. */
	REQUIRED_UPDATE_USER(10, "Debe ingresar por qui\u00E9n fue modificado"),

	/** The required one param at least . */
	REQUIRED_ONE_PARAM_AT_LEAST(11, "Debe seleccionar al menos un par\u00E1metro"),

	/** The required code. */
	REQUIRED_CODE(12, "Debe ingresar el c\u00F3digo"),

	/** The servicio malformed url. */
	SERVICIO_MALFORMED_URL(13, "La URL del servicio es inv\u00E1lida"),

	/** The gestion interna malformed url. */
	GESTION_INTERNA_MALFORMED_URL(14, "La URL de gesti\u00F3n interna es inv\u00E1lida"),

	/** The info adicional malformed url. */
	INFO_ADICIONAL_MALFORMED_URL(15, "La URL de info adicional es inv\u00E1lida"),

	/** The required param. */
	REQUIRED_PARAM(16, "Debe seleccionar un par\u00E1metro"),

	/** The generic error. */
	GENERIC_ERROR(17, "Se ha producido un error"),
	
	/** The business logic error. */
	BUSINESS_LOGIC_ERROR(18, "Error de l\u00F3gica de negocios"),
	
	/** The existing code. */
	EXISTING_CODE(19, "Ya existe un servicio con el c\u00F3digo ingresado");

	/** The code. */
	private final int code;

	/** The description. */
	private final String description;

	/**
	 * Instantiates a new custom error.
	 *
	 * @param code
	 *            the code
	 * @param description
	 *            the description
	 */
	private CustomError(int code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * Gets the description.
	 *
	 * @param varargs
	 *            the varargs
	 * @return the description
	 */
	public String getDescription(Object... varargs) {
		return String.format(description, varargs);
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return code + ": " + getDescription();
	}

}