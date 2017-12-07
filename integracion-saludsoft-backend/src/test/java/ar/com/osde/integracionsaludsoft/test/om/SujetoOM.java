package ar.com.osde.integracionsaludsoft.test.om;

import ar.com.osde.ccg.integration.beans.Sujeto;
import ar.com.osde.ccg.integration.beans.TipoSujeto;
import ar.com.osde.ccg.integration.beans.sujetos.CaractCertDiscapacidad;
import ar.com.osde.ccg.integration.beans.sujetos.Contrato;
import ar.com.osde.ccg.integration.beans.sujetos.DatosFiscales;
import ar.com.osde.ccg.integration.beans.sujetos.Domicilio;
import ar.com.osde.ccg.integration.beans.sujetos.Interlocutor;
import ar.com.osde.ccg.integration.beans.sujetos.NoSocioOsdeBinario;
import ar.com.osde.ccg.integration.beans.sujetos.NoSocioOsdeBinarioID;
import ar.com.osde.ccg.integration.beans.sujetos.PrestadorOsdeBinario;
import ar.com.osde.ccg.integration.beans.sujetos.ResponsablePago;
import ar.com.osde.ccg.integration.beans.sujetos.SocioOsdeBinario;
import ar.com.osde.ccg.integration.beans.sujetos.SujetoID;
import ar.com.osde.ccg.integration.beans.sujetos.empresa.SujetoEmpresa;

/**
 * The Class SujetoOM.
 */
public class SujetoOM {

	/** The Constant NRO_CONTRATO. */
	public static final String NRO_CONTRATO = "nro_contrato";

	/** The Constant UNIDAD_FACTURACION. */
	public static final String UNIDAD_FACTURACION = "unidad_facturacion";

	/** The Constant DEUDA. */
	public static final String DEUDA = "doubt";

	/** The Constant AYN_PROMOTOR. */
	public static final String AYN_PROMOTOR = "aynPromotor";

	/** The Constant FECHA_ALTA. */
	public static final String FECHA_ALTA = "unaFechaAlta";

	/** The Constant FECHA_BAJA. */
	public static final String FECHA_BAJA = "unaFechaBaja";

	/** The Constant FECHA_FLAG. */
	public static final String FECHA_FLAG = "unaFechaFlagRyA";

	/** The Constant FECHA_MAN. */
	public static final String FECHA_MAN = "unaFechaManPos";

	/** The Constant FECHA_VIGENCIA_PLAN. */
	public static final String FECHA_VIGENCIA_PLAN = "fechaVigenciaPlan";

	/** The Constant FILIAL_GESTION. */
	public static final String FILIAL_GESTION = "afilialGestion";

	/** The Constant FILIAL_GESTION_ID. */
	public static final String FILIAL_GESTION_ID = "afilialGestionId";

	/** The Constant FILIAL_SERVICIO. */
	public static final String FILIAL_SERVICIO = "unaFilialServicio";

	/** The Constant FILIAL_SERVICIO_ID. */
	public static final String FILIAL_SERVICIO_ID = "unFilialServicioId";

	/** The Constant FLAG_AUT_POS. */
	public static final String FLAG_AUT_POS = "unFlagAutPos";

	/** The Constant FLAG_AUT_RYA. */
	public static final String FLAG_AUT_RYA = "unFlagAutRyA";

	/** The Constant FLAG_MAN_RYA. */
	public static final String FLAG_MAN_RYA = "unFlagManRyA";

	/** The Constant FLAG_MAN_POS. */
	public static final String FLAG_MAN_POS = "unFlagManPos";

	/** The Constant FLAG_PRESTADOR. */
	public static final String FLAG_PRESTADOR = "unFlagPrestador";

	/** The Constant GESTOR. */
	public static final String GESTOR = "unGestor";

	/** The Constant IC_PROMOTOR. */
	public static final String IC_PROMOTOR = "anIcPromotor";

	/** The Constant MAIL. */
	public static final String MAIL = "unMail";

	/** The Constant MARCA_GESTOR_ASIGNADO. */
	public static final String MARCA_GESTOR_ASIGNADO = "marcaGestorAsignado";

	/** The Constant MARCA_GESTOR_PERMANENTE. */
	public static final String MARCA_GESTOR_PERMANENTE = "marcaGestorPermanente";

	/** The Constant MESES_REC. */
	public static final String MESES_REC = "unMesesRec";

