package ar.com.osde.integracionsaludsoft.web.action.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.CollectionUtils;

import com.opensymphony.xwork2.ActionSupport;

import ar.com.osde.framework.services.validation.exception.ServiceCommonException;
import ar.com.osde.framework.services.validation.exception.ValidationError;
import ar.com.osde.integracionsaludsoft.exception.ServiceValidationException;

/**
 * The Class ExceptionHandlerAction.
 */
public class ExceptionHandlerAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6623858109354987754L;

	/** The logger. */
	private static final Logger LOGGER = Logger.getLogger(ExceptionHandlerAction.class);

	/** The exception. */
	private Exception exception;

	/**
	 * Handle json exception.
	 *
	 * @return the string
	 */
	public String handleJsonException() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setStatus(500);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Content-Type", "application/json; charset=utf-8");
		try {
			response.getWriter().write(this.getException().getMessage());
		} catch (IOException e) {
			LOGGER.error("Error intentando escribir en el response", e);
		}
		return ERROR;
	}

	/**
	 * Handle json common exception.
	 *
	 * @return the string
	 */
	public String handleJsonCommonException() {
		ServiceCommonException ex = (ServiceCommonException) this.getException();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Content-Type", "application/json; charset=utf-8");
		try {
			if (CollectionUtils.isEmpty(ex.getValidationErrors())) {
				response.setStatus(500);
				response.getWriter().write(ex.getMessage());
			} else {
				response.setStatus(409);
				StringBuilder sb = new StringBuilder();
				int index = 0;
				for (ValidationError ve : ex.getValidationErrors()) {
					sb.append(ve.getErrorMessage());
					if (index < ex.getValidationErrors().size() - 1) {
						sb.append("\n");
					}
					index++;
				}
				response.getWriter().write(sb.toString());
			}
		} catch (IOException e) {
			LOGGER.error("Error intentando escribir en el response", e);
		}

		return ERROR;
	}

	/**
	 * Handle json validation exception.
	 *
	 * @return the string
	 */
	public String handleJsonValidationException() {
		ServiceValidationException ex = (ServiceValidationException) this.getException();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Content-Type", "application/json; charset=utf-8");
		try {
			response.setStatus(409);
			response.getWriter().write(ex.getMessage());
		} catch (IOException e) {
			LOGGER.error("Error intentando escribir en el response", e);
		}

		return ERROR;
	}

	/**
	 * Gets the exception.
	 *
	 * @return the exception
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * Sets the exception.
	 *
	 * @param exception
	 *            the new exception
	 */
	public void setException(Exception exception) {
		this.exception = exception;
	}

}