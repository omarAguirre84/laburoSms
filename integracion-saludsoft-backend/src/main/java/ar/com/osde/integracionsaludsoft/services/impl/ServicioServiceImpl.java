package ar.com.osde.integracionsaludsoft.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.hibernate.AssertionFailure;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.util.CollectionUtils;

import ar.com.osde.framework.business.crud.service.impl.Assembler;
import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.framework.services.ServiceException;
import ar.com.osde.integracionsaludsoft.bo.ServicioBO;
import ar.com.osde.integracionsaludsoft.dto.ServicioDTO;
import ar.com.osde.integracionsaludsoft.dto.ServicioFilter;
import ar.com.osde.integracionsaludsoft.entities.Servicio;
import ar.com.osde.integracionsaludsoft.exception.ServiceValidationException;
import ar.com.osde.integracionsaludsoft.exception.ValidationException;
import ar.com.osde.integracionsaludsoft.services.ServicioService;
import ar.com.osde.integracionsaludsoft.utils.CustomError;

/**
 * The Class ServicioServiceImpl.
 */
@WebService(endpointInterface = "ar.com.osde.integracionsaludsoft.services.ServicioService", serviceName = "ServicioService")
public class ServicioServiceImpl implements ServicioService {

	/** The servicio BO. */
	private ServicioBO servicioBO;

	/** The assembler. */
	private Assembler assembler;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ar.com.osde.integracionsaludsoft.services.ServicioService#getAll()
	 */
	public List<ServicioDTO> getAll() throws ServiceException {
		List<ServicioDTO> result = new ArrayList<ServicioDTO>();
		List<Servicio> list = new ArrayList<Servicio>();
		try {
			list = this.getServicioBO().getAll();
		} catch (BusinessException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		if (!CollectionUtils.isEmpty(list)) {
			for (Servicio item : list) {
				result.add(this.getAssembler().getDTO(item, ServicioDTO.class));
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.osde.integracionsaludsoft.services.ServicioService#getAllByFilter(
	 * ar.com.osde.integracionsaludsoft.dto.ServicioFilter)
	 */
	public List<ServicioDTO> getAllByFilter(ServicioFilter filter) throws ServiceException {
		List<ServicioDTO> result = new ArrayList<ServicioDTO>();
		List<Servicio> list = new ArrayList<Servicio>();
		try {
			list = this.getServicioBO().getAllByFilter(filter);
		} catch (ValidationException e) {
			throw new ServiceValidationException(e.getMessage(), e);
		} catch (BusinessException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		if (!CollectionUtils.isEmpty(list)) {
			for (Servicio item : list) {
				result.add(this.getAssembler().getDTO(item, ServicioDTO.class));
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.osde.integracionsaludsoft.services.ServicioService#getByID(java.
	 * lang.Long)
	 */
	public ServicioDTO getByID(Long id) throws ServiceException {
		Servicio servicio;
		try {
			servicio = this.getServicioBO().getByID(id);
			return this.getAssembler().getDTO(servicio, ServicioDTO.class);
		} catch (ValidationException e) {
			throw new ServiceValidationException(e.getMessage(), e);
		} catch (BusinessException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.osde.integracionsaludsoft.services.ServicioService#getByCodigo(
	 * java.lang.String)
	 */
	@Override
	public ServicioDTO getByCodigo(String codigo) throws ServiceException, ServiceValidationException {
		Servicio servicio;
		try {
			servicio = this.servicioBO.getByCodigo(codigo);
			return this.getAssembler().getDTO(servicio, ServicioDTO.class);
		} catch (ValidationException e) {
			throw new ServiceValidationException(e.getMessage(), e);
		} catch (BusinessException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.osde.integracionsaludsoft.services.ServicioService#save(ar.com
	 * .osde.integracionsaludsoft.dto.ServicioDTO)
	 */
	public ServicioDTO save(ServicioDTO servicioDTO) throws ServiceException {
		try {
			return this.getAssembler().getDTO(
					this.getServicioBO().save(this.getAssembler().fromDTO(servicioDTO, Servicio.class)),
					ServicioDTO.class);
		} catch (AssertionFailure e) {
			throw new ServiceValidationException(CustomError.EXISTING_CODE.getDescription(), e);
		} catch (ValidationException e) {
			throw new ServiceValidationException(e.getMessage(), e);
		} catch (BusinessException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.osde.integracionsaludsoft.services.ServicioService#update(ar.com
	 * .osde.integracionsaludsoft.dto.ServicioDTO)
	 */
	public ServicioDTO update(ServicioDTO servicioDTO) throws ServiceException {
		try {
			return this.getAssembler().getDTO(
					this.getServicioBO().update(this.getAssembler().fromDTO(servicioDTO, Servicio.class)),
					ServicioDTO.class);
		} catch (DataIntegrityViolationException e) {
			throw new ServiceValidationException(CustomError.EXISTING_CODE.getDescription(), e);
		} catch (ValidationException e) {
			throw new ServiceValidationException(e.getMessage(), e);
		} catch (BusinessException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ar.com.osde.integracionsaludsoft.services.ServicioService#delete(ar.com
	 * .osde.integracionsaludsoft.dto.ServicioDTO)
	 */
	public void delete(ServicioDTO servicio) throws ServiceException {
		try {
			this.getServicioBO().delete(this.getAssembler().fromDTO(servicio, Servicio.class));
		} catch (BusinessException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	/**
	 * 
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
