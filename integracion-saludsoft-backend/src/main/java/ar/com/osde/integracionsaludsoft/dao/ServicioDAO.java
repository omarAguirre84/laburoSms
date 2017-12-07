package ar.com.osde.integracionsaludsoft.dao;

import ar.com.osde.framework.persistence.dao.crud.GenericCRUDDao;
import ar.com.osde.framework.persistence.dao.filter.Result;
import ar.com.osde.integracionsaludsoft.dto.ServicioFilter;
import ar.com.osde.integracionsaludsoft.entities.Servicio;

/**
 * The Interface ServicioDAO.
 */
public interface ServicioDAO extends GenericCRUDDao<Servicio> {

	/**
	 * Gets the all by filter.
	 *
	 * @param filter the filter
	 * @return the all by filter
	 */
	Result<Servicio> getAllByFilter(final ServicioFilter filter);
	
	/**
	 * Gets the by codigo.
	 *
	 * @param codigo the codigo
	 * @return the by codigo
	 */
	Servicio getByCodigo(String codigo);
}
