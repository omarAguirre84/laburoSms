package ar.com.osde.integracionsaludsoft.bo.impl;

import java.util.List;

import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.integracionsaludsoft.bo.ParametroBO;
import ar.com.osde.integracionsaludsoft.entities.Parametro;
import edu.emory.mathcs.backport.java.util.Arrays;

/**
 * The Class ParametroBOImpl.
 */
public class ParametroBOImpl implements ParametroBO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.osde.integracionsaludsoft.bo.ParametroBO#getAll()
	 */
	@SuppressWarnings("unchecked")
	public List<Parametro> getAll() throws BusinessException {
		return Arrays.asList(Parametro.values());
	}

}
