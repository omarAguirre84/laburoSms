package ar.com.osde.integracionsaludsoft.test.bo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.osde.ccg.integration.EventMapConstants;
import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.integracionsaludsoft.backend.integration.handler.common.RequestMapConstants;
import ar.com.osde.integracionsaludsoft.bo.impl.GestionInternaTargetUrlResolverBOImpl;
import ar.com.osde.integracionsaludsoft.bo.impl.InfoAdicionalTargetUrlResolverBOImpl;
import ar.com.osde.integracionsaludsoft.entities.Parametro;
import ar.com.osde.integracionsaludsoft.exception.ValidationException;
import ar.com.osde.integracionsaludsoft.utils.CustomError;

/**
 * The Class URLResolverBOTest.
 */
public class URLResolverBOTest extends AbstractBOTest {

	/** The code. */
	private static final String CODE = "CB2580554";
	
	private static final String CODE_URL_PARAMS = "C66";

	/** The non existent code. */
	private static final String NON_EXISTENT_CODE = "CB";

	/** The username. */
	private static final String USERNAME = "SS28810810";

	/** The code of invalid url. */
	private static final String CODE_OF_INVALID_URL = "codeInvalidURL";

	/** The thrown. */
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/** The gestion interna url resolver BO. */
	@Autowired
	private GestionInternaTargetUrlResolverBOImpl gestionInternaUrlResolverBO;

	/** The info adic url resolver BO. */
	@Autowired
	private InfoAdicionalTargetUrlResolverBOImpl infoAdicUrlResolverBO;

	/**
	 * Gets the URL gestinon interna parameters.
	 *
	 * @return the URL gestinon interna parameters
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 */
	@Test
	public void getURLGestinonInternaParameters() throws BusinessException, ValidationException, MalformedURLException {
		final String nombreUsuario = "jose";
		final String codCap = "02";
		final String codFilial = "01";

		Map<String, String> map = getMap();
		map.put(RequestMapConstants.USERNAME_USUARIO_RESPONSABLE, USERNAME);
		map.put(RequestMapConstants.NOMBRE_USUARIO_RESPONSABLE, nombreUsuario);
		map.put(RequestMapConstants.ID_CAP_USUARIO_RESPONSABLE, codCap);
		map.put(RequestMapConstants.ID_FILIAL_USUARIO_RESPONSABLE, codFilial);
		String url = this.getGestionInternaUrlResolverBO().resolveUrl(CODE, map);
		URL urlparameters = new URL(url);
		url = urlparameters.getQuery();

		Assert.assertTrue(url.contains(USERNAME));
		Assert.assertTrue(url.contains(nombreUsuario));
		Assert.assertTrue(url.contains(codCap));
		Assert.assertTrue(url.contains(codFilial));
	}

	/**
	 * Gets the URL gestion interna parameters without URL.
	 *
	 * @return the URL gestion interna parameters without URL
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 */
	@Test
	public void getURLGestionInternaParameters_withoutURL()
			throws BusinessException, ValidationException, MalformedURLException {
		Map<String, String> map = getMap();
		map.put(EventMapConstants.EVENT_SERVICIO, NON_EXISTENT_CODE);
		thrown.expect(BusinessException.class);
		thrown.expectMessage(CustomError.UNABLE_TO_RECOVER_RESULTS.getDescription());
		this.getGestionInternaUrlResolverBO().resolveUrl(NON_EXISTENT_CODE, map);
	}

	/**
	 * Gets the URL gestion interna parameters with invalid URL.
	 *
	 * @return the URL gestion interna parameters with invalid URL
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 */
	@Test
	public void getURLGestionInternaParameters_withInvalidURL()
			throws BusinessException, ValidationException, MalformedURLException {
		Map<String, String> map = getMap();
		map.put(EventMapConstants.EVENT_SERVICIO, CODE_OF_INVALID_URL);
		thrown.expect(BusinessException.class);
		thrown.expectMessage(CustomError.GESTION_INTERNA_MALFORMED_URL.getDescription());
		this.getGestionInternaUrlResolverBO().resolveUrl(CODE_OF_INVALID_URL, map);
	}

	/**
	 * Gets the URL info adicional parameters without URL.
	 *
	 * @return the URL info adicional parameters without URL
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 */
	@Test
	public void getURLInfoAdicionalParameters_withoutURL()
			throws BusinessException, ValidationException, MalformedURLException {
		Map<String, String> map = getMap();
		map.put(EventMapConstants.EVENT_SERVICIO, NON_EXISTENT_CODE);
		thrown.expect(BusinessException.class);
		thrown.expectMessage(CustomError.UNABLE_TO_RECOVER_RESULTS.getDescription());
		this.getInfoAdicUrlResolverBO().resolveUrl(NON_EXISTENT_CODE, map);
	}

