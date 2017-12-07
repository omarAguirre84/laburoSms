package ar.com.osde.integracionsaludsoft.test.bo;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ar.com.osde.framework.context.Context;
import ar.com.osde.framework.context.ContextHolder;
import ar.com.osde.framework.entities.user.FrameworkUser;
import ar.com.osde.framework.entities.user.Permission;

/**
 * The Class AbstractBOTest.
 */
@ContextConfiguration(locations = "/spring/application-root-spring.xml")
@TransactionConfiguration(transactionManager = "spring.transaction.manager")
@Transactional
public abstract class AbstractBOTest extends AbstractJUnit4SpringContextTests {

	/** The logger. */
	private static Logger logger = Logger.getLogger(AbstractBOTest.class);

	/** The data source. */
	@Autowired
	@Qualifier("spring.datasource")
	protected DataSource dataSource;

	/**
	 * La raz�n por la cual no se usa @BeforeClass es que ese hook corre
	 * cuando el contexto de Spring no est� levantado, y todav�a no se creo
	 * el datasource, ni tampoco se dumpeo y volvi� a crear la base de test
	 * HSQL
	 * 
	 * Esto es gracias a una decisi�n de dise�o de JUnit de correr cada test
	 * en una instancia diferente. Dada esa decisi�n, est� bien que
	 * el @BeforeClass se corra asi y de hecho, que sea est�tico
	 * 
	 */

	@Before
	public void setupDb() {
		/**
		 * TODO Este map es para reemplazar los valores del dbunit, extraerlo
		 */
		Map<String, Object> replacements = new HashMap<String, Object>();
		crearCustomTags(replacements);
		// crea tags para obtener fechas y horas respecto de la hora actual.
		for (int i = 0; i <= 6; i++) {
			crearTagHoraPasado(replacements, i * 10);
			crearTagFechaPasado(replacements, i * 10);
		}

		Connection conn = null;
		IDatabaseConnection connection = null;

		// TODO sacar integr refe.... y probar!!
		try {
			conn = dataSource.getConnection();
			Statement statement = conn.createStatement();
			statement.execute("SET REFERENTIAL_INTEGRITY FALSE");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection = new DatabaseConnection(conn);

			DatabaseConfig config = connection.getConfig();
			config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new HsqldbDataTypeFactory());

			IDataSet dataSet = new FlatXmlDataSet(new File(getXmlFileDbPath()));

			ReplacementDataSet rDataSet = new ReplacementDataSet(dataSet);
			for (Entry<String, Object> entry : replacements.entrySet()) {
				rDataSet.addReplacementObject("${" + entry.getKey() + "}", entry.getValue());
			}

			DatabaseOperation.INSERT.execute(connection, rDataSet);
		} catch (SQLException | DatabaseUnitException | IOException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
		MockitoAnnotations.initMocks(this);
		setContext();
	}

	/**
	 * Crear tag hora pasado.
	 *
	 * @param replacements
	 *            the replacements
	 * @param minutos
	 *            the minutos
	 */
	private void crearTagHoraPasado(Map<String, Object> replacements, Integer minutos) {
		GregorianCalendar calendar;
		calendar = new GregorianCalendar();
		calendar.add(GregorianCalendar.MINUTE, -1 * minutos);
		String tag = "";
		if (minutos > 0) {
			tag = "SYSTIME-" + minutos + "MIN";
		} else {
			tag = "SYSTIME";
		}
		replacements.put(tag, calendar.get(GregorianCalendar.HOUR_OF_DAY) + ":" + calendar.get(GregorianCalendar.MINUTE)
				+ ":" + calendar.get(GregorianCalendar.SECOND));
	}

