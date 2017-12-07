package ar.com.osde.integracionsaludsoft.test.bo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.integracionsaludsoft.bo.ParametroBO;
import ar.com.osde.integracionsaludsoft.entities.Parametro;

/**
 * The Class ParametroBOTest.
 */
public class ParametroBOTest extends AbstractBOTest {

	/** The parametro BO. */
	@Autowired
	private ParametroBO parametroBO;

	/**
	 * Gets the all parameters.
	 *
	 * @return the all parameters
	 * @throws BusinessException
	 *             the business exception
	 */
	@Test
	public void getAllParameters() throws BusinessException {
		Parametro[] values = Parametro.values();
		List<Parametro> all = this.getParametroBO().getAll();
		Assert.assertEquals(values.length, all.size());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.osde.integracionsaludsoft.test.bo.AbstractBOTest#
	 * getDbUnitXmlFileName()
	 */
	@Override
	protected String getDbUnitXmlFileName() {
		return "servicio.xml";
	}

	/**
	 * Gets the parametro BO.
	 *
	 * @return the parametro BO
	 */
	public ParametroBO getParametroBO() {
		return parametroBO;
	}

	/**
	 * Sets the parametro BO.
	 *
	 * @param parametroBO
	 *            the new parametro BO
	 */
	public void setParametroBO(ParametroBO parametroBO) {
		this.parametroBO = parametroBO;
	}

}