	/**
	 * Gets the URL info adicional parameters with invalid URL.
	 *
	 * @return the URL info adicional parameters with invalid URL
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 */
	@Test
	public void getURLInfoAdicionalParameters_withInvalidURL()
			throws BusinessException, ValidationException, MalformedURLException {
		Map<String, String> map = getMap();
		map.put(EventMapConstants.EVENT_SERVICIO, CODE_OF_INVALID_URL);
		thrown.expect(BusinessException.class);
		thrown.expectMessage(CustomError.INFO_ADICIONAL_MALFORMED_URL.getDescription());
		this.getInfoAdicUrlResolverBO().resolveUrl(CODE_OF_INVALID_URL, map);
	}

	/**
	 * Gets the URL info adicional parameters.
	 *
	 * @return the URL info adicional parameters
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 */
	@Test
	public void getURLInfoAdicionalParameters() throws BusinessException, ValidationException, MalformedURLException {
		Map<String, String> map = getMap();
		map.put(EventMapConstants.EVENT_SERVICIO, CODE);
		String url = this.getInfoAdicUrlResolverBO().resolveUrl(CODE, map);
		URL urlparameters = new URL(url);
		url = urlparameters.getQuery();

		Assert.assertTrue(url.contains(USERNAME));
		Assert.assertTrue(url.contains("09"));
		Assert.assertTrue(url.contains(CODE));
	}

	@Test
	public void getURLGIWithParameters() throws BusinessException, ValidationException, MalformedURLException {
		final String nombreUsuario = "jose";
		final String codCap = "02";
		final String codFilial = "01";
		Map<String, String> map = getMap();
		map.put(RequestMapConstants.USERNAME_USUARIO_RESPONSABLE, USERNAME);
		map.put(RequestMapConstants.NOMBRE_USUARIO_RESPONSABLE, nombreUsuario);
		map.put(RequestMapConstants.ID_CAP_USUARIO_RESPONSABLE, codCap);
		map.put(RequestMapConstants.ID_FILIAL_USUARIO_RESPONSABLE, codFilial);
		String url = this.getGestionInternaUrlResolverBO().resolveUrl(CODE_URL_PARAMS, map);
		URL urlparameters = new URL(url);
		url = urlparameters.getQuery();
		Assert.assertTrue(url.contains(USERNAME));
		Assert.assertTrue(url.contains(nombreUsuario));
		Assert.assertTrue(url.contains(codCap));
		Assert.assertTrue(url.contains(codFilial));
	}
	
	@Test
	public void getURLInfoAdicWithParameters() throws BusinessException, ValidationException, MalformedURLException {
		Map<String, String> map = getMap();
		map.put(EventMapConstants.EVENT_SERVICIO, CODE_URL_PARAMS);
		String url = this.getInfoAdicUrlResolverBO().resolveUrl(CODE_URL_PARAMS, map);
		URL urlparameters = new URL(url);
		url = urlparameters.getQuery();
		Assert.assertTrue(url.contains(CODE_URL_PARAMS));
		Assert.assertTrue(url.contains("09"));
		Assert.assertTrue(url.contains(USERNAME));
	}
	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	private Map<String, String> getMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put(EventMapConstants.EVENT_USER, USERNAME);
		map.put(EventMapConstants.EVENT_DETAIL_ID, "09");
		return map;
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
	 * Gets the gestion interna url resolver BO.
	 *
	 * @return the gestion interna url resolver BO
	 */
	public GestionInternaTargetUrlResolverBOImpl getGestionInternaUrlResolverBO() {
		return gestionInternaUrlResolverBO;
	}

	/**
	 * Sets the gestion interna url resolver BO.
	 *
	 * @param gestionInternaUrlResolverBO
	 *            the new gestion interna url resolver BO
	 */
	public void setGestionInternaUrlResolverBO(GestionInternaTargetUrlResolverBOImpl gestionInternaUrlResolverBO) {
		this.gestionInternaUrlResolverBO = gestionInternaUrlResolverBO;
	}

	/**
	 * Gets the info adic url resolver BO.
	 *
	 * @return the info adic url resolver BO
	 */
	public InfoAdicionalTargetUrlResolverBOImpl getInfoAdicUrlResolverBO() {
		return infoAdicUrlResolverBO;
	}

	/**
	 * Sets the info adic url resolver BO.
	 *
	 * @param infoAdicUrlResolverBO
	 *            the new info adic url resolver BO
	 */
	public void setInfoAdicUrlResolverBO(InfoAdicionalTargetUrlResolverBOImpl infoAdicUrlResolverBO) {
		this.infoAdicUrlResolverBO = infoAdicUrlResolverBO;
	}

}
