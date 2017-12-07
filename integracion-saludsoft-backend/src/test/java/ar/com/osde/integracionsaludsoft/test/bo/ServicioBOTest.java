package ar.com.osde.integracionsaludsoft.test.bo;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.cxf.common.util.CollectionUtils;
import org.hibernate.AssertionFailure;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.framework.persistence.exception.PersistenceException;
import ar.com.osde.integracionsaludsoft.bo.ServicioBO;
import ar.com.osde.integracionsaludsoft.bo.impl.ServicioBOImpl;
import ar.com.osde.integracionsaludsoft.bo.impl.ServicioTargetUrlResolverBOImpl;
import ar.com.osde.integracionsaludsoft.dao.ServicioDAO;
import ar.com.osde.integracionsaludsoft.dto.ServicioFilter;
import ar.com.osde.integracionsaludsoft.entities.Parametro;
import ar.com.osde.integracionsaludsoft.entities.Servicio;
import ar.com.osde.integracionsaludsoft.exception.ValidationException;
import ar.com.osde.integracionsaludsoft.test.om.ServicioOM;
import ar.com.osde.integracionsaludsoft.utils.CustomError;

/**
 * The Class ServicioBOTest.
 */
public class ServicioBOTest extends AbstractBOTest {

	/** The Constant EMPRESA_ID. */
	private static final String EMPRESA_ID = "3";

	/** The Constant NAME. */
	private static final String NAME = "SERVICIO_1";

	/** The Constant OBSERVACIONES. */
	private static final String OBSERVACIONES = "observaciones";
	
	/** The Constant CODE. */
	private static final String CODE = "CB2580554";
	
	/** The Constant CODE_URL_PARAMS. */
	private static final String CODE_URL_PARAMS = "C66";

	/** The Constant NON_EXISTENT_CODE. */
	private static final String NON_EXISTENT_CODE = "nonExistentCode";

	/** The Constant BLANK_CODE. */
	private static final String BLANK_CODE = "blankURL";

	/** The Constant CODE_WITHOUT_PARAMS. */
	private static final String CODE_WITHOUT_PARAMS = "CB2580533";

	/** The Constant CODE_OF_INVALID_URL. */
	private static final String CODE_OF_INVALID_URL = "codeInvalidURL";

	/** The Constant NUMERO_CONTACTO. */
	private static final String NUMERO_CONTACTO = "55548897002";

	/** The servicio BO. */
	@Autowired
	private ServicioBO servicioBO;

	/** The servicio BO impl. */
	@InjectMocks
	private ServicioBOImpl servicioBOImpl;

	/** The servicio DAO. */
	@Mock
	private ServicioDAO servicioDAO;

	/** The thrown. */
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/** The default target url. */
	@Autowired
	private ServicioTargetUrlResolverBOImpl servicioUrlResolverBO;

	/** The validate method. */
	private Method validateMethod;

	/**
	 * Setup.
	 *
	 * @throws NoSuchMethodException
	 *             the no such method exception
	 * @throws SecurityException
	 *             the security exception
	 */
	@Before
	public void setup() throws NoSuchMethodException, SecurityException {
		MockitoAnnotations.initMocks(this);
		validateMethod = ServicioBOImpl.class.getDeclaredMethod("validate", Servicio.class);
		validateMethod.setAccessible(true);
	}