	/**
	 * Crear tag fecha pasado.
	 *
	 * @param replacements
	 *            the replacements
	 * @param minutos
	 *            the minutos
	 */
	private void crearTagFechaPasado(Map<String, Object> replacements, Integer minutos) {
		GregorianCalendar calendar;
		calendar = new GregorianCalendar();
		calendar.add(GregorianCalendar.MINUTE, -1 * minutos);
		String tag = "";
		if (minutos > 0) {
			tag = "SYSDATE-" + minutos + "MIN";
		} else {
			tag = "SYSDATE";
		}
		replacements.put(tag, calendar.getTime());
	}

	/**
	 * Crear custom tags.
	 *
	 * @param replacements
	 *            the replacements
	 */
	protected void crearCustomTags(Map<String, Object> replacements) {
	}

	/**
	 * Tear down.
	 */
	@After
	// @Deprecated
	public void tearDown() {
		/**
		 * TODO Este map es para reemplazar los valores del dbunit, extraerlo
		 */
		Map<String, Object> replacements = new HashMap<String, Object>();
		crearCustomTags(replacements);
		// crea tags para obtener fechas y horas respecto de la hora actual.
		for (int i = 0; i <= 6; i++) {
			crearTagHoraPasado(replacements, i * 10);
			crearTagFechaPasado(replacements, i * 10);
		}

		Connection conn = null;
		IDatabaseConnection connection = null;

		try {
			conn = dataSource.getConnection();
			Statement statement = conn.createStatement();
			statement.execute("SET REFERENTIAL_INTEGRITY FALSE;");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection = new DatabaseConnection(conn);

			IDataSet dataSet = new FlatXmlDataSet(new File(getXmlFileDbPath()));

			ReplacementDataSet rDataSet = new ReplacementDataSet(dataSet);
			for (Entry<String, Object> entry : replacements.entrySet()) {
				rDataSet.addReplacementObject("${" + entry.getKey() + "}", entry.getValue());
			}
			DatabaseOperation.DELETE_ALL.execute(connection, rDataSet);
		} catch (SQLException | IOException | DatabaseUnitException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}

	/**
	 * Los archivos de dbUnit deben ir en la carpeta "dbUnit" dentro de los
	 * resources de test.
	 *
	 * @return devuelve el path completo del archivo dbUnit a usar
	 */
	private String getXmlFileDbPath() {
		return Thread.currentThread().getContextClassLoader().getResource("dbunit/" + getDbUnitXmlFileName()).getFile();
	}

	/**
	 * Gets the db unit xml file name.
	 *
	 * @return the db unit xml file name
	 */
	protected abstract String getDbUnitXmlFileName();

	/**
	 * Assert collection existence by predicate.
	 *
	 * @param collection
	 *            the collection
	 * @param predicate
	 *            the predicate
	 */
	protected void assertCollectionExistenceByPredicate(Collection<?> collection, final Predicate predicate) {
		Assert.assertTrue(CollectionUtils.exists(collection, predicate));
	}

	/**
	 * Setea datos en el ContextHolder.
	 */
	private void setContext() {
		final Context oldContext = ContextHolder.getContext();
		Context newContext = new Context() {

			@SuppressWarnings("serial")
			public FrameworkUser getCurrentUser() {
				FrameworkUser user = new FrameworkUser() {
					public List<Permission> getPermissions() {
						return null;
					}

					public String getUserName() {
						return "SS38810810";
					}

					public String getAppName() {
						return null;
					}
				};
				return user;
			}

			public Object getBean(String name) {
				return oldContext.getBean(name);
			}

			public String getEnvironment() {
				return oldContext.getEnvironment();
			}

			public String getApplicationName() {
				return oldContext.getApplicationName();
			}

			public String getFrameworkVersion() {
				return oldContext.getFrameworkVersion();
			}

			public String getProperty(String name) {
				return oldContext.getProperty(name);
			}

			public String getCurrentTraceId() {
				return oldContext.getCurrentTraceId();
			}

			public void overrideCurrentTraceId(String traceId) {
				oldContext.overrideCurrentTraceId(traceId);

			}
		};

		ContextHolder.privateSetContext(newContext);
	}

}
