package ar.com.osde.integracionsaludsoft.visitor;

import java.util.Map;

/**
 * The Interface ParametroVisitor.
 */
public interface ParametroVisitor {

	/**
	 * Gets the valor.
	 *
	 * @param mapa
	 *            the mapa
	 * @return the valor
	 */
	String getValor(Map<String, Object> mapa);

}