	/**
	 * Gets the all.
	 *
	 * @return the all
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void getAll() throws BusinessException, ValidationException {
		int longitud = getServicioBO().getAll().size();
		Assert.assertEquals(longitud, getServicioBO().getAll().size());
	}

	/**
	 * Gets the all parametros.
	 *
	 * @return the all parametros
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void getAllParametros() throws BusinessException, ValidationException {
		List<Servicio> list = getServicioBO().getAll();
		Set<Parametro> parametros = new HashSet<Parametro>();
		for (Servicio item : list) {
			for (Parametro p : item.getParametros()) {
				parametros.add(p);
			}
		}
		int longitud = parametros.size();
		Assert.assertEquals(longitud, parametros.size());
	}

	/**
	 * Creates the url by servicio with parameters.
	 *
	 * @return the URL parameters from servicio
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 */
	@Test
	public void getURLParametersFromServicio() throws BusinessException, ValidationException, MalformedURLException {
		Map<String, String> map = getMap();
		String url = this.getServicioUrlResolverBO().resolveUrl(CODE, map);
		URL urlparameters = new URL(url);
		url = urlparameters.getQuery();
		Assert.assertTrue(url.contains(Parametro.ACTIVIDAD_EMPRESA_ID.getNombre()));
		Assert.assertTrue(url.contains(Parametro.NUMERO_CONTACTO.getNombre()));
		Assert.assertTrue(url.contains(Parametro.OBSERVACION.getNombre()));
		Assert.assertTrue(url.contains(EMPRESA_ID));
		Assert.assertTrue(url.contains(NUMERO_CONTACTO));
		Assert.assertTrue(url.contains(OBSERVACIONES));
	}
	
	/**
	 * Gets the URL with parameters from servicio.
	 *
	 * @return the URL with parameters from servicio
	 * @throws BusinessException the business exception
	 * @throws ValidationException the validation exception
	 * @throws MalformedURLException the malformed URL exception
	 */
	@Test
	public void getURLWithParametersFromServicio() throws BusinessException, ValidationException, MalformedURLException {
		Map<String, String> map = getMap();
		String url = this.getServicioUrlResolverBO().resolveUrl(CODE_URL_PARAMS, map);
		URL urlparameters = new URL(url);
		url = urlparameters.getQuery();
		Assert.assertTrue(url.contains(Parametro.ACTIVIDAD_EMPRESA_ID.getNombre()));
		Assert.assertTrue(url.contains(Parametro.NUMERO_CONTACTO.getNombre()));
		Assert.assertTrue(url.contains(Parametro.OBSERVACION.getNombre()));
		Assert.assertTrue(url.contains(EMPRESA_ID));
		Assert.assertTrue(url.contains(NUMERO_CONTACTO));
		Assert.assertTrue(url.contains(OBSERVACIONES));
	}

	/**
	 * Gets the URL parameters from servicio without service.
	 *
	 * @return the URL parameters from servicio without service
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 */
	@Test
	public void getURLParametersFromServicio_withoutService()
			throws BusinessException, ValidationException, MalformedURLException {
		Map<String, String> map = getMap();
		thrown.expect(BusinessException.class);
		thrown.expectMessage(CustomError.UNABLE_TO_RECOVER_RESULTS.getDescription());
		this.getServicioUrlResolverBO().resolveUrl(NON_EXISTENT_CODE, map);
	}

	/**
	 * Gets the URL parameters from servicio with blank service.
	 *
	 * @return the URL parameters from servicio with blank service
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 */
	@Test
	public void getURLParametersFromServicio_withBlankService()
			throws BusinessException, ValidationException, MalformedURLException {
		Map<String, String> map = getMap();
		thrown.expect(BusinessException.class);
		thrown.expectMessage(CustomError.SERVICIO_MALFORMED_URL.getDescription());
		this.getServicioUrlResolverBO().resolveUrl(BLANK_CODE, map);
	}

	/**
	 * Gets the URL parameters from servicio with invalid URL.
	 *
	 * @return the URL parameters from servicio with invalid URL
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 */
	@Test
	public void getURLParametersFromServicio_withInvalidURL()
			throws BusinessException, ValidationException, MalformedURLException {
		Map<String, String> map = getMap();
		thrown.expect(BusinessException.class);
		thrown.expectMessage(CustomError.SERVICIO_MALFORMED_URL.getDescription());
		this.getServicioUrlResolverBO().resolveUrl(CODE_OF_INVALID_URL, map);
	}

