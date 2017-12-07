package ar.com.osde.integracionsaludsoft.bo;

import java.util.List;

import ar.com.osde.framework.business.base.BusinessObject;
import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.integracionsaludsoft.dto.ServicioFilter;
import ar.com.osde.integracionsaludsoft.entities.Servicio;
import ar.com.osde.integracionsaludsoft.exception.ValidationException;

/**
 * The Interface ServicioBO.
 */
public interface ServicioBO extends BusinessObject {

	/**
	 * Gets the all.
	 *
	 * @return the all
	 * @throws BusinessException
	 *             the business exception
	 */
	List<Servicio> getAll() throws BusinessException;

	/**
	 * Gets the all by filter.
	 *
	 * @param filter
	 *            the filter
	 * @return the all by filter
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	List<Servicio> getAllByFilter(ServicioFilter filter) throws BusinessException, ValidationException;

	/**
	 * Gets the by ID.
	 *
	 * @param id
	 *            the id
	 * @return the by ID
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	Servicio getByID(Long id) throws BusinessException, ValidationException;

	/**
	 * Gets the by codigo.
	 *
	 * @param codigo
	 *            the codigo
	 * @return the by codigo
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	Servicio getByCodigo(String codigo) throws BusinessException, ValidationException;

	/**
	 * Save.
	 *
	 * @param servicio
	 *            the servicio
	 * @return the servicio
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	Servicio save(Servicio servicio) throws BusinessException, ValidationException;

	/**
	 * Update.
	 *
	 * @param servicio
	 *            the servicio
	 * @return the servicio
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	Servicio update(Servicio servicio) throws BusinessException, ValidationException;

	/**
	 * Delete.
	 *
	 * @param servicio
	 *            the servicio
	 * @throws BusinessException
	 *             the business exception
	 */
	void delete(Servicio servicio) throws BusinessException;

}
