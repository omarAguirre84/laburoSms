package ar.com.osde.integracionsaludsoft.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.CollectionUtils;

import ar.com.osde.framework.persistence.dao.crud.impl.hibernate.GenericCRUDDaoHIBImpl;
import ar.com.osde.framework.persistence.dao.filter.Filter;
import ar.com.osde.framework.persistence.dao.filter.Page;
import ar.com.osde.framework.persistence.dao.filter.Result;
import ar.com.osde.integracionsaludsoft.dao.ServicioDAO;
import ar.com.osde.integracionsaludsoft.dto.ServicioFilter;
import ar.com.osde.integracionsaludsoft.entities.Servicio;

/**
 * The Class ServicioDAOImpl.
 */
public class ServicioDAOImpl extends GenericCRUDDaoHIBImpl<Servicio> implements ServicioDAO {

	private static final Integer MAX_PAGE = 1000000;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.osde.integracionsaludsoft.dao.ServicioDAO#getAllByFilter(ar.com.
	 * osde.integracionsaludsoft.dto.ServicioFilter)
	 */
	public Result<Servicio> getAllByFilter(final ServicioFilter filter) {
		Result<Servicio> result = this.getAll(new Filter() {

			public void fillCriteriaNotPagination(Criteria criteria) {
				if (StringUtils.isNotBlank(filter.getNombre())) {
					criteria.add(Restrictions.ilike("nombre", filter.getNombre()));
				}

				if (StringUtils.isNotBlank(filter.getCodigo())) {
					criteria.add(Restrictions.ilike("codigo", filter.getCodigo()));
				}

			}

			public void fillCriteria(Criteria criteria) {
				// there is no criteria
			}

		}, new Page(1, MAX_PAGE));

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.osde.integracionsaludsoft.dao.ServicioDAO#getByCodigo(java.lang.
	 * String)
	 */
	public Servicio getByCodigo(final String codigo) {
		Servicio result = null;
		Result<Servicio> list = this.getAll(new Filter() {

			public void fillCriteriaNotPagination(Criteria criteria) {
				criteria.add(Restrictions.eq("codigo", codigo));
			}

			public void fillCriteria(Criteria criteria) {
				// there is no criteria
			}

		}, new Page(1, MAX_PAGE));

		if (!CollectionUtils.isEmpty(list.getResult())) {
			result = list.getResult().get(0);
		}

		return result;
	}

}
