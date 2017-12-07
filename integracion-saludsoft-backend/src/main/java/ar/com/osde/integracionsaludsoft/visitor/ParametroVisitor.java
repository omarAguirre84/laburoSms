package ar.com.osde.integracionsaludsoft.visitor;

import java.util.Map;

import ar.com.osde.framework.business.exception.BusinessException;

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
	 * @throws BusinessException
	 *             the business exception
	 */
	String getValor(Map<String, Object> mapa) throws BusinessException;

}