	/** The Constant MESES_REC_CALCULADO. */
	public static final String MESES_REC_CALCULADO = "mesesRecCalculado";

	/** The Constant MOTIVO_BAJA. */
	public static final String MOTIVO_BAJA = "unMotivoBaja";

	/** The Constant NRO_ORDEN. */
	public static final String NRO_ORDEN = "unNroOrden";

	/** The Constant PLAN. */
	public static final String PLAN = "unPlan";

	/** The Constant PLAN_SAP. */
	public static final String PLAN_SAP = "unPlanSAP";

	/** The Constant CODIGO_OBRA_SOCIAL. */
	public static final String CODIGO_OBRA_SOCIAL = "codigoObraSocial";

	/** The Constant DESCRIPCION_OBRA_SOCIAL. */
	public static final String DESCRIPCION_OBRA_SOCIAL = "descripcionObraSocial";

	/** The Constant MODO_CONTRATACION. */
	public static final String MODO_CONTRATACION = "unModoContratacion";

	/** The Constant NRO_INTERLOCUTOR. */
	public static final String NRO_INTERLOCUTOR = "unNroInterlocutor";

	/** The Constant RESPONSABLE_PAGO. */
	public static final String RESPONSABLE_PAGO = "responsablePago";

	/** The Constant ROTULO_IVA. */
	public static final String ROTULO_IVA = "aRotuloIVA";

	/** The Constant SECTOR. */
	public static final String SECTOR = "sector";

	/** The Constant SECTOR_DSC. */
	public static final String SECTOR_DSC = "sectorDsc";

	/** The Constant COMPLEMENTACION. */
	public static final String COMPLEMENTACION = "socioDirectoObraSocialComplementacion";

	/** The Constant TIPO_SOCIO. */
	public static final String TIPO_SOCIO = "unTipoSocio";

	/** The Constant VENCIMIENTO_CREDENCIAL. */
	public static final String VENCIMIENTO_CREDENCIAL = "aVencimientoCredencial";

	/** The Constant VERSION_CREDENCIAL. */
	public static final String VERSION_CREDENCIAL = "aVersionCredencial";

	/** The Constant CONDADO. */
	public static final String CONDADO = "condado";

	/** The Constant CONDADO_ID. */
	public static final String CONDADO_ID = "condadoID";

	/** The Constant ES_AGENTE_PERCEPCION. */
	public static final String ES_AGENTE_PERCEPCION = "percepcion";

	/** The Constant EXISTE_PADRON. */
	public static final String EXISTE_PADRON = "padron";

	/** The Constant EXISTEN_EXTENSIONES. */
	public static final String EXISTEN_EXTENSIONES = "extensiones";

	/** The Constant VISIBILIDAD. */
	public static final String VISIBILIDAD = "visibilidad";

	/** The Constant APELLIDO. */
	public static final String APELLIDO = "apellido";

	/** The Constant DISC_PERMANENTE. */
	public static final String DISC_PERMANENTE = "discPermanente";

	/** The Constant DISCAPACIDAD. */
	public static final String DISCAPACIDAD = "discapacidad";

	/** The Constant BARRIO. */
	public static final String BARRIO = "barrio";

	/** The Constant CALLE. */
	public static final String CALLE = "calle";

	/** The Constant CODIGO_POSTAL. */
	public static final String CODIGO_POSTAL = "codigoPostal";

	/** The Constant DEPTO. */
	public static final String DEPTO = "depto";

	/** The Constant ACTUAL. */
	public static final String ACTUAL = "actual";

	/** The Constant LOCALIDAD. */
	public static final String LOCALIDAD = "localidad";

	/** The Constant NUMERO. */
	public static final String NUMERO = "numero";

	/** The Constant PAIS. */
	public static final String PAIS = "pais";

	/** The Constant PISO. */
	public static final String PISO = "piso";

	/** The Constant PROVINCIA_CODIGO. */
	public static final String PROVINCIA_CODIGO = "provinciaCodigo";

	/** The Constant PROVINCIA_DESCRIPCION. */
	public static final String PROVINCIA_DESCRIPCION = "provinciaDesc";

	/** The Constant TIPO_DOMICILIO_CODIGO. */
	public static final String TIPO_DOMICILIO_CODIGO = "tipoDomCodigo";

