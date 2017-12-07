package ar.com.osde.integracionsaludsoft.entities;

/**
 * The Class ParametroDTO.
 */
public enum Parametro {

	/** The actividad empresa descripcion. */
	ACTIVIDAD_EMPRESA_DESCRIPCION("empresa", "Descripcion de la empresa", false),

	/** The actividad empresa id. */
	ACTIVIDAD_EMPRESA_ID("empresa_id", "ID de la empresa", false),

	/** The actividad forma contacto descripcion. */
	ACTIVIDAD_FORMA_CONTACTO_DESCRIPCION("forma_contacto", "Descripcion de la forma contacto", false),

	/** The actividad forma contacto id. */
	ACTIVIDAD_FORMA_CONTACTO_ID("forma_contacto_id", "ID de la forma contacto", true),

	/** The actividad servicio forma contacto descripcion. */
	ACTIVIDAD_SERVICIO_FORMA_CONTACTO_DESCRIPCION("servicio", "Descripcion de la forma contacto del Servicio", false),

	/** The actividad servicio id. */
	ACTIVIDAD_SERVICIO_ID("servicio_id", "ID de la forma contacto del Servicio", true),

	/** The actividad servicio nombre. */
	ACTIVIDAD_SERVICIO_NOMBRE("servicio_nombre", "Nombre del Servicio", false),

	/** The actividad servicio estado descripcion. */
	ACTIVIDAD_SERVICIO_ESTADO_DESCRIPCION("servicio_estado", "Descripcion del estado del Servicio", false),

	/** The actividad servicio estado id. */
	ACTIVIDAD_SERVICIO_ESTADO_ID("servicio_estado_id", "ID del estado del Servicio", false),

	/** The actividad servicio estado workflow estado id. */
	ACTIVIDAD_SERVICIO_ESTADO_WORKFLOW_ESTADO_ID("servicio_estado_wfw_id",
			"ID del estado del workflow del estado del Servicio", false),

	/** The actividad servicio tipo sujeto. */
	ACTIVIDAD_SERVICIO_TIPO_SUJETO("servicio_tipo_sujeto", "Tipo Sujeto del Servicio", false),

