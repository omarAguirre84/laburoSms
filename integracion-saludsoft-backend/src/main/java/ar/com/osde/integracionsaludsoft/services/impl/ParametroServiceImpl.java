package ar.com.osde.integracionsaludsoft.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import ar.com.osde.framework.business.crud.service.impl.Assembler;
import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.framework.services.ServiceException;
import ar.com.osde.integracionsaludsoft.bo.ParametroBO;
import ar.com.osde.integracionsaludsoft.dto.ParametroDTO;
import ar.com.osde.integracionsaludsoft.entities.Parametro;
import ar.com.osde.integracionsaludsoft.services.ParametroService;

/**
 * The Class ParametroServiceImpl.
 */
@WebService(endpointInterface = "ar.com.osde.integracionsaludsoft.services.ParametroService", serviceName = "ParametroService")
public class ParametroServiceImpl implements ParametroService {

	/** The parametro BO. */
	private ParametroBO parametroBO;

	/** The assembler. */
	private Assembler assembler;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.osde.integracionsaludsoft.services.ParametroService#getAll()
	 */
	public List<ParametroDTO> getAll() throws ServiceException {
		List<Parametro> parametros = null;
		try {
			parametros = this.getParametroBO().getAll();
		} catch (BusinessException e) {
			throw new ServiceException(e.getMessage(), e);
		}

		return this.transformToParametroDTO(parametros);
	}

	/**
	 * Transform to parametro DTO.
	 *
	 * @param parametros
	 *            the parametros
	 * @return the list
	 */
	private List<ParametroDTO> transformToParametroDTO(List<Parametro> parametros) {
		List<ParametroDTO> parametrosDTO = new ArrayList<ParametroDTO>();
		for (Parametro item : parametros) {
			ParametroDTO p = ParametroDTO.valueOf(item.name());
			p.setDescripcion(item.getDescripcion());
			p.setRegistraActividad(item.getRegistraActividad());
			parametrosDTO.add(p);
		}
		return parametrosDTO;
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

	/**
	 * Gets the assembler.
	 *
	 * @return the assembler
	 */
	public Assembler getAssembler() {
		return assembler;
	}

	/**
	 * Sets the assembler.
	 *
	 * @param assembler
	 *            the new assembler
	 */
	public void setAssembler(Assembler assembler) {
		this.assembler = assembler;
	}
}