	/** The Constant TIPO_DOMICILIO_DESC. */
	public static final String TIPO_DOMICILIO_DESC = "tipoDomDesc";

	/** The Constant EDAD. */
	public static final String EDAD = "15";

	/** The Constant FECHA_NACIMIENTO. */
	public static final String FECHA_NACIMIENTO = "fechaNac";

	/** The Constant MARCA_DISC_FACT. */
	public static final String MARCA_DISC_FACT = "no";

	/** The Constant MARCA_DISC. */
	public static final String MARCA_DISC = "no";

	/** The Constant NOMBRE. */
	public static final String NOMBRE = "nombre";

	/** The Constant SEXO. */
	public static final String SEXO = "sexo";

	/** The Constant DESCRIPCION. */
	public static final String DESCRIPCION = "description";

	/** The Constant UN_ID. */
	public static final Long UN_ID = Long.valueOf(3L);

	/**
	 * Gets the socio osde binario.
	 *
	 * @return the socio osde binario
	 */
	public static SocioOsdeBinario getSocioOsdeBinario() {
		Contrato contrato = new Contrato();
		contrato.setNroContrato(NRO_CONTRATO);
		contrato.setDeuda(DEUDA);
		contrato.setAynPromotor(AYN_PROMOTOR);
		contrato.setFechaAlta(FECHA_ALTA);
		contrato.setFechaBaja(FECHA_BAJA);
		contrato.setFechaFlagRyA(FECHA_FLAG);
		contrato.setFechaManPos(FECHA_MAN);
		contrato.setFechaVigenciaPlan(FECHA_VIGENCIA_PLAN);
		contrato.setFilialGestion(FILIAL_GESTION);
		contrato.setFilialGestionId(FILIAL_GESTION_ID);
		contrato.setFilialServicio(FILIAL_SERVICIO);
		contrato.setFilialServicioId(FILIAL_SERVICIO_ID);
		contrato.setFlagAutPos(FLAG_AUT_POS);
		contrato.setFlagAutRyA(FLAG_AUT_RYA);
		contrato.setFlagManRyA(FLAG_MAN_RYA);
		contrato.setFlagManPos(FLAG_MAN_POS);
		contrato.setFlagPrestador(FLAG_PRESTADOR);
		contrato.setGestor(GESTOR);
		contrato.setIcPromotor(IC_PROMOTOR);
		contrato.setMail(MAIL);
		contrato.setMarcaGestorAsignado(MARCA_GESTOR_ASIGNADO);
		contrato.setMarcaGestorPermanente(MARCA_GESTOR_PERMANENTE);
		contrato.setMesesRec(MESES_REC);
		contrato.setMesesRecCalculado(MESES_REC_CALCULADO);
		contrato.setMotivoBaja(MOTIVO_BAJA);
		contrato.setNroOrden(NRO_ORDEN);
		contrato.setPlan(PLAN);
		contrato.setPlanSAP(PLAN_SAP);

		ResponsablePago responsablePago = new ResponsablePago();
		responsablePago.setCodigoObraSocial(CODIGO_OBRA_SOCIAL);
		responsablePago.setDescripcionObraSocial(DESCRIPCION_OBRA_SOCIAL);
		responsablePago.setModoContratacion(MODO_CONTRATACION);
		responsablePago.setNroContrato(NRO_CONTRATO);
		responsablePago.setNroInterlocutor(NRO_INTERLOCUTOR);

		contrato.setResponsablePago(responsablePago);
		contrato.setRotuloIVA(ROTULO_IVA);
		contrato.setSector(SECTOR);
		contrato.setSectorDsc(SECTOR_DSC);
		contrato.setSocioDirectoObraSocialComplementacion(COMPLEMENTACION);
		contrato.setTipoSocio(TIPO_SOCIO);
		contrato.setVencimientoCredencial(VENCIMIENTO_CREDENCIAL);
		contrato.setVersionCredencial(VERSION_CREDENCIAL);

		SocioOsdeBinario socioOsdeBinario = new SocioOsdeBinario();
		socioOsdeBinario.setNombre(NOMBRE);
		socioOsdeBinario.setNombreCompleto(NOMBRE);
		socioOsdeBinario.setNroInterlocutor(NRO_INTERLOCUTOR);
		socioOsdeBinario.setSexo(SEXO);
		socioOsdeBinario.setDatosFiscales(getDatosFiscales());
		socioOsdeBinario.setContrato(contrato);
		socioOsdeBinario.setApellido(APELLIDO);
		socioOsdeBinario.setInterlocutor(getInterlocutor());

		return socioOsdeBinario;
	}