	/** The actividad sujeto actividad apellido. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_APELLIDO("suj_act_apellido", "Apellido del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato ayn promotor. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_AYN_PROMOTOR("suj_act_contr_ayn",
			"AyN Promotor del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato deuda. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_DEUDA("suj_act_contr_deuda", "Deuda del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato fecha alta. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FECHA_ALTA("suj_act_contr_alta",
			"Fecha del Alta del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato fecha baja. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FECHA_BAJA("suj_act_contr_baja",
			"Fecha de la Baja del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato fecha flag rya. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FECHA_FLAG_RYA("suj_act_contr_rya",
			"Fecha FyA del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato fecha man pos. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FECHA_MAN_POS("suj_act_contr_man_pos",
			"Fecha Man Pos del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato fecha vigencia plan. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FECHA_VIGENCIA_PLAN("suj_act_contr_pan_vig",
			"Fecha Vigencia del Plan del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato filial gestion. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FILIAL_GESTION("suj_act_contr_filialt",
			"Filial Gestion del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato filial gestion id. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FILIAL_GESTION_ID("suj_act_contr_filial_id",
			"Id de la Filial Gestion del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato filial servicio. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FILIAL_SERVICIO("suj_act_contr_filial_serv",
			"Filial del Servicio del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato filial servicio id. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FILIAL_SERVICIO_ID("suj_act_contr_filial_serv_id",
			"ID Filial del Servicio del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato flag aut pos. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FLAG_AUT_POS("suj_act_contr_flag_aut_pos",
			"Flag Aut Pos del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato flag aut rya. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FLAG_AUT_RYA("suj_act_contr_flag_rya",
			"Flag Aut RyA del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato flag man pos. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FLAG_MAN_POS("suj_act_contr_flag_man_pos",
			"Flag Man Pos del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato flag man rya. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FLAG_MAN_RYA("suj_act_contr_flag_man_rya",
			"Flag Man RyA del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato flag prestador. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_FLAG_PRESTADOR("suj_act_contr_flag_prest",
			"Flag Prestador del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato gestor. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_GESTOR("suj_act_contr_gest", "Gestor del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato ic promotor. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_IC_PROMOTOR("suj_act_contr_ic_promotor",
			"IC del Promotor del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato mail. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MAIL("suj_act_contr_mail", "Mail del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato marca gestor asignado. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MARCA_GESTOR_ASIGNADO("suj_act_contr_marca_ges_asig",
			"Marca del Gestor Asignado del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato marca gestor permanente. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MARCA_GESTOR_PERMANENTE("suj_act_contr_marca_ges_perm",
			"Marca del Gestor Permanente del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato meses recalculados. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MESES_RECALCULADOS("suj_act_contr_meses_recalc",
			"Meses Recalculados del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato meses rec calculados. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MESES_REC_CALCULADOS("suj_act_contr_meses_rec_calc",
			"Meses Rec Calculados del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato motivo baja. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_MOTIVO_BAJA("suj_act_contr_mot_baja",
			"Motivo de la Baja del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato nro contrato. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_NRO_CONTRATO("suj_act_contr_contrato",
			"Numero del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato nro orden. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_NRO_ORDEN("suj_act_contr_nro_orden",
			"Numero de orden del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato plan. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_PLAN("suj_act_contr_plan", "Plan del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato plan sap. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_PLAN_SAP("suj_act_contr_sap", "Plan SAP del Contrato del Sujeto Actividad",
			false),

	/** The actividad sujeto actividad contrato resp pago cod obra social. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_RESP_PAGO_COD_OBRA_SOCIAL("suj_act_contr_rsp_cod_obra_soc",
			"Codigo de la Obra Social del Responsable de Pago del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato resp pago desc obra social. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_RESP_PAGO_DESC_OBRA_SOCIAL("suj_act_contr_rsp_obra_soc",
			"Descripcion de la Obra Social del Responsable de Pago del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato resp pago modo contratacion. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_RESP_PAGO_MODO_CONTRATACION("suj_act_contr_rsp_mod_contratacion",
			"Modo Contratacion del Responsable de Pago del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato resp pago nro contrato. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_RESP_PAGO_NRO_CONTRATO("suj_act_contr_resp_pago_nro_contr",
			"Numero del Contrato del Responsable de Pago del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato resp pago nro interlocutor. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_RESP_PAGO_NRO_INTERLOCUTOR("suj_act_contr_resp_pago_ic",
			"Numero Interlocutor del Contrato del Responsable de Pago del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato rotulo iva. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_ROTULO_IVA("suj_act_contr_rot_iva",
			"Rotulo IVA del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato sector. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_SECTOR("suj_act_contr_sector", "Sector del Contrato del Sujeto Actividad",
			false),

	/** The actividad sujeto actividad contrato sector dsc. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_SECTOR_DSC("suj_act_contr_sec_dsc",
			"Sector DSC del Contrato del Sujeto Actividad", false),

	/**
	 * The actividad sujeto actividad contrato socio directo obra social
	 * complementacion.
	 */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_SOCIO_DIRECTO_OBRA_SOCIAL_COMPLEMENTACION(
			"suj_act_contr_socio_direc_obra_soc_comp",
			"Complementacion de la Obra Social del Socio Directo del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato tipo socio. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_TIPO_SOCIO("suj_act_contr_tipo_soc",
			"Tipo de Socio del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato vencimiento credencial. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_VENCIMIENTO_CREDENCIAL("suj_act_contr_ven_cred",
			"Vencimiento de la Credencial del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad contrato version credencial. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_CONTRATO_VERSION_CREDENCIAL("suj_act_contr_vers_cred",
			"Version de la Credencial del Contrato del Sujeto Actividad", false),

