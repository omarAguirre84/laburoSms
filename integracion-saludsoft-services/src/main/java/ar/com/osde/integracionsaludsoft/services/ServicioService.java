package ar.com.osde.integracionsaludsoft.services;

import java.util.List;

import javax.jws.WebService;

import ar.com.osde.framework.services.Service;
import ar.com.osde.framework.services.ServiceException;
import ar.com.osde.integracionsaludsoft.dto.ServicioDTO;
import ar.com.osde.integracionsaludsoft.dto.ServicioFilter;
import ar.com.osde.integracionsaludsoft.exception.ServiceValidationException;

/**
 * The Interface ServicioService.
 */
@WebService
public interface ServicioService extends Service {

	/**
	 * Gets the all.
	 *
	 * @return the all
	 * @throws ServiceException
	 *             the service exception
	 */
	List<ServicioDTO> getAll() throws ServiceException;

	/**
	 * Gets the all by filter.
	 *
	 * @param filter
	 *            the filter
	 * @return the all by filter
	 * @throws ServiceException
	 *             the service exception
	 * @throws ServiceValidationException
	 *             the service validation exception
	 */
	List<ServicioDTO> getAllByFilter(ServicioFilter filter) throws ServiceException, ServiceValidationException;

	/**
	 * Gets the by ID.
	 *
	 * @param id
	 *            the id
	 * @return the by ID
	 * @throws ServiceException
	 *             the service exception
	 * @throws ServiceValidationException
	 *             the service validation exception
	 */
	ServicioDTO getByID(Long id) throws ServiceException, ServiceValidationException;

	/**
	 * Gets the by codigo.
	 *
	 * @param codigo
	 *            the codigo
	 * @return the by codigo
	 * @throws ServiceException
	 *             the service exception
	 * @throws ServiceValidationException
	 *             the service validation exception
	 */
	ServicioDTO getByCodigo(String codigo) throws ServiceException, ServiceValidationException;

	/**
	 * Save.
	 *
	 * @param servicioDTO
	 *            the servicio DTO
	 * @return the servicio DTO
	 * @throws ServiceException
	 *             the service exception
	 * @throws ServiceValidationException
	 *             the service validation exception
	 */
	ServicioDTO save(ServicioDTO servicioDTO) throws ServiceException, ServiceValidationException;

	/**
	 * Update.
	 *
	 * @param servicio
	 *            the servicio
	 * @return the servicio DTO
	 * @throws ServiceException
	 *             the service exception
	 * @throws ServiceValidationException
	 *             the service validation exception
	 */
	ServicioDTO update(ServicioDTO servicio) throws ServiceException, ServiceValidationException;

	/**
	 * Delete.
	 *
	 * @param servicio
	 *            the servicio
	 * @throws ServiceException
	 *             the service exception
	 */
	void delete(ServicioDTO servicio) throws ServiceException;

}
