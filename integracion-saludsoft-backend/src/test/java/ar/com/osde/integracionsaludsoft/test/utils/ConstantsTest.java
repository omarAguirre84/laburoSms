package ar.com.osde.integracionsaludsoft.test.utils;

import org.junit.Assert;
import org.junit.Test;

import ar.com.osde.integracionsaludsoft.utils.Constants;

/**
 * The Class ConstantsTest.
 */
public class ConstantsTest {

	/**
	 * Gets the getters.
	 *
	 * @return the getters
	 */
	@Test
	public void getters() {
		Assert.assertNotNull(Constants.INFO_ADICIONAL_ID_ACTIVIDAD_EXTERNA_PARAM);
		Assert.assertNotNull(Constants.INFO_ADICIONAL_USERNAME_PARAM);
		Assert.assertNotNull(Constants.INFO_ADICIONAL_CODIGO_SERVICIO_PARAM);
		Assert.assertNotNull(Constants.GESTION_INTERNA_USERNAME_PARAM);
		Assert.assertNotNull(Constants.GESTION_INTERNA_NOMBRE_PARAM);
		Assert.assertNotNull(Constants.GESTION_INTERNA_ID_CAP_PARAM);
		Assert.assertNotNull(Constants.GESTION_INTERNA_ID_FILIAL_PARAM);
		Assert.assertNotNull(Constants.URL_ENCODING);
	}

}