	/** The actividad sujeto actividad datos fiscales condado. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_CONDADO("suj_act_datos_fisc_cond",
			"Condado de los Datos Fiscales del Sujeto Actividad", false),

	/** The actividad sujeto actividad datos fiscales condado id. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_CONDADO_ID("suj_act_datos_fisc_id",
			"ID del Condado de los Datos Fiscales del Sujeto Actividad", false),

	/** The actividad sujeto actividad datos fiscales es agente percepcion. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_ES_AGENTE_PERCEPCION("suj_act_datos_fisc_es_ag_perc",
			"Es Agente Percepcion de los Datos Fiscales del Sujeto Actividad", false),

	/** The actividad sujeto actividad datos fiscales existe padron arba. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_EXISTE_PADRON_ARBA("suj_act_datos_fisc_exist_pad_arba",
			"Existe Padron ARBA de los Datos Fiscales del Sujeto Actividad", false),

	/** The actividad sujeto actividad datos fiscales existen extensiones. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_DATOS_FISCALES_EXISTEN_EXTENSIONES("suj_act_dat_fisc_exist_extensiones",
			"Existen Extensiones de los Datos Fiscales del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor ambito visibilidad. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_AMBITO_VISIBILIDAD("suj_act_ic_amb_visib",
			"Visibilidad del Ambito del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor apellido. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_APELLIDO("suj_act_ic_apellido",
			"Apellido del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor disc permanente. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DISC_PERMANENTE("suj_act_ic_disc_perm",
			"Discapacidad Permanente del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor discapacidad. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DISCAPACIDAD("suj_act_ic_disc",
			"Discapacidad del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor domicilio barrio. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_BARRIO("suj_act_ic_barrio",
			"Barrio del Domicilio del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor domicilio calle. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_CALLE("suh_act_ic_calle",
			"Calle del Domicilio del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor domicilio codigo postal. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_CODIGO_POSTAL("suj_act_ic_cod_post",
			"Codigo Postal del Domicilio del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor domicilio depto. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_DEPTO("suj_act_ic_depto",
			"Departamento del Domicilio del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor domicilio actual. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_ACTUAL("suj_act_ic_actual",
			"Domicilio Actual del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor domicilio localidad. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_LOCALIDAD("suj_act_ic_localidad",
			"Localidad del Domicilio del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor domicilio numero. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_NUMERO("suj_act_ic_numero_dom",
			"Numero del Domicilio del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor domicilio pais. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_PAIS("suj_act_ic_pais",
			"Pais del Domicilio del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor domicilio piso. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_PISO("suj_act_ic_piso",
			"Piso del Domicilio del Interlocutor del Sujeto Actividad", false),

	/**
	 * The actividad sujeto actividad interlocutor domicilio provincia codigo.
	 */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_PROVINCIA_CODIGO("suj_act_ic_cod_provincia",
			"Codigo de la Provincia del Domicilio del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor domicilio provincia desc. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_PROVINCIA_DESC("suj_act_ic_provincia",
			"Descripcion de la Provincia del Domicilio del Interlocutor del Sujeto Actividad", false),

	/**
	 * The actividad sujeto actividad interlocutor domicilio tipo domicilio
	 * codigo.
	 */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_TIPO_DOMICILIO_CODIGO("suj_act_ic_cod_tipo_dom",
			"Codigo del tipo de Domicilio del Domicilio del Interlocutor del Sujeto Actividad", false),