	/**
	 * Gets the URL parameters from servicio without params.
	 *
	 * @return the URL parameters from servicio without params
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void getURLParametersFromServicio_withoutParams() throws BusinessException, ValidationException {
		Map<String, String> map = getMap();
		thrown.expect(BusinessException.class);
		thrown.expectMessage(CustomError.SERVICIO_MALFORMED_URL.getDescription());
		this.getServicioUrlResolverBO().resolveUrl(CODE_WITHOUT_PARAMS, map);
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	private Map<String, String> getMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put(Parametro.NUMERO_CONTACTO.name(), NUMERO_CONTACTO);
		map.put(Parametro.OBSERVACION.name(), OBSERVACIONES);
		map.put(Parametro.ACTIVIDAD_EMPRESA_ID.name(), EMPRESA_ID);
		return map;
	}

	/**
	 * Gets the all by nombre Y codigo.
	 *
	 * @return the all by nombre Y codigo
	 * @throws ValidationException
	 *             the validation exception
	 * @throws BusinessException
	 *             the business exception
	 */
	@Test
	public void getAllByNombreYCodigo() throws ValidationException, BusinessException {
		Boolean result = false;
		ServicioFilter f = new ServicioFilter();
		f.setNombre(NAME);
		f.setCodigo(CODE);
		List<Servicio> listaServicios = servicioBO.getAllByFilter(f);
		if (!CollectionUtils.isEmpty(listaServicios)) {
			for (Servicio item : listaServicios) {
				if (item.getNombre().equals(NAME) && item.getCodigo().equals(CODE)) {
					result = true;
				}
			}
		}
		Assert.assertTrue(result);
	}

