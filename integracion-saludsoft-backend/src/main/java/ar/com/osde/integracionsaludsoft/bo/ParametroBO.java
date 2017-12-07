package ar.com.osde.integracionsaludsoft.bo;

import java.util.List;

import ar.com.osde.framework.business.base.BusinessObject;
import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.integracionsaludsoft.entities.Parametro;

/**
 * The Interface ParametroBO.
 */
public interface ParametroBO extends BusinessObject {

	/**
	 * Gets the all.
	 *
	 * @return the all
	 * @throws BusinessException
	 *             the business exception
	 */
	List<Parametro> getAll() throws BusinessException;

}