	/**
	 * The actividad sujeto actividad interlocutor domicilio tipo domicilio dsc.
	 */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_DOMICILIO_TIPO_DOMICILIO_DSC("suj_act_ic_tipo_dom",
			"Descripcion del tipo de Domicilio del Domicilio del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor edad. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_EDAD("suj_act_ic_edad", "Edad del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor fecha nacimiento. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_FECHA_NACIMIENTO("suj_act_ic_fec_nacimiento",
			"Fecha de Nacimiento del Interlocutor del Sujeto Actividad", false),

	/**
	 * The actividad sujeto actividad interlocutor marca discapacidad
	 * facturacion.
	 */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_MARCA_DISCAPACIDAD_FACTURACION("suj_act_ic_marca_disca_fact",
			"Marca de Discapacidad de Facturacion del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor marca discapacitado. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_MARCA_DISCAPACITADO("suj_act_ic_marca_discapacitado",
			"Marca de Discapacitado del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor nombre. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_NOMBRE("suj_act_ic_nombre", "Nombre del Interlocutor del Sujeto Actividad",
			false),

	/** The actividad sujeto actividad interlocutor nro interlocutor. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_NRO_INTERLOCUTOR("suj_act_ic_nro_ic",
			"Numero Interlocutor del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad interlocutor sexo. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_INTERLOCUTOR_SEXO("suj_act_ic_sexo", "Sexo del Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad nombre. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_NOMBRE("suj_act_nombre", "Nombre del Sujeto Actividad", false),

	/** The actividad sujeto actividad nombre completo. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_NOMBRE_COMPLETO("suj_act_nombre_completo", "Nombre Completo del Sujeto Actividad", false),

	/** The actividad sujeto actividad nro interlocutor. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_NRO_INTERLOCUTOR("suj_act_nro_ic", "Nro. Interlocutor del Sujeto Actividad", false),

	/** The actividad sujeto actividad sexo. */
	ACTIVIDAD_SUJETO_ACTIVIDAD_SEXO("suj_act_sexo", "Sexo del Sujeto Actividad", false),

	/** The actividad sujeto contacto apellido. */
	ACTIVIDAD_SUJETO_CONTACTO_APELLIDO("suj_cont_apellido", "Apellido del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato ayn promotor. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_AYN_PROMOTOR("suj_cont_contr_ayn_prom",
			"AyN Promotor del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato deuda. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_DEUDA("suj_cont_deuda_contr", "Deuda del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato fecha alta. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_ALTA("suj_cont_contr_alta",
			"Fecha del Alta del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato fecha baja. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_BAJA("suj_cont_contr_baja",
			"Fecha de la Baja del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato fecha flag rya. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_FLAG_RYA("suj_cont_contr_fecha_flag_rya",
			"Fecha FyA del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato fecha man pos. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_MAN_POS("suj_cont_contr_fec_man_pos",
			"Fecha Man Pos del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato fecha vigencia plan. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FECHA_VIGENCIA_PLAN("suj_cont_contr_fec_vig_plan",
			"Fecha Vigencia del Plan del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato filial gestion. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FILIAL_GESTION("suj_cont_contr_filial_gest",
			"Filial Gestion del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato filial gestion id. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FILIAL_GESTION_ID("suj_cont_contr_filial_gest_id",
			"Id de la Filial Gestion del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato filial servicio. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FILIAL_SERVICIO("suj_cont_contr_servicio_filial",
			"Filial del Servicio del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato filial servicio id. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FILIAL_SERVICIO_ID("suj_cont_contr_id_servicio_filial",
			"ID Filial del Servicio del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato flag aut pos. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_AUT_POS("suj_cont_contr_flag_aut_pos",
			"Flag Aut Pos del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato flag aut rya. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_AUT_RYA("suj_cont_contr_flag_aut_rya",
			"Flag Aut RyA del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato flag man pos. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_MAN_POS("suj_contacto_contr_flag_man_pos",
			"Flag Man Pos del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato flag man rya. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_MAN_RYA("suj_cont_contr_flag_man_rya",
			"Flag Man RyA del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato flag prestador. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_FLAG_PRESTADOR("suj_cont_contr_flag_prest",
			"Flag Prestador del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato gestor. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_GESTOR("suj_cont_contr_gest", "Gestor del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato ic promotor. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_IC_PROMOTOR("suj_cont_contr_ic_prom",
			"IC del Promotor del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato mail. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MAIL("suj_cont_contr_mail", "Mail del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato marca gestor asignado. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MARCA_GESTOR_ASIGNADO("suj_contr_marca_gest_asig",
			"Marca del Gestor Asignado del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato marca gestor permanente. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MARCA_GESTOR_PERMANENTE("suj_cont_contr_marca_gest_perm",
			"Marca del Gestor Permanente del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato meses recalculados. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MESES_RECALCULADOS("suj_cont_contr_meses_recalc",
			"Meses Recalculados del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato meses rec calculados. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MESES_REC_CALCULADOS("suj_cont_contr_meses_rec_recalc",
			"Meses Rec Calculados del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato motivo baja. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_MOTIVO_BAJA("suj_cont_contr_mot_baja",
			"Motivo de la Baja del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato nro contrato. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_NRO_CONTRATO("suj_cont_contrato_nro", "Numero del Contrato del Sujeto Contacto",
			false),

	/** The actividad sujeto contacto contrato nro orden. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_NRO_ORDEN("suj_cont_contr_nro_orden",
			"Numero de orden del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato plan. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_PLAN("suj_cont_contr_plan", "Plan del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato plan sap. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_PLAN_SAP("suj_cont_contr_plan_sap", "Plan SAP del Contrato del Sujeto Contacto",
			false),

	/** The actividad sujeto contacto contrato resp pago cod obra social. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_COD_OBRA_SOCIAL("suj_cont_contr_resp_pago_cod_obr_social",
			"Codigo de la Obra Social del Responsable de Pago del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato resp pago desc obra social. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_DESC_OBRA_SOCIAL("suj_cont_contr_resp_pago_obr_social",
			"Descripcion de la Obra Social del Responsable de Pago del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato resp pago modo contratacion. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_MODO_CONTRATACION("suj_cont_contr_resp_pago_mod_contr",
			"Modo Contratacion del Responsable de Pago del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato resp pago nro contrato. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_NRO_CONTRATO("suj_cont_contr_resp_pago_contrato",
			"Numero del Contrato del Responsable de Pago del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato resp pago nro interlocutor. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_RESP_PAGO_NRO_INTERLOCUTOR("suj_cont_contr_resp_pago_ic",
			"Numero Interlocutor del Contrato del Responsable de Pago del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato rotulo iva. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_ROTULO_IVA("suj_cont_contr_rotu_iva",
			"Rotulo IVA del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato sector. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_SECTOR("suj_cont_cont_sector", "Sector del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato sector dsc. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_SECTOR_DSC("suj_cont_contr_sector_dsc",
			"Sector DSC del Contrato del Sujeto Contacto", false),

	/**
	 * The actividad sujeto contacto contrato socio directo obra social
	 * complementacion.
	 */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_SOCIO_DIRECTO_OBRA_SOCIAL_COMPLEMENTACION(
			"suj_cont_contr_socio_dir_obr_soc_complem",
			"Complementacion de la Obra Social del Socio Directo del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato tipo socio. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_TIPO_SOCIO("suj_cont_contr_tipo_socio",
			"Tipo de Socio del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato vencimiento credencial. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_VENCIMIENTO_CREDENCIAL("suj_cont_contr_venc_cred",
			"Vencimiento de la Credencial del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto contrato version credencial. */
	ACTIVIDAD_SUJETO_CONTACTO_CONTRATO_VERSION_CREDENCIAL("suj_cont_contr_vers_cred",
			"Version de la Credencial del Contrato del Sujeto Contacto", false),

	/** The actividad sujeto contacto datos fiscales condado. */
	ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_CONDADO("suj_cont_dat_fisc_cond",
			"Condado de los Datos Fiscales del Sujeto Contacto", false),

	/** The actividad sujeto contacto datos fiscales condado id. */
	ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_CONDADO_ID("suj_cont_dat_fisc_cond_id",
			"ID del Condado de los Datos Fiscales del Sujeto Contacto", false),

	/** The actividad sujeto contacto datos fiscales es agente percepcion. */
	ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_ES_AGENTE_PERCEPCION("suj_cont_dat_fisc_agent_percep",
			"Es Agente Percepcion de los Datos Fiscales del Sujeto Contacto", false),

	/** The actividad sujeto contacto datos fiscales existe padron arba. */
	ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_EXISTE_PADRON_ARBA("suj_cont_dat_fisc_exist_pad_arba",
			"Existe Padron ARBA de los Datos Fiscales del Sujeto Contacto", false),

	/** The actividad sujeto contacto datos fiscales existen extensiones. */
	ACTIVIDAD_SUJETO_CONTACTO_DATOS_FISCALES_EXISTEN_EXTENSIONES("suj_cont_datos_fisc_exist_extens",
			"Existen Extensiones de los Datos Fiscales del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor ambito visibilidad. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_AMBITO_VISIBILIDAD("suj_cont_ic_amb_visib",
			"Visibilidad del Ambito del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor apellido. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_APELLIDO("suj_cont_ic_apellido",
			"Apellido del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor disc permanente. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DISC_PERMANENTE("suj_cont_ic_dic_perm",
			"Discapacidad Permanente del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor discapacidad. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DISCAPACIDAD("suj_cont_ic_disca",
			"Discapacidad del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor domicilio barrio. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_BARRIO("suj_cont_ic_barrio",
			"Barrio del Domicilio del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor domicilio calle. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_CALLE("suj_cont_ic_calle",
			"Calle del Domicilio del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor domicilio codigo postal. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_CODIGO_POSTAL("suj_cont_ic_cp",
			"Codigo Postal del Domicilio del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor domicilio depto. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_DEPTO("suj_cont_ic_dom_depto",
			"Departamento del Domicilio del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor domicilio actual. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_ACTUAL("suj_cont_ic_dom_act",
			"Domicilio Actual del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor domicilio localidad. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_LOCALIDAD("suj_cont_ic_localidad",
			"Localidad del Domicilio del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor domicilio numero. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_NUMERO("suj_cont_ic_dom_numero",
			"Numero del Domicilio del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor domicilio pais. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_PAIS("suj_cont_ic_pais",
			"Pais del Domicilio del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor domicilio piso. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_PISO("suj_cont_ic_piso",
			"Piso del Domicilio del Interlocutor del Sujeto Contacto", false),

	/**
	 * The actividad sujeto contacto interlocutor domicilio provincia codigo.
	 */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_PROVINCIA_CODIGO("suj_cont_ic_provinci_cod",
			"Codigo de la Provincia del Domicilio del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor domicilio provincia desc. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_PROVINCIA_DESC("suj_cont_ic_provincia",
			"Descripcion de la Provincia del Domicilio del Interlocutor del Sujeto Contacto", false),

	/**
	 * The actividad sujeto contacto interlocutor domicilio tipo domicilio
	 * codigo.
	 */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_TIPO_DOMICILIO_CODIGO("suj_cont_ic_tipo_dom_cod",
			"Codigo del tipo de Domicilio del Domicilio del Interlocutor del Sujeto Contacto", false),

	/**
	 * The actividad sujeto contacto interlocutor domicilio tipo domicilio dsc.
	 */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_DOMICILIO_TIPO_DOMICILIO_DSC("suj_cont_ic_tipo_dom",
			"Descripcion del tipo de Domicilio del Domicilio del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor edad. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_EDAD("suj_cont_ic_edad", "Edad del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor fecha nacimiento. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_FECHA_NACIMIENTO("suj_cont_ic_fecha_nac",
			"Fecha de Nacimiento del Interlocutor del Sujeto Contacto", false),

	/**
	 * The actividad sujeto contacto interlocutor marca discapacidad faturacion.
	 */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_MARCA_DISCAPACIDAD_FACTURACION("suj_cont_ic_marc_disca_fact",
			"Marca de Discapacidad de Facturacion del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor marca discapacitado. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_MARCA_DISCAPACITADO("suj_cont_ic_marc_discapaciado",
			"Marca de Discapacitado del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor nombre. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_NOMBRE("suj_cont_ic_nombre", "Nombre del Interlocutor del Sujeto Contacto",
			false),

	/** The actividad sujeto contacto interlocutor nro interlocutor. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_NRO_INTERLOCUTOR("suj_cont_ic_numero_ic",
			"Numero Interlocutor del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto interlocutor sexo. */
	ACTIVIDAD_SUJETO_CONTACTO_INTERLOCUTOR_SEXO("suj_cont_ic_sexo", "Sexo del Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto nombre. */
	ACTIVIDAD_SUJETO_CONTACTO_NOMBRE("suj_cont_nombre", "Nombre del Sujeto Contacto", false),

	/** The actividad sujeto contacto nombre completo. */
	ACTIVIDAD_SUJETO_CONTACTO_NOMBRE_COMPLETO("suj_cont_nombre_compl", "Nombre Completo del Sujeto Contacto", false),

	/** The actividad sujeto contacto nro interlocutor. */
	ACTIVIDAD_SUJETO_CONTACTO_NRO_INTERLOCUTOR("suj_cont_nro_ic", "Nro. Interlocutor del Sujeto Contacto", false),

	/** The actividad sujeto contacto sexo. */
	ACTIVIDAD_SUJETO_CONTACTO_SEXO("suj_cont_sexo", "Sexo del Sujeto Contacto", false),

	/** The actividad tipo sujeto actividad descripcion. */
	ACTIVIDAD_TIPO_SUJETO_ACTIVIDAD_DESCRIPCION("tipo_suj_act", "Descripcion del Tipo Sujeto Actividad", false),

	/** The actividad tipo sujeto actividad id. */
	ACTIVIDAD_TIPO_SUJETO_ACTIVIDAD_ID("tipo_suj_act_id", "Id del Tipo Sujeto Actividad", false),

	/** The actividad tipo sujeto contacto descripcion. */
	ACTIVIDAD_TIPO_SUJETO_CONTACTO_DESCRIPCION("tipo_suj_cont", "Descripcion del Tipo Sujeto Contacto", false),

	/** The actividad tipo sujeto contacto id. */
	ACTIVIDAD_TIPO_SUJETO_CONTACTO_ID("tipo_suj_cont_id", "Id del Tipo Sujeto Contacto", false),

	/** The persona contacto. */
	PERSONA_CONTACTO("persona_contacto", "Persona contacto", true),

	/** The numero contacto. */
	NUMERO_CONTACTO("nro_contacto", "N\u00FAmero del contacto", true),

	/** The observacion. */
	OBSERVACION("observacion", "Descripcion de la observaci\u00F3n", true),

	/** The id actividad relacionada. */
	ID_ACTIVIDAD_RELACIONADA("act_rel_id", "ID de la Actividad Relacionada", true),

	/** The id actividad externa. */
	ID_ACTIVIDAD_EXTERNA("act_ext_id", "ID de la Actividad Externa", true),

	/** The id motivo contacto. */
	ID_MOTIVO_CONTACTO("mot_cont_id", "ID del Motivo Contacto", true),

	/** The id clasificacion. */
	ID_CLASIFICACION("clasificacion_id", "ID de la clasificaci\u00F3n", true),

	/** The id estado. */
	ID_ESTADO("estado_id", "ID del Estado", true),

	/** The id forma contacto. */
	ID_FORMA_CONTACTO("forma_cont_id", "ID de la forma Contacto", true),

	/** The intranet user filial cap descripcion. */
	INTRANET_USER_FILIAL_CAP_DESCRIPCION("intranet_usr_filial_cap",
			"Descripcion de la Filial Cap del Usuario de Intranet", false),

	/** The intranet user filial cap id. */
	INTRANET_USER_FILIAL_CAP_ID("intranet_usr_filial_cap_id", "Id de la Filial Cap del Usuario de Intranet", true),

	/** The intranet user filial descripcion. */
	INTRANET_USER_FILIAL_DESCRIPCION("intranet_usr_filial", "Descripcion de la Filial del Usuario de Intranet", false),

	/** The intranet user filial id. */
	INTRANET_USER_FILIAL_ID("intranet_usr_filial_id", "Id de la Filial del Usuario de Intranet", true),

	/** The intranet user name. */
	INTRANET_USER_NAME("intranet_username", "Nombre Usuario de Intranet", true),

	/** The intranet user personal data cap descripcion. */
	INTRANET_USER_PERSONAL_DATA_CAP_DESCRIPCION("intranet_usr_personal_data_cap",
			"Descripcion del Cap de los Datos Personales Usuario de Intranet", false),

	/** The intranet user personal data filial descripcion. */
	INTRANET_USER_PERSONAL_DATA_FILIAL_DESCRIPCION("intranet_usr_personal_filial",
			"Descripcion de la Filial de los Datos Personales Usuario de Intranet", false),

	/** The intranet user personal data last name. */
	INTRANET_USER_PERSONAL_DATA_LAST_NAME("intranet_usr_personal_apellido",
			"Apellido de los Datos Personales Usuario de Intranet", false),

	/** The intranet user personal data first name. */
	INTRANET_USER_PERSONAL_DATA_FIRST_NAME("intranet_usr_personal_data_apellido",
			"Nombre de los Datos Personales Usuario de Intranet", false),

	/** The intranet user personal data filial id. */
	INTRANET_USER_PERSONAL_DATA_FILIAL_ID("intranet_usr_personal_data_filial_id",
			"Id de la Filial de los Datos Personales Usuario de Intranet", false),

	/** The nombre usuario responsable. */
	NOMBRE_USUARIO_RESPONSABLE("nombre_usu_responsable", "Nombre del usuario responsable", true),

	/** The intranet user personal data username. */
	INTRANET_USER_PERSONAL_DATA_USERNAME("intranet_personal_data_username",
			"MT de los Datos Personales Usuario de Intranet", false);

	/** The nombre. */
	private String nombre;

	/** The descripcion. */
	private String descripcion;

	/** The registra actividad. */
	private Boolean registraActividad;

	/**
	 * Instantiates a new parametro DTO.
	 *
	 * @param nombre
	 *            the nombre
	 * @param descripcion
	 *            the descripcion
	 * @param registraActividad
	 *            the registra actividad
	 */
	private Parametro(String nombre, String descripcion, Boolean registraActividad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.registraActividad = registraActividad;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre
	 *            the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * Sets the descripcion.
	 *
	 * @param descripcion
	 *            the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

}