	/**
	 * Gets the all by nombre.
	 *
	 * @return the all by nombre
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void getAllByNombre() throws BusinessException, ValidationException {
		Boolean result = false;
		ServicioFilter f = new ServicioFilter();
		f.setNombre(NAME);
		List<Servicio> listaServicios = servicioBO.getAllByFilter(f);
		if (!CollectionUtils.isEmpty(listaServicios)) {
			for (Servicio item : listaServicios) {
				if (item.getNombre().equals(NAME)) {
					result = true;
				}
			}
		}
		Assert.assertTrue(result);
	}

	/**
	 * Gets the all by codigo.
	 *
	 * @return the all by codigo
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void getAllByCodigo() throws BusinessException, ValidationException {
		final String codigo = "CB2580554";
		Boolean result = false;
		ServicioFilter f = new ServicioFilter();
		f.setCodigo(codigo);
		List<Servicio> listaServicios = servicioBO.getAllByFilter(f);
		if (!CollectionUtils.isEmpty(listaServicios)) {
			for (Servicio item : listaServicios) {
				if (item.getCodigo().equals(codigo)) {
					result = true;
				}
			}
		}
		Assert.assertTrue(result);
	}

	/**
	 * Creates the.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void createNewParameters() throws BusinessException, ValidationException {
		int longitud = getServicioBO().getAll().size();
		Servicio srv = ServicioOM.getAServicio();
		int longParam = srv.getParametros().size();
		srv.getParametros().add(Parametro.OBSERVACION);
		Servicio servicio = getServicioBO().save(srv);
		Assert.assertEquals(longitud + 1, getServicioBO().getAll().size());
		Assert.assertNotNull(servicio);
		Assert.assertEquals(longParam + 1, servicio.getParametros().size());
	}

	/**
	 * Save with empty URL gestion interna.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void saveWithEmptyURLGestionInterna() throws BusinessException, ValidationException {
		Servicio srv = ServicioOM.getAServicio();
		srv.setUrlGestionInterna("");
		Servicio servicio = getServicioBO().save(srv);
		Assert.assertNotNull(servicio);
	}

	/**
	 * Save with empty URL info adicional.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void saveWithEmptyURLInfoAdicional() throws BusinessException, ValidationException {
		Servicio srv = ServicioOM.getAServicio();
		srv.setUrlInfoAdicional("");
		Servicio servicio = getServicioBO().save(srv);
		Assert.assertNotNull(servicio);
	}

	/**
	 * Creates the.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void create() throws BusinessException, ValidationException {
		int longitud = getServicioBO().getAll().size();
		Servicio srv = ServicioOM.getAServicio();
		Servicio servicio = getServicioBO().save(srv);
		Assert.assertEquals(longitud + 1, getServicioBO().getAll().size());
		Assert.assertNotNull(servicio);
	}

	/**
	 * Save failed validation existing code.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void save_failedValidation_existingCode() throws BusinessException, ValidationException {
		Servicio srv = ServicioOM.getAServicio();
		srv.setCodigo(servicioBO.getAll().get(0).getCodigo());
		thrown.expect(AssertionFailure.class);
		getServicioBO().save(srv);
	}

	/**
	 * Save failed validation empty code.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void save_failedValidation_emptyCode() throws BusinessException, ValidationException {
		Servicio srv = ServicioOM.getAServicio();
		srv.setCodigo("");

		thrown.expect(ValidationException.class);
		thrown.expectMessage(CustomError.REQUIRED_CODE.getDescription());
		getServicioBO().save(srv);
	}

	/**
	 * Save failed validation empty servicio URL.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void save_failedValidation_emptyServicioURL() throws BusinessException, ValidationException {
		Servicio srv = ServicioOM.getAServicio();
		srv.setUrlServicio("");

		thrown.expect(ValidationException.class);
		thrown.expectMessage(CustomError.REQUIRED_SERVICE_URL.getDescription());
		getServicioBO().save(srv);
	}

	/**
	 * Save failed validation empty params.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void save_failedValidation_emptyParams() throws BusinessException, ValidationException {
		Servicio srv = ServicioOM.getAServicio();
		srv.getParametros().clear();

		thrown.expect(ValidationException.class);
		thrown.expectMessage(CustomError.REQUIRED_ONE_PARAM_AT_LEAST.getDescription());
		getServicioBO().save(srv);
	}

	/**
	 * Save failed validation empty name.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void save_failedValidation_emptyName() throws BusinessException, ValidationException {
		Servicio srv = ServicioOM.getAServicio();
		srv.setNombre("");

		thrown.expect(ValidationException.class);
		thrown.expectMessage(CustomError.REQUIRED_NAME.getDescription());
		getServicioBO().save(srv);
	}

	/**
	 * Save failed validation invalid URL servicio.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void save_failedValidation_invalidURLServicio() throws BusinessException, ValidationException {
		Servicio srv = ServicioOM.getAServicio();
		srv.setUrlServicio("invalid-url");

		thrown.expect(ValidationException.class);
		thrown.expectMessage(CustomError.SERVICIO_MALFORMED_URL.getDescription());
		getServicioBO().save(srv);
	}

	/**
	 * Save failed validation invalid URL gestion interna.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void save_failedValidation_invalidURLGestionInterna() throws BusinessException, ValidationException {
		Servicio srv = ServicioOM.getAServicio();
		srv.setUrlGestionInterna("invalid-url");

		thrown.expect(ValidationException.class);
		thrown.expectMessage(CustomError.GESTION_INTERNA_MALFORMED_URL.getDescription());
		getServicioBO().save(srv);
	}

	/**
	 * Save failed validation invalid URL info adicional.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void save_failedValidation_invalidURLInfoAdicional() throws BusinessException, ValidationException {
		Servicio srv = ServicioOM.getAServicio();
		srv.setUrlInfoAdicional("invalid-url");

		thrown.expect(ValidationException.class);
		thrown.expectMessage(CustomError.INFO_ADICIONAL_MALFORMED_URL.getDescription());
		getServicioBO().save(srv);
	}

	/**
	 * Delete.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void delete() throws BusinessException, ValidationException {
		List<Servicio> servicio = getServicioBO().getAll();
		int longitud = servicio.size();
		this.getServicioBO().delete(servicio.get(0));
		Assert.assertEquals(longitud - 1, getServicioBO().getAll().size());
	}

	/**
	 * Update servicio.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void updateServicio() throws BusinessException, ValidationException {
		int longitud = getServicioBO().getAll().size();
		String nombreUpdated = "NOMBRE_UPDATED";
		Servicio s = getServicioBO().getAll().get(0);
		int longitudParam = s.getParametros().size();
		s.getParametros().add(Parametro.PERSONA_CONTACTO);
		s.getParametros().add(Parametro.ID_ACTIVIDAD_EXTERNA);
		s.getParametros().add(Parametro.ID_CLASIFICACION);
		s.getParametros().add(Parametro.ID_ACTIVIDAD_RELACIONADA);
		Long idS1 = s.getId();
		s.setNombre(nombreUpdated);
		Servicio sUpdated = getServicioBO().update(s);
		Assert.assertEquals(idS1, sUpdated.getId());
		Assert.assertEquals(longitud, getServicioBO().getAll().size());
		Assert.assertEquals(longitudParam + 4, sUpdated.getParametros().size());
	}

	/**
	 * Update null servicio.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void updateNullServicio() throws BusinessException, ValidationException {
		thrown.expect(ValidationException.class);
		thrown.expectMessage(CustomError.REQUIRED_SERVICE.getDescription());
		getServicioBO().update(null);
	}

	/**
	 * Update servicio remove parametro.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void updateServicioRemoveParametro() throws BusinessException, ValidationException {
		int longitud = getServicioBO().getAll().size();
		Servicio servicio = ServicioOM.getAServicio();
		int paramBefore = servicio.getParametros().size();
		servicio.setId(getServicioBO().getAll().get(0).getId());
		Long idS1 = servicio.getId();
		servicio.getParametros().add(Parametro.OBSERVACION);
		Servicio sUpdated = getServicioBO().update(servicio);
		Assert.assertEquals(idS1, sUpdated.getId());
		Assert.assertEquals(longitud, getServicioBO().getAll().size());
		Assert.assertEquals(paramBefore + 1, sUpdated.getParametros().size());
	}

	/**
	 * Gets the by id.
	 *
	 * @return the by id
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void getById() throws BusinessException, ValidationException {
		Long id = 1l;
		Servicio s = this.getServicioBO().getByID(id);
		Assert.assertNotNull(s);
	}

	/**
	 * Gets the by null id.
	 *
	 * @return the by null id
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void getByNullId() throws BusinessException, ValidationException {
		thrown.expect(ValidationException.class);
		thrown.expectMessage(CustomError.REQUIRED_ID.getDescription());
		this.getServicioBO().getByID(null);
	}

	/**
	 * Gets the by codigo.
	 *
	 * @return the by codigo
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void getByCodigo() throws BusinessException, ValidationException {
		String codigo = this.getServicioBO().getAll().get(0).getCodigo();
		Assert.assertNotNull(this.getServicioBO().getByCodigo(codigo));
	}

	/**
	 * Gets the by empty codigo.
	 *
	 * @return the by empty codigo
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void getByEmptyCodigo() throws BusinessException, ValidationException {
		thrown.expect(ValidationException.class);
		thrown.expectMessage(CustomError.REQUIRED_CODE_FOR_SEARCH.getDescription());
		this.getServicioBO().getByCodigo("");
	}

	/**
	 * Gets the by nonexistent code.
	 *
	 * @return the by empty codigo
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void getByNonexistentCode() throws BusinessException, ValidationException {
		Servicio service = this.getServicioBO().getByCodigo("nonexistent-code");
		Assert.assertNull(service);
	}

	/**
	 * Gets the all by filter null filter.
	 *
	 * @return the all by filter null filter
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void getAllByFilter_nullFilter() throws BusinessException, ValidationException {
		thrown.expectMessage(CustomError.REQUIRED_FILTER.getDescription());
		thrown.expect(ValidationException.class);
		servicioBO.getAllByFilter(null);
	}

	/**
	 * Gets the all by filter DAO exception.
	 *
	 * @return the all by filter DAO exception
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void getAllByFilter_DAOException() throws BusinessException, ValidationException {
		ServicioFilter filter = new ServicioFilter();
		filter.setNombre(NAME);
		filter.setCodigo(CODE);

		Mockito.when(servicioDAO.getAllByFilter(filter)).thenThrow(PersistenceException.class);
		thrown.expect(ValidationException.class);
		thrown.expectMessage(CustomError.UNABLE_TO_RECOVER_RESULTS.getDescription());
		servicioBOImpl.getAllByFilter(filter);
	}

	/**
	 * Update DAO exception.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void update_DAOException() throws BusinessException, ValidationException {
		Servicio s = getServicioBO().getAll().get(0);

		Servicio serviceInstance = ServicioOM.getAServicio();
		Mockito.when(servicioDAO.saveOrUpdate((Servicio) Mockito.anyObject())).thenThrow(PersistenceException.class);
		Mockito.when(servicioDAO.getById(s.getId())).thenReturn(serviceInstance);

		thrown.expect(ValidationException.class);
		thrown.expectMessage(CustomError.UNABLE_TO_UPDATE_SERVICE.getDescription());
		servicioBOImpl.update(s);
	}

	/**
	 * Creates the new parameters DAO exception.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void createNewParameters_DAOException() throws BusinessException, ValidationException {
		Servicio srv = ServicioOM.getAServicio();
		srv.getParametros().add(Parametro.OBSERVACION);

		Mockito.when(servicioDAO.saveNew((Servicio) Mockito.anyObject())).thenThrow(PersistenceException.class);
		thrown.expect(ValidationException.class);
		thrown.expectMessage(CustomError.UNABLE_TO_UPDATE_DB.getDescription());
		servicioBOImpl.save(srv);
	}

	/**
	 * Update failed validation existing code.
	 *
	 * @throws BusinessException
	 *             the business exception
	 * @throws ValidationException
	 *             the validation exception
	 */
	@Test
	public void update_failedValidation_existingCode() throws BusinessException, ValidationException {
		Servicio srv = servicioBO.getAll().get(0);
		srv.setCodigo(servicioBO.getAll().get(1).getCodigo());
		thrown.expect(AssertionFailure.class);
		getServicioBO().save(srv);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.osde.integracionsaludsoft.test.bo.AbstractBOTest#
	 * getDbUnitXmlFileName ()
	 */
	@Override
	protected String getDbUnitXmlFileName() {
		return "servicio.xml";
	}

	/**
	 * Gets the servicio BO.
	 *
	 * @return the servicio BO
	 */
	public ServicioBO getServicioBO() {
		return servicioBO;
	}

	/**
	 * Sets the servicio BO.
	 *
	 * @param servicioBO
	 *            the new servicio BO
	 */
	public void setServicioBO(ServicioBO servicioBO) {
		this.servicioBO = servicioBO;
	}

	/**
	 * Gets the servicio url resolver BO.
	 *
	 * @return the servicio url resolver BO
	 */
	public ServicioTargetUrlResolverBOImpl getServicioUrlResolverBO() {
		return servicioUrlResolverBO;
	}

	/**
	 * Sets the servicio url resolver BO.
	 *
	 * @param servicioUrlResolverBO
	 *            the new servicio url resolver BO
	 */
	public void setServicioUrlResolverBO(ServicioTargetUrlResolverBOImpl servicioUrlResolverBO) {
		this.servicioUrlResolverBO = servicioUrlResolverBO;
	}

}
