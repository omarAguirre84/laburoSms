package ar.com.osde.integracionsaludsoft.dto;

import java.util.Map;

import ar.com.osde.ccg.integration.EventMapConstants;
import ar.com.osde.ccg.integration.beans.Actividad;
import ar.com.osde.ccg.integration.beans.FormaContacto;
import ar.com.osde.ccg.integration.beans.Sujeto;
import ar.com.osde.ccg.integration.beans.sujetos.Contrato;
import ar.com.osde.ccg.integration.beans.sujetos.DatosFiscales;
import ar.com.osde.ccg.integration.beans.sujetos.Interlocutor;
import ar.com.osde.ccg.integration.beans.sujetos.NoSocioOsdeBinario;
import ar.com.osde.ccg.integration.beans.sujetos.SocioOsdeBinario;
import ar.com.osde.ccg.integration.beans.sujetos.empresa.SujetoEmpresa;
import ar.com.osde.framework.security.intranet.IntranetUser;
import ar.com.osde.integracionsaludsoft.visitor.ParametroVisitor;

/**
 * The Enum Parametro.
 */
public enum ParametroDTO implements ParametroVisitor {

	/** The actividad empresa descripcion. */
	ACTIVIDAD_EMPRESA_DESCRIPCION("Descripci\u00F3n de la empresa", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getEmpresa().getDescription();
		}
	},

	/** The actividad empresa id. */
	ACTIVIDAD_EMPRESA_ID("ID de la empresa", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getEmpresa().getId().toString();
		}
	},

	/** The actividad forma contacto descripcion. */
	ACTIVIDAD_FORMA_CONTACTO_DESCRIPCION("Descripci\u00F3n de la forma contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getFormaContacto().getDescription();
		}
	},

	/** The actividad forma contacto id. */
	ACTIVIDAD_FORMA_CONTACTO_ID("ID de la forma contacto", true) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getFormaContacto().getId().toString();
		}
	},

	/** The actividad servicio forma contacto descripcion. */
	ACTIVIDAD_SERVICIO_FORMA_CONTACTO_DESCRIPCION("Descripci\u00F3n de la forma contacto del Servicio", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getServicio().getFormaContacto().getDescription();
		}
	},

	/** The actividad servicio id. */
	ACTIVIDAD_SERVICIO_ID("ID del Servicio", true) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getServicio().getId().toString();
		}
	},

	/** The actividad servicio nombre. */
	ACTIVIDAD_SERVICIO_NOMBRE("Nombre del Servicio", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getServicio().getName();
		}
	},

	/** The actividad servicio estado descripcion. */
	ACTIVIDAD_SERVICIO_ESTADO_DESCRIPCION("Descripci\u00F3n del estado del Servicio", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getServicio().getState().getDescription();
		}
	},

	/** The actividad servicio estado id. */
	ACTIVIDAD_SERVICIO_ESTADO_ID("ID del estado del Servicio", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getServicio().getState().getId().toString();
		}
	},

	/** The actividad servicio estado workflow estado id. */
	ACTIVIDAD_SERVICIO_ESTADO_WORKFLOW_ESTADO_ID("ID del estado del workflow del estado del Servicio", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getServicio().getState().getWorkflowStateId();
		}
	},

	/** The actividad servicio tipo sujeto. */
	ACTIVIDAD_SERVICIO_TIPO_SUJETO("Tipo Sujeto del Servicio", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getServicio().getTiposSujeto().toString();
		}
	},

	/** The actividad sujeto actividad apellido. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_APELLIDO("Apellido del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getSujetoActividad().getApellido();
		}
	},

	/** The actividad sujeto actividad contrato ayn promotor. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_AYN_PROMOTOR("AyN Promotor del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getAynPromotor();
		}
	},

	/** The actividad sujeto actividad contrato deuda. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_DEUDA("Deuda del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getDeuda();
		}
	},

	/** The actividad sujeto actividad contrato fecha alta. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FECHA_ALTA("Fecha del Alta del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getFechaAlta();
		}
	},

	/** The actividad sujeto actividad contrato fecha baja. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FECHA_BAJA("Fecha de la Baja del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getFechaBaja();
		}
	},

	/** The actividad sujeto actividad contrato fecha flag rya. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FECHA_FLAG_RYA("Fecha FyA del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getFechaFlagRyA();
		}
	},

	/** The actividad sujeto actividad contrato fecha man pos. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FECHA_MAN_POS("Fecha Man Pos del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getFechaManPos();
		}
	},

	/** The actividad sujeto actividad contrato fecha vigencia plan. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FECHA_VIGENCIA_PLAN("Fecha Vigencia del Plan del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getFechaVigenciaPlan();
		}
	},

	/** The actividad sujeto actividad contrato filial gestion. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FILIAL_GESTION("Filial Gesti\u00F3n del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getFilialGestion();
		}
	},

	/** The actividad sujeto actividad contrato filial gestion id. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FILIAL_GESTION_ID("ID de la Filial Gesti\u00F3n del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getFilialGestionId();
		}
	},

	/** The actividad sujeto actividad contrato filial servicio. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FILIAL_SERVICIO("Filial del Servicio del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getFilialServicio();
		}
	},

	/** The actividad sujeto actividad contrato filial servicio id. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FILIAL_SERVICIO_ID("ID Filial del Servicio del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getFilialServicioId();
		}
	},

	/** The actividad sujeto actividad contrato flag aut pos. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FLAG_AUT_POS("Flag Aut Pos del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getFlagAutPos();
		}
	},

	/** The actividad sujeto actividad contrato flag aut rya. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FLAG_AUT_RYA("Flag Aut RyA del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getFlagAutRyA();
		}
	},

	/** The actividad sujeto actividad contrato flag man pos. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FLAG_MAN_POS("Flag Man Pos del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getFlagManPos();
		}
	},

	/** The actividad sujeto actividad contrato flag man rya. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FLAG_MAN_RYA("Flag Man RyA del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getFlagManRyA();
		}
	},

	/** The actividad sujeto actividad contrato flag prestador. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FLAG_PRESTADOR("Flag Prestador del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getFlagPrestador();
		}
	},

	/** The actividad sujeto actividad contrato gestor. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_GESTOR("Gestor del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getGestor();
		}
	},

	/** The actividad sujeto actividad contrato ic promotor. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_IC_PROMOTOR("IC del Promotor del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getIcPromotor();
		}
	},

	/** The actividad sujeto actividad contrato mail. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MAIL("Mail del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getMail();
		}
	},

	/** The actividad sujeto actividad contrato marca gestor asignado. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MARCA_GESTOR_ASIGNADO("Marca del Gestor Asignado del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getMarcaGestorAsignado();
		}
	},

	/** The actividad sujeto actividad contrato marca gestor permanente. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MARCA_GESTOR_PERMANENTE("Marca del Gestor Permanente del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getMarcaGestorPermanente();
		}
	},

	/** The actividad sujeto actividad contrato meses recalculados. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MESES_RECALCULADOS("Meses Recalculados del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getMesesRec();
		}
	},

	/** The actividad sujeto actividad contrato meses rec calculados. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MESES_REC_CALCULADOS("Meses Rec Calculados del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getMesesRecCalculado();
		}
	},

	/** The actividad sujeto actividad contrato motivo baja. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MOTIVO_BAJA("Motivo de la Baja del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getMotivoBaja();
		}
	},

	/** The actividad sujeto actividad contrato nro contrato. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_NRO_CONTRATO("N\u00FAmero del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getNroContrato();
		}
	},

	/** The actividad sujeto actividad contrato nro orden. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_NRO_ORDEN("N\u00FAmero de orden del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getNroOrden();
		}
	},

	/** The actividad sujeto actividad contrato plan. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_PLAN("Plan del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getPlan();
		}
	},

	/** The actividad sujeto actividad contrato plan sap. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_PLAN_SAP("Plan SAP del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getPlanSAP();
		}
	},

	/** The actividad sujeto actividad contrato resp pago cod obra social. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_RESP_PAGO_COD_OBRA_SOCIAL("C\u00F3digo de la Obra Social del Responsable de Pago del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getResponsablePago()
					.getCodigoObraSocial();
		}
	},

	/** The actividad sujeto actividad contrato resp pago desc obra social. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_RESP_PAGO_DESC_OBRA_SOCIAL("Descripci\u00F3n de la Obra Social del Responsable de Pago del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getResponsablePago()
					.getDescripcionObraSocial();
		}
	},

	/** The actividad sujeto actividad contrato resp pago modo contratacion. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_RESP_PAGO_MODO_CONTRATACION("Modo Contrataci\u00F3n del Responsable de Pago del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getResponsablePago()
					.getModoContratacion();
		}
	},

	/** The actividad sujeto actividad contrato resp pago nro contrato. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_RESP_PAGO_NRO_CONTRATO("N\u00FAmero del Contrato del Responsable de Pago del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getResponsablePago().getNroContrato();
		}
	},

	/** The actividad sujeto actividad contrato resp pago nro interlocutor. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_RESP_PAGO_NRO_INTERLOCUTOR("N\u00FAmero Interlocutor del Contrato del Responsable de Pago del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getResponsablePago()
					.getNroInterlocutor();
		}
	},

	/** The actividad sujeto actividad contrato rotulo iva. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_ROTULO_IVA("R\u00F3tulo IVA del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getRotuloIVA();
		}
	},

	/** The actividad sujeto actividad contrato sector. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_SECTOR("Sector del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getSector();
		}
	},

	/** The actividad sujeto actividad contrato sector dsc. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_SECTOR_DSC("Sector DSC del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getSectorDsc();
		}
	},

	/**
	 * The actividad sujeto actividad contrato socio directo obra social
	 * complementacion.
	 */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_SOCIO_DIRECTO_OBRA_SOCIAL_COMPLEMENTACION("Complementaci\u00F3n de la Obra Social del Socio Directo del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa))
					.getSocioDirectoObraSocialComplementacion();
		}
	},

	/** The actividad sujeto actividad contrato tipo socio. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_TIPO_SOCIO("Tipo de Socio del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getTipoSocio();
		}
	},

	/** The actividad sujeto actividad contrato vencimiento credencial. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_VENCIMIENTO_CREDENCIAL("Vencimiento de la Credencial del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getVencimientoCredencial();
		}
	},

	/** The actividad sujeto actividad contrato version credencial. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_VERSION_CREDENCIAL("Versi\u00F3n de la Credencial del Contrato del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.resolverContratoSujetoActividad(this.getActividad(mapa)).getVersionCredencial();
		}
	},

	/** The actividad sujeto actividad datos fiscales condado. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_CONDADO("Condado de los Datos Fiscales del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			DatosFiscales datos = this.resolverDatosFiscalesSujetoActividad(this.getActividad(mapa));
			return datos == null ? null : datos.getCondado();
		}
	},

	/** The actividad sujeto actividad datos fiscales condado id. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_CONDADO_ID("ID del Condado de los Datos Fiscales del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			DatosFiscales datos = this.resolverDatosFiscalesSujetoActividad(this.getActividad(mapa));
			return datos == null ? null : datos.getCondadoId();
		}
	},

	/** The actividad sujeto actividad datos fiscales es agente percepcion. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_ES_AGENTE_PERCEPCION("Es Agente Percepci\u00F3n de los Datos Fiscales del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			DatosFiscales datos = this.resolverDatosFiscalesSujetoActividad(this.getActividad(mapa));
			return datos == null ? null : datos.getEsAgenteDePercepcion();
		}
	},

	/** The actividad sujeto actividad datos fiscales existe padron arba. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_EXISTE_PADRON_ARBA("Existe Padron ARBA de los Datos Fiscales del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			DatosFiscales datos = this.resolverDatosFiscalesSujetoActividad(this.getActividad(mapa));
			return datos == null ? null : datos.getExistePadronARBA();
		}
	},

	/** The actividad sujeto actividad datos fiscales existen extensiones. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_EXISTEN_EXTENSIONES("Existen Extensiones de los Datos Fiscales del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			DatosFiscales datos = this.resolverDatosFiscalesSujetoActividad(this.getActividad(mapa));
			return datos == null ? null : datos.getExistenExenciones();
		}
	},

	/** The actividad sujeto actividad interlocutor ambito visibilidad. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_AMBITO_VISIBILIDAD("Visibilidad del Ambito del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getAmbitoVisibilidad();
		}
	},

	/** The actividad sujeto actividad interlocutor apellido. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_APELLIDO("Apellido del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getApellido();
		}
	},

	/** The actividad sujeto actividad interlocutor disc permanente. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DISC_PERMANENTE("Discapacidad Permanente del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getDiscPermanente();
		}
	},

	/** The actividad sujeto actividad interlocutor discapacidad. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DISCAPACIDAD("Discapacidad del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getDiscapacidad().toString();
		}
	},

	/** The actividad sujeto actividad interlocutor domicilio barrio. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_BARRIO("Barrio del Domicilio del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getDomicilio().getBarrio();
		}
	},

	/** The actividad sujeto actividad interlocutor domicilio calle. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_CALLE("Calle del Domicilio del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getDomicilio().getCalle();
		}
	},

	/** The actividad sujeto actividad interlocutor domicilio codigo postal. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_CODIGO_POSTAL("C\u00F3digo Postal del Domicilio del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getDomicilio().getCodigoPostal();
		}
	},

	/** The actividad sujeto actividad interlocutor domicilio depto. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_DEPTO("Departamento del Domicilio del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getDomicilio().getDepto();
		}
	},

	/** The actividad sujeto actividad interlocutor domicilio actual. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_ACTUAL("Domicilio Actual del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getDomicilio().getDomicilioActual();
		}
	},

	/** The actividad sujeto actividad interlocutor domicilio localidad. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_LOCALIDAD("Localidad del Domicilio del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getDomicilio().getLocalidad();
		}
	},

	/** The actividad sujeto actividad interlocutor domicilio numero. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_NUMERO("N\u00FAmero del Domicilio del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getDomicilio().getNumero();
		}
	},

	/** The actividad sujeto actividad interlocutor domicilio pais. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_PAIS("Pa\u00EDs del Domicilio del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getDomicilio().getPais();
		}
	},

	/** The actividad sujeto actividad interlocutor domicilio piso. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_PISO("Piso del Domicilio del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getDomicilio().getPiso();
		}
	},

	/**
	 * The actividad sujeto actividad interlocutor domicilio provincia codigo.
	 */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_PROVINCIA_CODIGO("C\u00F3digo de la Provincia del Domicilio del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getDomicilio().getProvinciaCodigo();
		}
	},

	/** The actividad sujeto actividad interlocutor domicilio provincia desc. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_PROVINCIA_DESC("Descripci\u00F3n de la Provincia del Domicilio del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getDomicilio().getProvinciaDesc();
		}
	},

	/**
	 * The actividad sujeto actividad interlocutor domicilio tipo domicilio
	 * codigo.
	 */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_TIPO_DOMICILIO_CODIGO("C\u00F3digo del tipo de Domicilio del Domicilio del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getDomicilio().getTipoDomicilioCodigo();
		}
	},

	/**
	 * The actividad sujeto actividad interlocutor domicilio tipo domicilio dsc.
	 */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_TIPO_DOMICILIO_DSC("Descripci\u00F3n del tipo de Domicilio del Domicilio del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getDomicilio().getTipoDomicilioDsc();
		}
	},

	/** The actividad sujeto actividad interlocutor edad. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_EDAD("Edad del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getEdad();
		}
	},

	/** The actividad sujeto actividad interlocutor fecha nacimiento. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_FECHA_NACIMIENTO("Fecha de Nacimiento del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getFechaNacimiento();
		}
	},

	/**
	 * The actividad sujeto actividad interlocutor marca discapacidad
	 * facturacion.
	 */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_MARCA_DISCAPACIDAD_FACTURACION("Marca de Discapacidad de Facturaci\u00F3n del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getMarcaDiscapacidadFacturacion();
		}
	},

	/** The actividad sujeto actividad interlocutor marca discapacitado. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_MARCA_DISCAPACITADO("Marca de Discapacitado del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getMarcaDiscapacitado();
		}
	},

	/** The actividad sujeto actividad interlocutor nombre. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_NOMBRE("Nombre del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getNombre();
		}
	},

	/** The actividad sujeto actividad interlocutor nro interlocutor. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_NRO_INTERLOCUTOR("N\u00FAmero Interlocutor del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getNroInterlocutor();
		}
	},

	/** The actividad sujeto actividad interlocutor sexo. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_SEXO("Sexo del Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoActividad(this.getActividad(mapa));
			return interlocutor == null ? null : interlocutor.getSexo();
		}
	},

	/** The actividad sujeto actividad nombre. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_NOMBRE("Nombre del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getSujetoActividad().getNombre();
		}
	},

	/** The actividad sujeto actividad nombre completo. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_NOMBRE_COMPLETO("Nombre Completo del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getSujetoActividad().getNombreCompleto();
		}
	},

	/** The actividad sujeto actividad nro interlocutor. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_NRO_INTERLOCUTOR("Nro. Interlocutor del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getSujetoActividad().getNroInterlocutor();
		}
	},

	/** The actividad sujeto actividad sexo. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_SEXO("Sexo del Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getSujetoActividad().getSexo();
		}
	},

	/** The actividad sujeto contacto apellido. */
	ACTIVIDAD_SUJETO_CONTACTO_APELLIDO("Apellido del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Actividad actividad = this.getActividad(mapa);
			return actividad.getSujetoContacto() != null ? actividad.getSujetoContacto().getApellido() : null;
		}
	},

	/** The actividad sujeto contacto contrato ayn promotor. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_AYN_PROMOTOR("AyN Promotor del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getAynPromotor() : null;
		}
	},

	/** The actividad sujeto contacto contrato deuda. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_DEUDA("Deuda del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getDeuda() : null;
		}
	},

	/** The actividad sujeto contacto contrato fecha alta. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_ALTA("Fecha del Alta del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getFechaAlta() : null;
		}
	},

	/** The actividad sujeto contacto contrato fecha baja. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_BAJA("Fecha de la Baja del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getFechaBaja() : null;
		}
	},

	/** The actividad sujeto contacto contrato fecha flag rya. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_FLAG_RYA("Fecha FyA del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getFechaFlagRyA() : null;
		}
	},

	/** The actividad sujeto contacto contrato fecha man pos. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_MAN_POS("Fecha Man Pos del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getFechaManPos() : null;
		}
	},

	/** The actividad sujeto contacto contrato fecha vigencia plan. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_VIGENCIA_PLAN("Fecha Vigencia del Plan del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getFechaVigenciaPlan() : null;
		}
	},

	/** The actividad sujeto contacto contrato filial gestion. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FILIAL_GESTION("Filial Gesti\u00F3n del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getFilialGestion() : null;
		}
	},

	/** The actividad sujeto contacto contrato filial gestion id. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FILIAL_GESTION_ID("ID de la Filial Gesti\u00F3n del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getFilialGestionId() : null;
		}
	},

	/** The actividad sujeto contacto contrato filial servicio. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FILIAL_SERVICIO("Filial del Servicio del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getFilialServicio() : null;
		}
	},

	/** The actividad sujeto contacto contrato filial servicio id. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FILIAL_SERVICIO_ID("ID Filial del Servicio del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getFilialServicioId() : null;
		}
	},

	/** The actividad sujeto contacto contrato flag aut pos. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_AUT_POS("Flag Aut Pos del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getFlagAutPos() : null;
		}
	},

	/** The actividad sujeto contacto contrato flag aut rya. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_AUT_RYA("Flag Aut RyA del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getFlagAutRyA() : null;
		}
	},

	/** The actividad sujeto contacto contrato flag man pos. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_MAN_POS("Flag Man Pos del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getFlagManPos() : null;
		}
	},

	/** The actividad sujeto contacto contrato flag man rya. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_MAN_RYA("Flag Man RyA del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getFlagManRyA() : null;
		}
	},

	/** The actividad sujeto contacto contrato flag prestador. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_PRESTADOR("Flag Prestador del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getFlagPrestador() : null;
		}
	},

	/** The actividad sujeto contacto contrato gestor. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_GESTOR("Gestor del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getGestor() : null;
		}
	},

	/** The actividad sujeto contacto contrato ic promotor. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_IC_PROMOTOR("IC del Promotor del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getIcPromotor() : null;
		}
	},

	/** The actividad sujeto contacto contrato mail. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MAIL("Mail del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getMail() : null;
		}
	},

	/** The actividad sujeto contacto contrato marca gestor asignado. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MARCA_GESTOR_ASIGNADO("Marca del Gestor Asignado del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getMarcaGestorAsignado() : null;
		}
	},

	/** The actividad sujeto contacto contrato marca gestor permanente. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MARCA_GESTOR_PERMANENTE("Marca del Gestor Permanente del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getMarcaGestorPermanente() : null;
		}
	},

	/** The actividad sujeto contacto contrato meses recalculados. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MESES_RECALCULADOS("Meses Recalculados del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getMesesRec() : null;
		}
	},

	/** The actividad sujeto contacto contrato meses rec calculados. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MESES_REC_CALCULADOS("Meses Rec Calculados del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getMesesRecCalculado() : null;
		}
	},

	/** The actividad sujeto contacto contrato motivo baja. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MOTIVO_BAJA("Motivo de la Baja del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getMotivoBaja() : null;
		}
	},

	/** The actividad sujeto contacto contrato nro contrato. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_NRO_CONTRATO("N\u00FAmero del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getNroContrato() : null;
		}
	},

	/** The actividad sujeto contacto contrato nro orden. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_NRO_ORDEN("N\u00FAmero de orden del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getNroOrden() : null;
		}
	},

	/** The actividad sujeto contacto contrato plan. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_PLAN("Plan del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getPlan() : null;
		}
	},

	/** The actividad sujeto contacto contrato plan sap. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_PLAN_SAP("Plan SAP del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getPlanSAP() : null;
		}
	},

	/** The actividad sujeto contacto contrato resp pago cod obra social. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_COD_OBRA_SOCIAL("C\u00F3digo de la Obra Social del Responsable de Pago del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getResponsablePago().getCodigoObraSocial() : null;
		}
	},

	/** The actividad sujeto contacto contrato resp pago desc obra social. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_DESC_OBRA_SOCIAL("Descripci\u00F3n de la Obra Social del Responsable de Pago del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getResponsablePago().getDescripcionObraSocial() : null;
		}
	},

	/** The actividad sujeto contacto contrato resp pago modo contratacion. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_MODO_CONTRATACION("Modo Contrataci\u00F3n del Responsable de Pago del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getResponsablePago().getModoContratacion() : null;
		}
	},

	/** The actividad sujeto contacto contrato resp pago nro contrato. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_NRO_CONTRATO("N\u00FAmero del Contrato del Responsable de Pago del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getResponsablePago().getNroContrato() : null;
		}
	},

	/** The actividad sujeto contacto contrato resp pago nro interlocutor. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_NRO_INTERLOCUTOR("N\u00FAmero Interlocutor del Contrato del Responsable de Pago del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getResponsablePago().getNroInterlocutor() : null;
		}
	},

	/** The actividad sujeto contacto contrato rotulo iva. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_ROTULO_IVA("R\u00F3tulo IVA del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getRotuloIVA() : null;
		}
	},

	/** The actividad sujeto contacto contrato sector. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_SECTOR("Sector del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getSector() : null;
		}
	},

	/** The actividad sujeto contacto contrato sector dsc. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_SECTOR_DSC("Sector DSC del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getSectorDsc() : null;
		}
	},

	/**
	 * The actividad sujeto contacto contrato socio directo obra social
	 * complementacion.
	 */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_SOCIO_DIRECTO_OBRA_SOCIAL_COMPLEMENTACION("Complementaci\u00F3n de la Obra Social del Socio Directo del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getSocioDirectoObraSocialComplementacion() : null;
		}
	},

	/** The actividad sujeto contacto contrato tipo socio. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_TIPO_SOCIO("Tipo de Socio del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getTipoSocio() : null;
		}
	},

	/** The actividad sujeto contacto contrato vencimiento credencial. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_VENCIMIENTO_CREDENCIAL("Vencimiento de la Credencial del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getVencimientoCredencial() : null;
		}
	},

	/** The actividad sujeto contacto contrato version credencial. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_VERSION_CREDENCIAL("Versi\u00F3n de la Credencial del Contrato del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Contrato contrato = resolverContratoSujetoContacto(this.getActividad(mapa));
			return contrato != null ? contrato.getVersionCredencial() : null;
		}
	},

	/** The actividad sujeto contacto datos fiscales condado. */
	ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_CONDADO("Condado de los Datos Fiscales del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			DatosFiscales datos = this.resolverDatosFiscalesSujetoContacto(this.getActividad(mapa));
			return datos != null ? datos.getCondado() : null;
		}
	},

	/** The actividad sujeto contacto datos fiscales condado id. */
	ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_CONDADO_ID("ID del Condado de los Datos Fiscales del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			DatosFiscales datos = this.resolverDatosFiscalesSujetoContacto(this.getActividad(mapa));
			return datos != null ? datos.getCondadoId() : null;
		}
	},

	/** The actividad sujeto contacto datos fiscales es agente percepcion. */
	ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_ES_AGENTE_PERCEPCION("Es Agente Percepci\u00F3n de los Datos Fiscales del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			DatosFiscales datos = this.resolverDatosFiscalesSujetoContacto(this.getActividad(mapa));
			return datos != null ? datos.getEsAgenteDePercepcion() : null;
		}
	},

	/** The actividad sujeto contacto datos fiscales existe padron arba. */
	ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_EXISTE_PADRON_ARBA("Existe Padron ARBA de los Datos Fiscales del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			DatosFiscales datos = this.resolverDatosFiscalesSujetoContacto(this.getActividad(mapa));
			return datos != null ? datos.getExistePadronARBA() : null;
		}
	},

	/** The actividad sujeto contacto datos fiscales existen extensiones. */
	ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_EXISTEN_EXTENSIONES("Existen Extensiones de los Datos Fiscales del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			DatosFiscales datos = this.resolverDatosFiscalesSujetoContacto(this.getActividad(mapa));
			return datos != null ? datos.getExistenExenciones() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor ambito visibilidad. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_AMBITO_VISIBILIDAD("Visibilidad del \u00C1mbito del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getAmbitoVisibilidad() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor apellido. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_APELLIDO("Apellido del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getApellido() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor disc permanente. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DISC_PERMANENTE("Discapacidad Permanente del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getDiscPermanente() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor discapacidad. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DISCAPACIDAD("Discapacidad del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getDiscapacidad().toString() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor domicilio barrio. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_BARRIO("Barrio del Domicilio del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getDomicilio().getBarrio() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor domicilio calle. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_CALLE("Calle del Domicilio del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getDomicilio().getCalle() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor domicilio codigo postal. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_CODIGO_POSTAL("C\u00F3digo Postal del Domicilio del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getDomicilio().getCodigoPostal() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor domicilio depto. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_DEPTO("Departamento del Domicilio del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getDomicilio().getDepto() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor domicilio actual. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_ACTUAL("Domicilio Actual del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getDomicilio().getDomicilioActual() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor domicilio localidad. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_LOCALIDAD("Localidad del Domicilio del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getDomicilio().getLocalidad() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor domicilio numero. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_NUMERO("N\u00FAmero del Domicilio del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getDomicilio().getNumero() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor domicilio pais. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_PAIS("Pa\u00EDs del Domicilio del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getDomicilio().getPais() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor domicilio piso. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_PISO("Piso del Domicilio del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getDomicilio().getPiso() : null;
		}
	},

	/**
	 * The actividad sujeto contacto interlocutor domicilio provincia codigo.
	 */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_PROVINCIA_CODIGO("C\u00F3digo de la Provincia del Domicilio del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getDomicilio().getProvinciaCodigo() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor domicilio provincia desc. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_PROVINCIA_DESC("Descripci\u00F3n de la Provincia del Domicilio del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getDomicilio().getProvinciaDesc() : null;
		}
	},

	/**
	 * The actividad sujeto contacto interlocutor domicilio tipo domicilio
	 * codigo.
	 */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_TIPO_DOMICILIO_CODIGO("C\u00F3digo del tipo de Domicilio del Domicilio del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getDomicilio().getTipoDomicilioCodigo() : null;
		}
	},

	/**
	 * The actividad sujeto contacto interlocutor domicilio tipo domicilio dsc.
	 */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_TIPO_DOMICILIO_DSC("Descripci\u00F3n del tipo de Domicilio del Domicilio del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getDomicilio().getTipoDomicilioDsc() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor edad. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_EDAD("Edad del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getEdad() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor fecha nacimiento. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_FECHA_NACIMIENTO("Fecha de Nacimiento del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getFechaNacimiento() : null;
		}
	},

	/**
	 * The actividad sujeto contacto interlocutor marca discapacidad
	 * facturacion.
	 */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_MARCA_DISCAPACIDAD_FACTURACION("Marca de Discapacidad de Facturaci\u00F3n del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getMarcaDiscapacidadFacturacion() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor marca discapacitado. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_MARCA_DISCAPACITADO("Marca de Discapacitado del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getMarcaDiscapacitado() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor nombre. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_NOMBRE("Nombre del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getNombre() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor nro interlocutor. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_NRO_INTERLOCUTOR("N\u00FAmero Interlocutor del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getNroInterlocutor() : null;
		}
	},

	/** The actividad sujeto contacto interlocutor sexo. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_SEXO("Sexo del Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Interlocutor interlocutor = this.resolverInterlocutorSujetoContacto(this.getActividad(mapa));
			return interlocutor != null ? interlocutor.getSexo() : null;
		}
	},

	/** The actividad sujeto contacto nombre. */
	ACTIVIDAD_SUJETO_CONTACTO_NOMBRE("Nombre del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Actividad actividad = this.getActividad(mapa);
			return actividad.getSujetoContacto() != null ? actividad.getSujetoContacto().getNombre() : null;
		}
	},

	/** The actividad sujeto contacto nombre completo. */
	ACTIVIDAD_SUJETO_CONTACTO_NOMBRE_COMPLETO("Nombre Completo del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Actividad actividad = this.getActividad(mapa);
			return actividad.getSujetoContacto() != null ? actividad.getSujetoContacto().getNombreCompleto() : null;
		}
	},

	/** The actividad sujeto contacto nro interlocutor. */
	ACTIVIDAD_SUJETO_CONTACTO_NRO_INTERLOCUTOR("N\u00FAmero. Interlocutor del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Actividad actividad = this.getActividad(mapa);
			return actividad.getSujetoContacto() != null ? actividad.getSujetoContacto().getNroInterlocutor() : null;
		}
	},

	/** The actividad sujeto contacto sexo. */
	ACTIVIDAD_SUJETO_CONTACTO_SEXO("Sexo del Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			Actividad actividad = this.getActividad(mapa);
			return actividad.getSujetoContacto() != null ? actividad.getSujetoContacto().getSexo() : null;
		}
	},

	/** The actividad tipo sujeto actividad descripcion. */
	ACTIVIDAD_TIPO_SUJETO_ACTIVIDAD_DESCRIPCION("Descripci\u00F3n del Tipo Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getTipoSujetoActividad().getDescription();
		}
	},

	/** The actividad tipo sujeto actividad id. */
	ACTIVIDAD_TIPO_SUJETO_ACTIVIDAD_ID("ID del Tipo Sujeto Actividad", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getTipoSujetoActividad().getId().toString();
		}
	},

	/** The actividad tipo sujeto contacto descripcion. */
	ACTIVIDAD_TIPO_SUJETO_CONTACTO_DESCRIPCION("Descripci\u00F3n del Tipo Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getTipoSujetoContacto().getDescription();
		}
	},

	/** The actividad tipo sujeto contacto id. */
	ACTIVIDAD_TIPO_SUJETO_CONTACTO_ID("ID del Tipo Sujeto Contacto", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getTipoSujetoContacto().getId().toString();
		}
	},

	/** The persona contacto. */
	PERSONA_CONTACTO("Persona contacto", true) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getPersonaContacto();
		}
	},

	/** The numero contacto. */
	NUMERO_CONTACTO("N\u00FAmero del contacto", true) {
		public String getValor(Map<String, Object> mapa) {
			String numeroContacto = (String) mapa.get(EventMapConstants.EVENT_NUMERO_CONTACTO_RECEPCION);
			return numeroContacto;
		}
	},

	/** The observacion. */
	OBSERVACION("Descripci\u00F3n de la observaci\u00F3n", true) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getObservaciones();
		}
	},

	/** The id actividad relacionada. */
	ID_ACTIVIDAD_RELACIONADA("ID de la Actividad Relacionada", true) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getIdRelacionada();
		}
	},

	/** The id actividad externa. */
	ID_ACTIVIDAD_EXTERNA("ID de la Actividad Externa", true) {
		public String getValor(Map<String, Object> mapa) {
			return this.getActividad(mapa).getExtActivityId();
		}
	},

	/** The intranet user filial cap descripcion. */
	INTRANET_USER_FILIAL_CAP_DESCRIPCION("Descripci\u00F3n de la Filial Cap del Usuario de Intranet", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getUserIntra(mapa).getFilial().getCapDescription();
		}
	},

	/** The intranet user filial cap id. */
	INTRANET_USER_FILIAL_CAP_ID("ID de la Filial Cap del Usuario de Intranet", true) {
		public String getValor(Map<String, Object> mapa) {
			return this.getUserIntra(mapa).getFilial().getCapID();
		}
	},

	/** The intranet user filial descripcion. */
	INTRANET_USER_FILIAL_DESCRIPCION("Descripci\u00F3n de la Filial del Usuario de Intranet", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getUserIntra(mapa).getFilial().getDescription();
		}
	},

	/** The intranet user filial id. */
	INTRANET_USER_FILIAL_ID("Id de la Filial del Usuario de Intranet", true) {
		public String getValor(Map<String, Object> mapa) {
			return this.getUserIntra(mapa).getFilial().getId();
		}
	},

	/** The intranet user name. */
	INTRANET_USER_NAME("Nombre Usuario de Intranet", true) {
		public String getValor(Map<String, Object> mapa) {
			return this.getUserIntra(mapa).getName();
		}
	},

	/** The intranet user personal data cap descripcion. */
	INTRANET_USER_PERSONAL_DATA_CAP_DESCRIPCION("Descripci\u00F3n del Cap de los Datos Personales Usuario de Intranet", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getUserIntra(mapa).getPersonalData().getCapDescription();
		}
	},

	/** The intranet user personal data filial descripcion. */
	INTRANET_USER_PERSONAL_DATA_FILIAL_DESCRIPCION("Descripci\u00F3n de la Filial de los Datos Personales Usuario de Intranet", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getUserIntra(mapa).getPersonalData().getFilialDescription();
		}
	},

	/** The intranet user personal data filial id. */
	INTRANET_USER_PERSONAL_DATA_FILIAL_ID("ID de la Filial de los Datos Personales Usuario de Intranet", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getUserIntra(mapa).getPersonalData().getFilialId();
		}
	},

	/** The intranet user personal data first name. */
	INTRANET_USER_PERSONAL_DATA_FIRST_NAME("Nombre de los Datos Personales Usuario de Intranet", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getUserIntra(mapa).getPersonalData().getFirstName();
		}
	},

	/** The intranet user personal data last name. */
	INTRANET_USER_PERSONAL_DATA_LAST_NAME("Apellido de los Datos Personales Usuario de Intranet", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getUserIntra(mapa).getPersonalData().getLastName();
		}
	},

	/** The nombre usuario responsable. */
	NOMBRE_USUARIO_RESPONSABLE("Nombre del usuario responsable", true) {
		public String getValor(Map<String, Object> mapa) {
			IntranetUser userIntra = this.getUserIntra(mapa);
			return userIntra.getPersonalData().getLastName().concat(" ")
					.concat(userIntra.getPersonalData().getFirstName());
		}
	},

	/** The intranet user personal data username. */
	INTRANET_USER_PERSONAL_DATA_USERNAME("MT de los Datos Personales Usuario de Intranet", false) {
		public String getValor(Map<String, Object> mapa) {
			return this.getUserIntra(mapa).getPersonalData().getUserName();
		}
	},

	/** The id motivo contacto. */
	ID_MOTIVO_CONTACTO("ID del Motivo Contacto", true) {
		public String getValor(Map<String, Object> mapa) {
			Actividad actividad = this.getActividad(mapa);
			return actividad.getMotivo() != null ? actividad.getMotivo().getId().toString() : null;
		}
	},

	/** The id clasificacion. */
	ID_CLASIFICACION("ID de la clasificaci\u00F3n", true) {
		public String getValor(Map<String, Object> mapa) {
			Actividad actividad = this.getActividad(mapa);
			return actividad.getClasificacion() != null ? actividad.getClasificacion().getId().toString() : null;
		}
	},

	/** The id estado. */
	ID_ESTADO("ID del Estado", true) {
		public String getValor(Map<String, Object> mapa) {
			Actividad actividad = this.getActividad(mapa);
			return actividad.getEstado() != null ? actividad.getEstado().getId().toString() : null;
		}
	},

	/** The id forma contacto. */
	ID_FORMA_CONTACTO("ID de la forma Contacto", true) {
		public String getValor(Map<String, Object> mapa) {
			FormaContacto formaContacto = (FormaContacto) mapa.get(EventMapConstants.EVENT_FORMA_CONTACTO_DEFAULT);
			return formaContacto != null ? formaContacto.getId().toString() : null;
		}
	};

	/** The descripcion. */
	private String descripcion;

	/** The registra actividad. */
	private Boolean registraActividad;

	/**
	 * Instantiates a new parametro DTO.
	 *
	 * @param descripcion
	 *            the descripcion
	 * @param registraActividad
	 *            the registra actividad
	 */
	private ParametroDTO(String descripcion, Boolean registraActividad) {
		this.descripcion = descripcion;
		this.registraActividad = registraActividad;
	}

	/**
	 * Resolver contrato.
	 *
	 * @param sujeto
	 *            the sujeto
	 * @return the contrato
	 */
	/*
	 * Resolver contrato
	 *
	 * @param sujeto the sujeto
	 * 
	 * @return the contrato
	 */
	protected Contrato resolverContrato(Sujeto sujeto) {
		if (sujeto instanceof SocioOsdeBinario) {
			return ((SocioOsdeBinario) sujeto).getContrato();
		}

		return null;
	}

	/**
	 * Resolver interlocutor.
	 *
	 * @param sujeto
	 *            the sujeto
	 * @return the interlocutor
	 */
	protected Interlocutor resolverInterlocutor(Sujeto sujeto) {
		if (sujeto instanceof SocioOsdeBinario) {
			return ((SocioOsdeBinario) sujeto).getInterlocutor();
		}

		if (sujeto instanceof NoSocioOsdeBinario) {
			return ((NoSocioOsdeBinario) sujeto).getInterlocutor();
		}

		return null;
	}

	/**
	 * Resolver datos fiscales.
	 *
	 * @param sujeto
	 *            the sujeto
	 * @return the datos fiscales
	 */
	protected DatosFiscales resolverDatosFiscales(Sujeto sujeto) {
		if (sujeto instanceof SocioOsdeBinario) {
			return ((SocioOsdeBinario) sujeto).getDatosFiscales();
		}

		if (sujeto instanceof SujetoEmpresa) {
			return ((SujetoEmpresa) sujeto).getDatosFiscales();
		}

		return null;
	}

	/**
	 * Resolver datos fiscales sujeto actividad.
	 *
	 * @param actividad
	 *            the actividad
	 * @return the datos fiscales
	 */
	protected DatosFiscales resolverDatosFiscalesSujetoActividad(Actividad actividad) {
		return this.resolverDatosFiscales(actividad.getSujetoActividad());
	}

	/**
	 * Resolver datos fiscales sujeto contacto.
	 *
	 * @param actividad
	 *            the actividad
	 * @return the datos fiscales
	 */
	protected DatosFiscales resolverDatosFiscalesSujetoContacto(Actividad actividad) {
		return this.resolverDatosFiscales(actividad.getSujetoContacto());
	}

	/**
	 * Resolver contrato sujeto contacto.
	 *
	 * @param actividad
	 *            the actividad
	 * @return the contrato
	 */
	protected Contrato resolverContratoSujetoContacto(Actividad actividad) {
		return this.resolverContrato(actividad.getSujetoContacto());
	}

	/**
	 * Resolver contrato sujeto actividad.
	 *
	 * @param actividad
	 *            the actividad
	 * @return the contrato
	 */
	protected Contrato resolverContratoSujetoActividad(Actividad actividad) {
		return this.resolverContrato(actividad.getSujetoActividad());
	}

	/**
	 * Resolver interlocutor sujeto actividad.
	 *
	 * @param actividad
	 *            the actividad
	 * @return the interlocutor
	 */
	protected Interlocutor resolverInterlocutorSujetoActividad(Actividad actividad) {
		return this.resolverInterlocutor(actividad.getSujetoActividad());
	}

	/**
	 * Resolver interlocutor sujeto contacto.
	 *
	 * @param actividad
	 *            the actividad
	 * @return the interlocutor
	 */
	protected Interlocutor resolverInterlocutorSujetoContacto(Actividad actividad) {
		return this.resolverInterlocutor(actividad.getSujetoContacto());
	}

	/**
	 * Gets the user intra.
	 *
	 * @param map
	 *            the map
	 * @return the user intra
	 */
	protected IntranetUser getUserIntra(Map<String, Object> map) {
		return (IntranetUser) map.get(EventMapConstants.EVENT_USER);

	}

	/**
	 * Gets the actividad.
	 *
	 * @param map
	 *            the map
	 * @return the actividad
	 */
	protected Actividad getActividad(Map<String, Object> map) {
		return (Actividad) map.get(EventMapConstants.EVENT_ACTIVIDAD);
	}

	/**
	 * Gets the valor.
	 *
	 * @param mapa
	 *            the mapa
	 * @return the valor @ the business exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.osde.integracionsaludsoft.visitor.ParametroVisitor#getValor(java.
	 * util.Map)
	 */
	public String getValor(Map<String, Object> mapa) {
		return null;
	}

	/**
	 * Gets the descripcion.
	 *
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Gets the registra actividad.
	 *
	 * @return the registra actividad
	 */
	public Boolean getRegistraActividad() {
		return registraActividad;
	}

	/**
	 * Sets the registra actividad.
	 *
	 * @param registraActividad
	 *            the new registra actividad
	 */
	public void setRegistraActividad(Boolean registraActividad) {
		this.registraActividad = registraActividad;
	}

	/**
	 * Sets the descripcion.
	 *
	 * @param descripcion
	 *            the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