	/**
	 * Gets the datos fiscales.
	 *
	 * @return the datos fiscales
	 */
	private static DatosFiscales getDatosFiscales() {
		DatosFiscales datos = new DatosFiscales();
		datos.setCondado(CONDADO);
		datos.setCondadoId(CONDADO_ID);
		datos.setEsAgenteDePercepcion(ES_AGENTE_PERCEPCION);
		datos.setExistePadronARBA(EXISTE_PADRON);
		datos.setExistenExenciones(EXISTEN_EXTENSIONES);
		return datos;
	}

	/**
	 * Gets the no socio osde binario.
	 *
	 * @return the no socio osde binario
	 */
	public static NoSocioOsdeBinario getNoSocioOsdeBinario() {
		NoSocioOsdeBinario noSocioOsdeBinario = new NoSocioOsdeBinario();
		SujetoID id = new NoSocioOsdeBinarioID();
		noSocioOsdeBinario.setID(id);
		noSocioOsdeBinario.setInterlocutor(getInterlocutor());

		return noSocioOsdeBinario;
	}

	/**
	 * Gets the interlocutor.
	 *
	 * @return the interlocutor
	 */
	private static Interlocutor getInterlocutor() {
		Interlocutor interlocutor = new Interlocutor();
		interlocutor.setAmbitoVisibilidad(VISIBILIDAD);
		interlocutor.setApellido(APELLIDO);
		interlocutor.setDiscPermanente(DISC_PERMANENTE);
		interlocutor.setEdad(EDAD);
		interlocutor.setFechaNacimiento(FECHA_NACIMIENTO);
		interlocutor.setMarcaDiscapacidadFacturacion(MARCA_DISC_FACT);
		interlocutor.setMarcaDiscapacitado(MARCA_DISC);
		interlocutor.setNombre(NOMBRE);
		interlocutor.setSexo(SEXO);
		interlocutor.setNroInterlocutor(NRO_INTERLOCUTOR);

		CaractCertDiscapacidad discapacidad = new CaractCertDiscapacidad();
		discapacidad.setDiscPermanente(DISCAPACIDAD);

		Domicilio domicilio = new Domicilio();
		domicilio.setBarrio(BARRIO);
		domicilio.setCalle(CALLE);
		domicilio.setCodigoPostal(CODIGO_POSTAL);
		domicilio.setDepto(DEPTO);
		domicilio.setDomicilioActual(ACTUAL);
		domicilio.setLocalidad(LOCALIDAD);
		domicilio.setNumero(NUMERO);
		domicilio.setPais(PAIS);
		domicilio.setPiso(PISO);
		domicilio.setProvinciaCodigo(PROVINCIA_CODIGO);
		domicilio.setProvinciaDesc(PROVINCIA_DESCRIPCION);

		domicilio.setTipoDomicilioCodigo(TIPO_DOMICILIO_CODIGO);
		domicilio.setTipoDomicilioDsc(TIPO_DOMICILIO_DESC);

		interlocutor.setDiscapacidad(discapacidad);
		interlocutor.setDomicilio(domicilio);
		return interlocutor;
	}

	/**
	 * Gets the sujeto empresa.
	 *
	 * @return the sujeto empresa
	 */
	public static SujetoEmpresa getSujetoEmpresa() {
		SujetoEmpresa sujetoEmpresa = new SujetoEmpresa();
		sujetoEmpresa.setUnidadFacturacion(UNIDAD_FACTURACION);
		sujetoEmpresa.setDatosFiscales(getDatosFiscales());

		return sujetoEmpresa;
	}

	/**
	 * Gets the prestador.
	 *
	 * @return the prestador
	 */
	public static Sujeto getPrestador() {
		return new PrestadorOsdeBinario();
	}

	/**
	 * Gets the tipo sujeto.
	 *
	 * @return the tipo sujeto
	 */
	public static TipoSujeto getTipoSujeto() {
		TipoSujeto tipoSujeto = new TipoSujeto();
		tipoSujeto.setDescription(DESCRIPCION);
		tipoSujeto.setId(UN_ID);

		return tipoSujeto;
	}

}
