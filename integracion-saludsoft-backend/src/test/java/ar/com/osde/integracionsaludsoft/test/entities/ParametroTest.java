package ar.com.osde.integracionsaludsoft.test.entities;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ar.com.osde.ccg.integration.EventMapConstants;
import ar.com.osde.ccg.integration.beans.Actividad;
import ar.com.osde.ccg.integration.beans.Clasificacion;
import ar.com.osde.ccg.integration.beans.Empresa;
import ar.com.osde.ccg.integration.beans.FormaContacto;
import ar.com.osde.ccg.integration.beans.MotivoContacto;
import ar.com.osde.ccg.integration.beans.Servicio;
import ar.com.osde.ccg.integration.beans.State;
import ar.com.osde.ccg.integration.beans.TipoSujeto;
import ar.com.osde.ccg.integration.beans.sujetos.NoSocioOsdeBinario;
import ar.com.osde.ccg.integration.beans.sujetos.SocioOsdeBinario;
import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.framework.security.intranet.IntranetUser;
import ar.com.osde.framework.security.intranet.bean.Filial;
import ar.com.osde.framework.security.intranet.bean.PersonalData;
import ar.com.osde.integracionsaludsoft.dto.ParametroDTO;
import ar.com.osde.integracionsaludsoft.test.om.SujetoOM;

/**
 * The Class ParametroTest.
 */
public class ParametroTest {

	/** The persona contacto. */
	private final String PERSONA_CONTACTO = "persona";

	/** The ext activity id. */
	private final String EXT_ACTIVITY_ID = "activityID";

	/** The id relacionada. */
	private final String ID_RELACIONADA = "IDrelacionada";

	/** The obs. */
	private final String OBS = "obs";

	/** The estado id. */
	private final Long ESTADO_ID = Long.valueOf(1L);

	/** The clasificacion id. */
	private final Long CLASIFICACION_ID = Long.valueOf(2L);

	/** The motivo id. */
	private final Long MOTIVO_ID = Long.valueOf(3L);

	/** The empresa description. */
	private final String EMPRESA_DESCRIPTION = "empresa_descripcion";

	/** The workflow estado. */
	private final String WORKFLOW_ESTADO = "workflow_estado";

	/** The estado desc. */
	private final String ESTADO_DESC = "estadoDesc";

	/** The cap description. */
	private final String CAP_DESCRIPTION = "capDescription";

	/** The pd cap description. */
	private final String PD_CAP_DESCRIPTION = "PDCapDescription";

	/** The cap id. */
	private final String CAP_ID = "capID";

	/** The filial description. */
	private final String FILIAL_DESCRIPTION = "filialDesc";

	/** The filial id. */
	private final String FILIAL_ID = "filialID";

	/** The first name. */
	private final String FIRST_NAME = "firstName";

	/** The last name. */
	private final String LAST_NAME = "last-name";

	/** The username. */
	private final String USERNAME = "user-name";

	/** The user name. */
	private final String USER_NAME = "name";

	/** The una descripcion. */
	private final String UNA_DESCRIPCION = "description";

	/** The un id. */
	private final Long UN_ID = Long.valueOf(3L);

	/** The thrown. */
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * Resolver interlocutor socio osde binario.
	 *
	 * @throws BusinessException
	 *             the business exception
	 */
	@Test
	public void resolverInterlocutor_socioOsdeBinario() throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>();
		Actividad actividad = new Actividad();

		SocioOsdeBinario socioOsdeBinario = SujetoOM.getSocioOsdeBinario();
		actividad.setSujetoActividad(socioOsdeBinario);
		map.put(EventMapConstants.EVENT_ACTIVIDAD, actividad);

