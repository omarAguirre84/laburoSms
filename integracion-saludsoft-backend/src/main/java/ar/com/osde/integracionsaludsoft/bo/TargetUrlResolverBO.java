package ar.com.osde.integracionsaludsoft.bo;

import java.util.Map;

import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.integracionsaludsoft.exception.ValidationException;

/**
 * The Interface TargetUrlResolverBO.
 */
public interface TargetUrlResolverBO {

	/**
	 * Resolve url.
	 *
	 * @param codigoServicio
	 *            the codigo servicio
	 * @param info
	 *            the info
	 * @return the string
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	String resolveUrl(String codigoServicio, Map<String, String> info) throws BusinessException, ValidationException;

}
