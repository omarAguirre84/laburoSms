package ar.com.osde.integracionsaludsoft.test.om;

import java.util.Date;
import java.util.HashSet;

import ar.com.osde.integracionsaludsoft.entities.Parametro;
import ar.com.osde.integracionsaludsoft.entities.Servicio;
import ar.com.osde.integracionsaludsoft.entities.TipoInvocacion;

/**
 * The Class ServicioOM.
 */
public class ServicioOM {

	/** The Constant NAME. */
	public static final String NAME = "SERVICIO_CREATED";

	/** The Constant CODE. */
	public static final String CODE = "code";

	/** The Constant USER. */
	public static final String USER = "jesus";

	/** The Constant URL. */
	public static final String URL = "http://google.com";

	/**
	 * Obtener instancia servicio.
	 *
	 * @return the servicio
	 */
	public static Servicio getAServicio() {
		Servicio serv = new Servicio();
		serv.setCodigo(CODE);
		serv.setNombre(NAME);
		serv.setDateCreated(new Date());
		serv.setCreatedBy(USER);
		serv.setUpdatedBy(USER);
		serv.setUrlServicio(URL);
		serv.setUrlGestionInterna(URL);
		serv.setUrlInfoAdicional(URL);
		serv.setRegistraActividad(true);
		serv.setTipoInvocacion(TipoInvocacion.GET);
		java.util.Set<Parametro> parametros = new HashSet<Parametro>();
		parametros.add(Parametro.ID_ACTIVIDAD_EXTERNA);
		parametros.add(Parametro.ID_ESTADO);
		parametros.add(Parametro.ID_CLASIFICACION);
		serv.setParametros(parametros);
		return serv;
	}

}
