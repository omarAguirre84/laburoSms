package ar.com.osde.integracionsaludsoft.services;

import java.util.List;

import javax.jws.WebService;

import ar.com.osde.framework.services.Service;
import ar.com.osde.framework.services.ServiceException;
import ar.com.osde.integracionsaludsoft.dto.ParametroDTO;
import ar.com.osde.integracionsaludsoft.exception.ServiceValidationException;

/**
 * The Interface ParametroService.
 */
@WebService
public interface ParametroService extends Service {

	/**
	 * Gets the all.
	 *
	 * @return the all
	 * @throws ServiceException
	 *             the service exception
	 * @throws ServiceValidationException
	 *             the service validation exception
	 */
	List<ParametroDTO> getAll() throws ServiceException, ServiceValidationException;

}