		Assert.assertEquals(SujetoOM.VISIBILIDAD,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_AMBITO_VISIBILIDAD.getValor(map));
	}

	/**
	 * Gets the valor interlocutor and domicilio methods no socio.
	 *
	 * @return the valor interlocutor and domicilio methods no socio
	 * @throws BusinessException
	 *             the business exception
	 */
	@Test
	public void getValor_interlocutorAndDomicilioMethods_noSocio() throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>();
		Actividad actividad = new Actividad();

		NoSocioOsdeBinario noSocioOsdeBinario = SujetoOM.getNoSocioOsdeBinario();
		actividad.setSujetoActividad(noSocioOsdeBinario);
		actividad.setSujetoContacto(noSocioOsdeBinario);
		map.put(EventMapConstants.EVENT_ACTIVIDAD, actividad);

		Assert.assertEquals(SujetoOM.VISIBILIDAD,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_AMBITO_VISIBILIDAD.getValor(map));
		Assert.assertEquals(SujetoOM.APELLIDO,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_APELLIDO.getValor(map));
		Assert.assertEquals(SujetoOM.DISC_PERMANENTE,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DISC_PERMANENTE.getValor(map));
		Assert.assertNotNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DISCAPACIDAD.getValor(map));
		Assert.assertEquals(SujetoOM.BARRIO,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_BARRIO.getValor(map));
		Assert.assertEquals(SujetoOM.CALLE,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_CALLE.getValor(map));
		Assert.assertEquals(SujetoOM.CODIGO_POSTAL,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_CODIGO_POSTAL.getValor(map));
		Assert.assertEquals(SujetoOM.DEPTO,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_DEPTO.getValor(map));
		Assert.assertEquals(SujetoOM.ACTUAL,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_ACTUAL.getValor(map));
		Assert.assertEquals(SujetoOM.LOCALIDAD,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_LOCALIDAD.getValor(map));
		Assert.assertEquals(SujetoOM.NUMERO,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_NUMERO.getValor(map));
		Assert.assertEquals(SujetoOM.PAIS,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_PAIS.getValor(map));
		Assert.assertEquals(SujetoOM.PISO,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_PISO.getValor(map));
		Assert.assertEquals(SujetoOM.PROVINCIA_CODIGO,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_PROVINCIA_CODIGO.getValor(map));
		Assert.assertEquals(SujetoOM.PROVINCIA_DESCRIPCION,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_PROVINCIA_DESC.getValor(map));
		Assert.assertEquals(SujetoOM.TIPO_DOMICILIO_CODIGO,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_TIPO_DOMICILIO_CODIGO.getValor(map));
		Assert.assertEquals(SujetoOM.TIPO_DOMICILIO_DESC,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_TIPO_DOMICILIO_DSC.getValor(map));
		Assert.assertEquals(SujetoOM.NRO_INTERLOCUTOR,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_NRO_INTERLOCUTOR.getValor(map));
		Assert.assertEquals(SujetoOM.EDAD, ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_EDAD.getValor(map));
		Assert.assertEquals(SujetoOM.FECHA_NACIMIENTO,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_FECHA_NACIMIENTO.getValor(map));
		Assert.assertNotNull(SujetoOM.MARCA_DISC_FACT,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_MARCA_DISCAPACIDAD_FACTURACION.getValor(map));
		Assert.assertNotNull(SujetoOM.MARCA_DISC,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_MARCA_DISCAPACITADO.getValor(map));
		Assert.assertEquals(SujetoOM.NOMBRE, ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_NOMBRE.getValor(map));
		Assert.assertEquals(SujetoOM.SEXO, ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_SEXO.getValor(map));

		Assert.assertEquals(SujetoOM.VISIBILIDAD,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_AMBITO_VISIBILIDAD.getValor(map));
		Assert.assertEquals(SujetoOM.APELLIDO,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_APELLIDO.getValor(map));
		Assert.assertEquals(SujetoOM.DISC_PERMANENTE,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DISC_PERMANENTE.getValor(map));
		Assert.assertNotNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DISCAPACIDAD.getValor(map));
		Assert.assertEquals(SujetoOM.BARRIO,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_BARRIO.getValor(map));
		Assert.assertEquals(SujetoOM.CALLE,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_CALLE.getValor(map));
		Assert.assertEquals(SujetoOM.CODIGO_POSTAL,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_CODIGO_POSTAL.getValor(map));
		Assert.assertEquals(SujetoOM.DEPTO,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_DEPTO.getValor(map));
		Assert.assertEquals(SujetoOM.ACTUAL,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_ACTUAL.getValor(map));
		Assert.assertEquals(SujetoOM.LOCALIDAD,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_LOCALIDAD.getValor(map));
		Assert.assertEquals(SujetoOM.NUMERO,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_NUMERO.getValor(map));
		Assert.assertEquals(SujetoOM.PAIS,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_PAIS.getValor(map));
		Assert.assertEquals(SujetoOM.PISO,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_PISO.getValor(map));
		Assert.assertEquals(SujetoOM.PROVINCIA_CODIGO,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_PROVINCIA_CODIGO.getValor(map));
		Assert.assertEquals(SujetoOM.PROVINCIA_DESCRIPCION,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_PROVINCIA_DESC.getValor(map));
		Assert.assertEquals(SujetoOM.TIPO_DOMICILIO_CODIGO,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_TIPO_DOMICILIO_CODIGO.getValor(map));
		Assert.assertEquals(SujetoOM.TIPO_DOMICILIO_DESC,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_TIPO_DOMICILIO_DSC.getValor(map));
		Assert.assertEquals(SujetoOM.EDAD, ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_EDAD.getValor(map));
		Assert.assertEquals(SujetoOM.FECHA_NACIMIENTO,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_FECHA_NACIMIENTO.getValor(map));
		Assert.assertNotNull(
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_MARCA_DISCAPACIDAD_FACTURACION.getValor(map));
		Assert.assertNotNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_MARCA_DISCAPACITADO.getValor(map));
		Assert.assertEquals(SujetoOM.NOMBRE, ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_NOMBRE.getValor(map));
		Assert.assertEquals(SujetoOM.NRO_INTERLOCUTOR,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_NRO_INTERLOCUTOR.getValor(map));
		Assert.assertEquals(SujetoOM.SEXO, ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_SEXO.getValor(map));
	}

	/**
	 * Gets the ters.
	 *
	 * @return the ters
	 */
	@Test
	public void getters() {
		final ParametroDTO parametroDTO = ParametroDTO.ACTIVIDAD_EMPRESA_DESCRIPCION;
		Assert.assertNotNull(parametroDTO.getDescripcion());
		Assert.assertNotNull(parametroDTO.getRegistraActividad());
	}

	/**
	 * Gets the valor methods.
	 *
	 * @return the valor methods
	 * @throws BusinessException
	 *             the business exception
	 */
	@Test
	public void getValor_methods() throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>();

		Actividad actividad = new Actividad();
		actividad.setExtActivityId(EXT_ACTIVITY_ID);
		actividad.setIdRelacionada(ID_RELACIONADA);
		actividad.setObservaciones(OBS);
		actividad.setPersonaContacto(PERSONA_CONTACTO);

		actividad.setEstado(this.getUnEstado());

		Clasificacion clasificacion = new Clasificacion();
		clasificacion.setId(CLASIFICACION_ID);
		actividad.setClasificacion(clasificacion);

		MotivoContacto motivo = new MotivoContacto();
		motivo.setId(MOTIVO_ID);
		actividad.setMotivo(motivo);

		Empresa empresa = new Empresa();
		empresa.setDescription(EMPRESA_DESCRIPTION);
		actividad.setEmpresa(empresa);

		map.put(EventMapConstants.EVENT_ACTIVIDAD, actividad);

		Assert.assertEquals(EXT_ACTIVITY_ID, ParametroDTO.ID_ACTIVIDAD_EXTERNA.getValor(map));
		Assert.assertEquals(ID_RELACIONADA, ParametroDTO.ID_ACTIVIDAD_RELACIONADA.getValor(map));
		Assert.assertEquals(OBS, ParametroDTO.OBSERVACION.getValor(map));
		Assert.assertEquals(PERSONA_CONTACTO, ParametroDTO.PERSONA_CONTACTO.getValor(map));
		Assert.assertEquals(ESTADO_ID.toString(), ParametroDTO.ID_ESTADO.getValor(map));
		Assert.assertEquals(CLASIFICACION_ID.toString(), ParametroDTO.ID_CLASIFICACION.getValor(map));
		Assert.assertEquals(MOTIVO_ID.toString(), ParametroDTO.ID_MOTIVO_CONTACTO.getValor(map));
		Assert.assertEquals(EMPRESA_DESCRIPTION, ParametroDTO.ACTIVIDAD_EMPRESA_DESCRIPCION.getValor(map));
	}

	/**
	 * Gets the un estado.
	 *
	 * @return the un estado
	 */
	private State getUnEstado() {
		State state = new State();
		state.setId(ESTADO_ID);
		state.setWorkflowStateId(WORKFLOW_ESTADO);
		state.setDescription(ESTADO_DESC);

		return state;
	}

	/**
	 * Gets the valor sujeto contacto methods.
	 *
	 * @return the valor sujeto contacto methods
	 * @throws BusinessException
	 *             the business exception
	 */
	@Test
	public void getValor_sujetoContactoMethods() throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>();
		Actividad actividad = new Actividad();
		actividad.setSujetoContacto(SujetoOM.getSocioOsdeBinario());
		map.put(EventMapConstants.EVENT_ACTIVIDAD, actividad);

		Assert.assertEquals(SujetoOM.AYN_PROMOTOR,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_AYN_PROMOTOR.getValor(map));
		Assert.assertEquals(SujetoOM.DEUDA, ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_DEUDA.getValor(map));
		Assert.assertEquals(SujetoOM.FECHA_ALTA,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_ALTA.getValor(map));
		Assert.assertEquals(SujetoOM.FECHA_BAJA,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_BAJA.getValor(map));
		Assert.assertEquals(SujetoOM.FECHA_FLAG,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_FLAG_RYA.getValor(map));
		Assert.assertEquals(SujetoOM.FECHA_MAN,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_MAN_POS.getValor(map));
		Assert.assertEquals(SujetoOM.FECHA_VIGENCIA_PLAN,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_VIGENCIA_PLAN.getValor(map));
		Assert.assertEquals(SujetoOM.FILIAL_GESTION,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FILIAL_GESTION.getValor(map));
		Assert.assertEquals(SujetoOM.FILIAL_GESTION_ID,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FILIAL_GESTION_ID.getValor(map));
		Assert.assertEquals(SujetoOM.FILIAL_SERVICIO,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FILIAL_SERVICIO.getValor(map));
		Assert.assertEquals(SujetoOM.FILIAL_SERVICIO_ID,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FILIAL_SERVICIO_ID.getValor(map));
		Assert.assertEquals(SujetoOM.FLAG_AUT_POS,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_AUT_POS.getValor(map));
		Assert.assertEquals(SujetoOM.FLAG_AUT_RYA,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_AUT_RYA.getValor(map));
		Assert.assertEquals(SujetoOM.FLAG_MAN_POS,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_MAN_POS.getValor(map));
		Assert.assertEquals(SujetoOM.FLAG_MAN_RYA,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_MAN_RYA.getValor(map));
		Assert.assertEquals(SujetoOM.FLAG_PRESTADOR,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_PRESTADOR.getValor(map));
		Assert.assertEquals(SujetoOM.GESTOR, ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_GESTOR.getValor(map));
		Assert.assertEquals(SujetoOM.IC_PROMOTOR,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_IC_PROMOTOR.getValor(map));
		Assert.assertEquals(SujetoOM.MAIL, ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MAIL.getValor(map));
		Assert.assertEquals(SujetoOM.MARCA_GESTOR_ASIGNADO,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MARCA_GESTOR_ASIGNADO.getValor(map));
		Assert.assertEquals(SujetoOM.MARCA_GESTOR_PERMANENTE,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MARCA_GESTOR_PERMANENTE.getValor(map));
		Assert.assertEquals(SujetoOM.MESES_REC,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MESES_RECALCULADOS.getValor(map));
		Assert.assertEquals(SujetoOM.MESES_REC_CALCULADO,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MESES_REC_CALCULADOS.getValor(map));
		Assert.assertEquals(SujetoOM.MOTIVO_BAJA,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MOTIVO_BAJA.getValor(map));
		Assert.assertEquals(SujetoOM.NRO_CONTRATO,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_NRO_CONTRATO.getValor(map));
		Assert.assertEquals(SujetoOM.NRO_ORDEN,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_NRO_ORDEN.getValor(map));
		Assert.assertNotNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_PLAN.getValor(map));
		Assert.assertEquals(SujetoOM.PLAN_SAP, ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_PLAN_SAP.getValor(map));
		Assert.assertEquals(SujetoOM.CODIGO_OBRA_SOCIAL,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_COD_OBRA_SOCIAL.getValor(map));
		Assert.assertEquals(SujetoOM.DESCRIPCION_OBRA_SOCIAL,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_DESC_OBRA_SOCIAL.getValor(map));
		Assert.assertEquals(SujetoOM.MODO_CONTRATACION,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_MODO_CONTRATACION.getValor(map));
		Assert.assertEquals(SujetoOM.NRO_CONTRATO,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_NRO_CONTRATO.getValor(map));
		Assert.assertEquals(SujetoOM.NRO_INTERLOCUTOR,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_NRO_INTERLOCUTOR.getValor(map));
		Assert.assertEquals(SujetoOM.ROTULO_IVA,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_ROTULO_IVA.getValor(map));
		Assert.assertEquals(SujetoOM.SECTOR, ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_SECTOR.getValor(map));
		Assert.assertEquals(SujetoOM.SECTOR_DSC,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_SECTOR_DSC.getValor(map));
		Assert.assertEquals(SujetoOM.COMPLEMENTACION,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_SOCIO_DIRECTO_OBRA_SOCIAL_COMPLEMENTACION
						.getValor(map));
		Assert.assertEquals(SujetoOM.TIPO_SOCIO,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_TIPO_SOCIO.getValor(map));
		Assert.assertEquals(SujetoOM.VENCIMIENTO_CREDENCIAL,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_VENCIMIENTO_CREDENCIAL.getValor(map));
		Assert.assertEquals(SujetoOM.VERSION_CREDENCIAL,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_VERSION_CREDENCIAL.getValor(map));
		Assert.assertEquals(SujetoOM.APELLIDO.toUpperCase(),
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_APELLIDO.getValor(map));
		Assert.assertEquals(SujetoOM.CONDADO,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_CONDADO.getValor(map));
		Assert.assertEquals(SujetoOM.CONDADO_ID,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_CONDADO_ID.getValor(map));
		Assert.assertEquals(SujetoOM.ES_AGENTE_PERCEPCION,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_ES_AGENTE_PERCEPCION.getValor(map));
		Assert.assertEquals(SujetoOM.EXISTE_PADRON,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_EXISTE_PADRON_ARBA.getValor(map));
		Assert.assertEquals(SujetoOM.EXISTEN_EXTENSIONES,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_EXISTEN_EXTENSIONES.getValor(map));
		Assert.assertEquals(SujetoOM.NOMBRE.toUpperCase(), ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_NOMBRE.getValor(map));
		Assert.assertNotNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_NOMBRE_COMPLETO.getValor(map));
		Assert.assertEquals(SujetoOM.NRO_INTERLOCUTOR,
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_NRO_INTERLOCUTOR.getValor(map));
		Assert.assertEquals(SujetoOM.SEXO, ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_SEXO.getValor(map));
	}

	/**
	 * Gets the valor sujeto actividad methods.
	 *
	 * @return the valor sujeto actividad methods
	 * @throws BusinessException
	 *             the business exception
	 */
	@Test
	public void getValor_sujetoActividadMethods() throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>();
		Actividad actividad = new Actividad();
		actividad.setSujetoActividad(SujetoOM.getSocioOsdeBinario());
		map.put(EventMapConstants.EVENT_ACTIVIDAD, actividad);

		Assert.assertEquals(SujetoOM.AYN_PROMOTOR,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_AYN_PROMOTOR.getValor(map));
		Assert.assertEquals(SujetoOM.DEUDA, ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_DEUDA.getValor(map));
		Assert.assertEquals(SujetoOM.FECHA_ALTA,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FECHA_ALTA.getValor(map));
		Assert.assertEquals(SujetoOM.FECHA_BAJA,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FECHA_BAJA.getValor(map));
		Assert.assertEquals(SujetoOM.FECHA_FLAG,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FECHA_FLAG_RYA.getValor(map));
		Assert.assertEquals(SujetoOM.FECHA_MAN,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FECHA_MAN_POS.getValor(map));
		Assert.assertEquals(SujetoOM.FECHA_VIGENCIA_PLAN,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FECHA_VIGENCIA_PLAN.getValor(map));
		Assert.assertEquals(SujetoOM.FILIAL_GESTION,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FILIAL_GESTION.getValor(map));
		Assert.assertEquals(SujetoOM.FILIAL_GESTION_ID,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FILIAL_GESTION_ID.getValor(map));
		Assert.assertEquals(SujetoOM.FILIAL_SERVICIO,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FILIAL_SERVICIO.getValor(map));
		Assert.assertEquals(SujetoOM.FILIAL_SERVICIO_ID,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FILIAL_SERVICIO_ID.getValor(map));
		Assert.assertEquals(SujetoOM.FLAG_AUT_POS,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FLAG_AUT_POS.getValor(map));
		Assert.assertEquals(SujetoOM.FLAG_AUT_RYA,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FLAG_AUT_RYA.getValor(map));
		Assert.assertEquals(SujetoOM.FLAG_MAN_POS,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FLAG_MAN_POS.getValor(map));
		Assert.assertEquals(SujetoOM.FLAG_MAN_RYA,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FLAG_MAN_RYA.getValor(map));
		Assert.assertEquals(SujetoOM.FLAG_PRESTADOR,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FLAG_PRESTADOR.getValor(map));
		Assert.assertEquals(SujetoOM.GESTOR, ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_GESTOR.getValor(map));
		Assert.assertEquals(SujetoOM.IC_PROMOTOR,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_IC_PROMOTOR.getValor(map));
		Assert.assertEquals(SujetoOM.MAIL, ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MAIL.getValor(map));
		Assert.assertEquals(SujetoOM.MARCA_GESTOR_ASIGNADO,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MARCA_GESTOR_ASIGNADO.getValor(map));
		Assert.assertEquals(SujetoOM.MARCA_GESTOR_PERMANENTE,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MARCA_GESTOR_PERMANENTE.getValor(map));
		Assert.assertEquals(SujetoOM.MESES_REC,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MESES_RECALCULADOS.getValor(map));
		Assert.assertEquals(SujetoOM.MESES_REC_CALCULADO,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MESES_REC_CALCULADOS.getValor(map));
		Assert.assertEquals(SujetoOM.MOTIVO_BAJA,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MOTIVO_BAJA.getValor(map));
		Assert.assertEquals(SujetoOM.NRO_CONTRATO,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_NRO_CONTRATO.getValor(map));
		Assert.assertEquals(SujetoOM.NRO_ORDEN,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_NRO_ORDEN.getValor(map));
		Assert.assertNotNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_PLAN.getValor(map));
		Assert.assertEquals(SujetoOM.PLAN_SAP, ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_PLAN_SAP.getValor(map));
		Assert.assertEquals(SujetoOM.CODIGO_OBRA_SOCIAL,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_RESP_PAGO_COD_OBRA_SOCIAL.getValor(map));
		Assert.assertEquals(SujetoOM.DESCRIPCION_OBRA_SOCIAL,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_RESP_PAGO_DESC_OBRA_SOCIAL.getValor(map));
		Assert.assertEquals(SujetoOM.MODO_CONTRATACION,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_RESP_PAGO_MODO_CONTRATACION.getValor(map));
		Assert.assertEquals(SujetoOM.NRO_CONTRATO,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_RESP_PAGO_NRO_CONTRATO.getValor(map));
		Assert.assertEquals(SujetoOM.NRO_INTERLOCUTOR,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_RESP_PAGO_NRO_INTERLOCUTOR.getValor(map));
		Assert.assertEquals(SujetoOM.ROTULO_IVA,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_ROTULO_IVA.getValor(map));
		Assert.assertEquals(SujetoOM.SECTOR, ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_SECTOR.getValor(map));
		Assert.assertEquals(SujetoOM.SECTOR_DSC,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_SECTOR_DSC.getValor(map));
		Assert.assertEquals(SujetoOM.COMPLEMENTACION,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_SOCIO_DIRECTO_OBRA_SOCIAL_COMPLEMENTACION
						.getValor(map));
		Assert.assertEquals(SujetoOM.TIPO_SOCIO,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_TIPO_SOCIO.getValor(map));
		Assert.assertEquals(SujetoOM.VENCIMIENTO_CREDENCIAL,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_VENCIMIENTO_CREDENCIAL.getValor(map));
		Assert.assertEquals(SujetoOM.VERSION_CREDENCIAL,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_VERSION_CREDENCIAL.getValor(map));

		Assert.assertEquals(SujetoOM.CONDADO,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_CONDADO.getValor(map));
		Assert.assertEquals(SujetoOM.CONDADO_ID,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_CONDADO_ID.getValor(map));
		Assert.assertEquals(SujetoOM.ES_AGENTE_PERCEPCION,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_ES_AGENTE_PERCEPCION.getValor(map));
		Assert.assertEquals(SujetoOM.EXISTE_PADRON,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_EXISTE_PADRON_ARBA.getValor(map));
		Assert.assertEquals(SujetoOM.EXISTEN_EXTENSIONES,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_EXISTEN_EXTENSIONES.getValor(map));
		Assert.assertEquals(SujetoOM.NOMBRE.toUpperCase(),
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_NOMBRE.getValor(map));
		Assert.assertNotNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_NOMBRE_COMPLETO.getValor(map));
		Assert.assertEquals(SujetoOM.NRO_INTERLOCUTOR,
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_NRO_INTERLOCUTOR.getValor(map));
		Assert.assertEquals(SujetoOM.SEXO, ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_SEXO.getValor(map));

		Assert.assertEquals(SujetoOM.APELLIDO.toUpperCase(),
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_APELLIDO.getValor(map));
	}

	/**
	 * Gets the valor methods without sujeto contacto.
	 *
	 * @return the valor methods without sujeto contacto
	 * @throws BusinessException
	 *             the business exception
	 */
	@Test
	public void getValor_methods_withoutSujetoContacto() throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>();

		Actividad actividad = new Actividad();
		map.put(EventMapConstants.EVENT_ACTIVIDAD, actividad);

		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_AYN_PROMOTOR.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_DEUDA.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_ALTA.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_BAJA.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_FLAG_RYA.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_MAN_POS.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_VIGENCIA_PLAN.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FILIAL_GESTION.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FILIAL_GESTION_ID.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FILIAL_SERVICIO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FILIAL_SERVICIO_ID.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_AUT_POS.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_AUT_RYA.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_MAN_POS.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_MAN_RYA.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_PRESTADOR.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_GESTOR.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_IC_PROMOTOR.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MAIL.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MARCA_GESTOR_ASIGNADO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MARCA_GESTOR_PERMANENTE.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MESES_RECALCULADOS.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MESES_REC_CALCULADOS.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MOTIVO_BAJA.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_NRO_CONTRATO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_NRO_ORDEN.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_PLAN.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_PLAN_SAP.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_COD_OBRA_SOCIAL.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_DESC_OBRA_SOCIAL.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_MODO_CONTRATACION.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_NRO_CONTRATO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_NRO_INTERLOCUTOR.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_ROTULO_IVA.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_SECTOR.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_SECTOR_DSC.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_SOCIO_DIRECTO_OBRA_SOCIAL_COMPLEMENTACION
				.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_TIPO_SOCIO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_VENCIMIENTO_CREDENCIAL.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_VERSION_CREDENCIAL.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_APELLIDO.getValor(map));

		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_CONDADO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_CONDADO_ID.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_ES_AGENTE_PERCEPCION.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_EXISTE_PADRON_ARBA.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_EXISTEN_EXTENSIONES.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_AMBITO_VISIBILIDAD.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_APELLIDO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DISC_PERMANENTE.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DISCAPACIDAD.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_BARRIO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_CALLE.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_CODIGO_POSTAL.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_DEPTO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_ACTUAL.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_LOCALIDAD.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_NUMERO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_PAIS.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_PISO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_PROVINCIA_CODIGO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_PROVINCIA_DESC.getValor(map));
		Assert.assertNull(
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_TIPO_DOMICILIO_CODIGO.getValor(map));
		Assert.assertNull(
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_TIPO_DOMICILIO_DSC.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_EDAD.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_FECHA_NACIMIENTO.getValor(map));
		Assert.assertNull(
				ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_MARCA_DISCAPACIDAD_FACTURACION.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_MARCA_DISCAPACITADO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_NOMBRE.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_NRO_INTERLOCUTOR.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_SEXO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_NOMBRE.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_NOMBRE_COMPLETO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_NRO_INTERLOCUTOR.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_SEXO.getValor(map));
	}

	/**
	 * Gets the valor methods without sujeto actividad.
	 *
	 * @return the valor methods without sujeto actividad
	 * @throws BusinessException
	 *             the business exception
	 */
	@Test
	public void getValor_methods_withoutSujetoActividad() throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>();

		Actividad actividad = new Actividad();
		map.put(EventMapConstants.EVENT_ACTIVIDAD, actividad);

		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_CONDADO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_CONDADO_ID.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_ES_AGENTE_PERCEPCION.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_EXISTE_PADRON_ARBA.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_EXISTEN_EXTENSIONES.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_AMBITO_VISIBILIDAD.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_APELLIDO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DISC_PERMANENTE.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DISCAPACIDAD.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_BARRIO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_CALLE.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_CODIGO_POSTAL.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_DEPTO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_ACTUAL.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_LOCALIDAD.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_NUMERO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_PAIS.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_PISO.getValor(map));
		Assert.assertNull(
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_PROVINCIA_CODIGO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_PROVINCIA_DESC.getValor(map));
		Assert.assertNull(
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_TIPO_DOMICILIO_CODIGO.getValor(map));
		Assert.assertNull(
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_TIPO_DOMICILIO_DSC.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_EDAD.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_FECHA_NACIMIENTO.getValor(map));
		Assert.assertNull(
				ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_MARCA_DISCAPACIDAD_FACTURACION.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_MARCA_DISCAPACITADO.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_NOMBRE.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_NRO_INTERLOCUTOR.getValor(map));
		Assert.assertNull(ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_SEXO.getValor(map));
	}

	/**
	 * Gets the valor methods user.
	 *
	 * @return the valor methods user
	 * @throws BusinessException
	 *             the business exception
	 */
	@Test
	public void getValor_methods_user() throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>();

		IntranetUser userIntra = new IntranetUser();

		Filial filial = new Filial();
		filial.setCapDescription(CAP_DESCRIPTION);
		filial.setCapID(CAP_ID);
		filial.setDescription(FILIAL_DESCRIPTION);
		filial.setId(FILIAL_ID);

		PersonalData personalData = new PersonalData();
		personalData.setCapDescription(PD_CAP_DESCRIPTION);
		personalData.setFilialDescription(FILIAL_DESCRIPTION);
		personalData.setFilialId(FILIAL_ID);
		personalData.setFirstName(FIRST_NAME);
		personalData.setLastName(LAST_NAME);
		personalData.setUserName(USERNAME);

		userIntra.setPersonalData(personalData);
		userIntra.setFilial(filial);
		userIntra.setName(USER_NAME);

		map.put(EventMapConstants.EVENT_USER, userIntra);

		Assert.assertEquals(CAP_DESCRIPTION, ParametroDTO.INTRANET_USER_FILIAL_CAP_DESCRIPCION.getValor(map));
		Assert.assertEquals(CAP_ID, ParametroDTO.INTRANET_USER_FILIAL_CAP_ID.getValor(map));
		Assert.assertEquals(FILIAL_DESCRIPTION, ParametroDTO.INTRANET_USER_FILIAL_DESCRIPCION.getValor(map));
		Assert.assertEquals(FILIAL_ID, ParametroDTO.INTRANET_USER_FILIAL_ID.getValor(map));
		Assert.assertEquals(USER_NAME, ParametroDTO.INTRANET_USER_NAME.getValor(map));
		Assert.assertEquals(PD_CAP_DESCRIPTION, ParametroDTO.INTRANET_USER_PERSONAL_DATA_CAP_DESCRIPCION.getValor(map));
		Assert.assertEquals(FILIAL_DESCRIPTION,
				ParametroDTO.INTRANET_USER_PERSONAL_DATA_FILIAL_DESCRIPCION.getValor(map));
		Assert.assertEquals(FILIAL_ID, ParametroDTO.INTRANET_USER_PERSONAL_DATA_FILIAL_ID.getValor(map));
		Assert.assertEquals(FIRST_NAME, ParametroDTO.INTRANET_USER_PERSONAL_DATA_FIRST_NAME.getValor(map));
		Assert.assertEquals(LAST_NAME, ParametroDTO.INTRANET_USER_PERSONAL_DATA_LAST_NAME.getValor(map));
		Assert.assertEquals(LAST_NAME.concat(" ").concat(FIRST_NAME),
				ParametroDTO.NOMBRE_USUARIO_RESPONSABLE.getValor(map));
		Assert.assertEquals(USERNAME, ParametroDTO.INTRANET_USER_PERSONAL_DATA_USERNAME.getValor(map));
		Assert.assertEquals(USER_NAME, ParametroDTO.INTRANET_USER_NAME.getValor(map));
	}

	/**
	 * Gets the valor with null I ds methods.
	 *
	 * @return the valor with null I ds methods
	 * @throws BusinessException
	 *             the business exception
	 */
	@Test
	public void getValor_withNullIDs_methods() throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>();

		Actividad actividad = new Actividad();
		map.put(EventMapConstants.EVENT_ACTIVIDAD, actividad);

		Assert.assertNull(ParametroDTO.ID_ESTADO.getValor(map));
		Assert.assertNull(ParametroDTO.ID_CLASIFICACION.getValor(map));
		Assert.assertNull(ParametroDTO.ID_MOTIVO_CONTACTO.getValor(map));
	}

	/**
	 * Resolver datos fiscales sujeto empresa.
	 *
	 * @throws BusinessException
	 *             the business exception
	 */
	@Test
	public void resolverDatosFiscales_sujetoEmpresa() throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>();
		Actividad actividad = new Actividad();
		actividad.setSujetoContacto(SujetoOM.getSujetoEmpresa());
		map.put(EventMapConstants.EVENT_ACTIVIDAD, actividad);

		String valor = ParametroDTO.ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_CONDADO.getValor(map);
		Assert.assertNotNull(valor);
		Assert.assertEquals(SujetoOM.CONDADO.toString(), valor);
	}

	/**
	 * Resolver contrato socio osde.
	 *
	 * @throws BusinessException
	 *             the business exception
	 */
	@Test
	public void resolverContrato_socioOsde() throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>();
		Actividad actividad = new Actividad();
		actividad.setSujetoActividad(SujetoOM.getSocioOsdeBinario());
		actividad.setSujetoContacto(SujetoOM.getSocioOsdeBinario());
		map.put(EventMapConstants.EVENT_ACTIVIDAD, actividad);

		String valor = ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_NRO_CONTRATO.getValor(map);
		Assert.assertNotNull(valor);
		Assert.assertEquals(SujetoOM.NRO_CONTRATO.toString(), valor);

		valor = ParametroDTO.ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_DEUDA.getValor(map);
		Assert.assertNotNull(valor);
		Assert.assertEquals(SujetoOM.DEUDA.toString(), valor);
	}

	/**
	 * Gets the valor tipo sujeto.
	 *
	 * @return the valor tipo sujeto
	 * @throws BusinessException
	 *             the business exception
	 */
	@Test
	public void getValor_tipoSujeto() throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>();
		Actividad actividad = new Actividad();

		TipoSujeto tipoSujeto = SujetoOM.getTipoSujeto();
		actividad.setTipoSujetoActividad(tipoSujeto);
		actividad.setTipoSujetoContacto(tipoSujeto);
		map.put(EventMapConstants.EVENT_ACTIVIDAD, actividad);

		Assert.assertEquals(SujetoOM.DESCRIPCION,
				ParametroDTO.ACTIVIDAD_TIPO_SUJETO_ACTIVIDAD_DESCRIPCION.getValor(map));
		Assert.assertEquals(UN_ID.toString(), ParametroDTO.ACTIVIDAD_TIPO_SUJETO_ACTIVIDAD_ID.getValor(map));
		Assert.assertEquals(SujetoOM.DESCRIPCION,
				ParametroDTO.ACTIVIDAD_TIPO_SUJETO_CONTACTO_DESCRIPCION.getValor(map));
		Assert.assertEquals(UN_ID.toString(), ParametroDTO.ACTIVIDAD_TIPO_SUJETO_CONTACTO_ID.getValor(map));
	}

	/**
	 * Gets the valor actividad servicio.
	 *
	 * @return the valor actividad servicio
	 * @throws BusinessException
	 *             the business exception
	 */
	@Test
	public void getValor_actividadServicio() throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>();
		Actividad actividad = new Actividad();

		Servicio servicio = new Servicio();
		Set<TipoSujeto> tipos = new LinkedHashSet<TipoSujeto>();
		tipos.add(SujetoOM.getTipoSujeto());
		servicio.setTiposSujeto(tipos);
		servicio.setState(this.getUnEstado());
		servicio.setName(FIRST_NAME);
		servicio.setId(UN_ID);

		FormaContacto unaFormaContacto = this.getUnaFormaContacto();
		servicio.setFormaContacto(unaFormaContacto);
		actividad.setFormaContacto(unaFormaContacto);
		actividad.setServicio(servicio);
		map.put(EventMapConstants.EVENT_ACTIVIDAD, actividad);

		Assert.assertNotNull(ParametroDTO.ACTIVIDAD_SERVICIO_TIPO_SUJETO.getValor(map));
		Assert.assertEquals(WORKFLOW_ESTADO, ParametroDTO.ACTIVIDAD_SERVICIO_ESTADO_WORKFLOW_ESTADO_ID.getValor(map));
		Assert.assertEquals(ESTADO_ID.toString(), ParametroDTO.ACTIVIDAD_SERVICIO_ESTADO_ID.getValor(map));
		Assert.assertEquals(ESTADO_DESC, ParametroDTO.ACTIVIDAD_SERVICIO_ESTADO_DESCRIPCION.getValor(map));
		Assert.assertEquals(FIRST_NAME, ParametroDTO.ACTIVIDAD_SERVICIO_NOMBRE.getValor(map));
		Assert.assertEquals(UNA_DESCRIPCION, ParametroDTO.ACTIVIDAD_SERVICIO_FORMA_CONTACTO_DESCRIPCION.getValor(map));
		Assert.assertEquals(UN_ID.toString(), ParametroDTO.ACTIVIDAD_SERVICIO_ID.getValor(map));
		Assert.assertEquals(UNA_DESCRIPCION.toString(),
				ParametroDTO.ACTIVIDAD_FORMA_CONTACTO_DESCRIPCION.getValor(map));
		Assert.assertEquals(UN_ID.toString(), ParametroDTO.ACTIVIDAD_FORMA_CONTACTO_ID.getValor(map));
	}

	/**
	 * Gets the valor event forma contacto.
	 *
	 * @return the valor event forma contacto
	 * @throws BusinessException
	 *             the business exception
	 */
	@Test
	public void getValor_eventFormaContacto() throws BusinessException {
		Map<String, Object> map = new HashMap<String, Object>();
		Assert.assertNull(ParametroDTO.ID_FORMA_CONTACTO.getValor(map));
		map.put(EventMapConstants.EVENT_FORMA_CONTACTO_DEFAULT, this.getUnaFormaContacto());
		Assert.assertEquals(UN_ID.toString(), ParametroDTO.ID_FORMA_CONTACTO.getValor(map));
	}

	/**
	 * Gets the una forma contacto.
	 *
	 * @return the una forma contacto
	 */
	private FormaContacto getUnaFormaContacto() {
		FormaContacto formaContacto = new FormaContacto();
		formaContacto.setId(UN_ID);
		formaContacto.setDescription(UNA_DESCRIPCION);

		return formaContacto;
	}
}
