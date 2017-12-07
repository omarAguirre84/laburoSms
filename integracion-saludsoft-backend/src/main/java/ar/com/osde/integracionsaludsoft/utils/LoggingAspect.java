package ar.com.osde.integracionsaludsoft.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

import com.googlecode.jsonplugin.JSONException;
import com.googlecode.jsonplugin.JSONUtil;

import ar.com.osde.framework.services.ServiceException;

/**
 * The Class LoggingAspect.
 */
public class LoggingAspect {

	/** The Constant logger. */
	private static final Log LOGGER = LogFactory.getLog("PROFILING");
	private static final int BASIC_OUTPUT_LENGTH = 25;
	private static final int SERVICE_EXCEPTION_LENGTH = 38;

	/**
	 * Log de aplicacion.
	 * 
	 * @param joinPoint
	 *            el joinpoint
	 * @return el valor retornado por el metodo
	 * @throws Throwable
	 *             la excepcion q tire el metodo
	 */
	public Object profile(ProceedingJoinPoint joinPoint) throws Throwable {
		String clase = getClassString(joinPoint);

		if (LOGGER.isDebugEnabled()) {
			logEntrada(clase, joinPoint);
		}

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object retVal = joinPoint.proceed();
		stopWatch.stop();

		if (LOGGER.isDebugEnabled()) {
			logSalidaCompleta(clase, stopWatch, retVal);
		} else {
			logSalidaSimple(clase, stopWatch);
		}

		return retVal;
	}

	/**
	 * Log de timing.
	 * 
	 * @param joinPoint
	 *            el joinpoint
	 * @return el valor retornado por el metodo
	 * @throws Throwable
	 *             la excepcion q tire el metodo
	 */
	public Object timing(ProceedingJoinPoint joinPoint) throws Throwable {
		String clase = getClassString(joinPoint);
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object retVal = joinPoint.proceed();
		stopWatch.stop();
		logSalidaSimple(clase, stopWatch);

		return retVal;
	}

	/**
	 * Log service exceptions.
	 * 
	 * @param ex
	 *            the ex
	 * @throws ServiceException 
	 * @throws Throwable
	 *             the throwable
	 */
	public void logServiceExceptions(ServiceException ex) throws ServiceException {
		try {
			StringBuilder builder = new StringBuilder(SERVICE_EXCEPTION_LENGTH);
			builder.append(CustomError.GENERIC_ERROR.getDescription());
			LOGGER.error(builder.toString(), ex);
		} catch (ClassCastException e) {
			LOGGER.warn(CustomError.BUSINESS_LOGIC_ERROR.getDescription(), ex);
			throw ex;
		}

		throw ex;
	}

	/**
	 * Log de la salida para nivel info.
	 * 
	 * @param clase
	 *            la clase que identifica
	 * @param stopWatch
	 *            el stopwatch
	 */
	private void logSalidaSimple(String clase, StopWatch stopWatch) {
		StringBuilder logMessageAfter = salidaBasica(clase, stopWatch);
		LOGGER.info(logMessageAfter.toString());
	}

	/**
	 * Log de salida si esta en modo debug.
	 * 
	 * @param clase
	 *            la clase que identifica el log
	 * @param stopWatch
	 *            el stopwatch
	 * @param retVal
	 *            el valor de retorno
	 */
	private void logSalidaCompleta(String clase, StopWatch stopWatch, Object retVal) {
		StringBuilder logMessageAfter = salidaBasica(clase, stopWatch);
		logMessageAfter.append(" y la respuesta es: ");
		try {
			logMessageAfter.append(JSONUtil.serialize(retVal));
		} catch (JSONException e) {
			logMessageAfter.append(retVal);
		}
		LOGGER.debug(logMessageAfter.toString());
	}

	/**
	 * Crea el string de la salida basica.
	 * 
	 * @param clase
	 *            la clase que identifica el log
	 * @param stopWatch
	 *            el stopwatch
	 * @return el string de salida basico
	 */
	private StringBuilder salidaBasica(String clase, StopWatch stopWatch) {
		StringBuilder logMessageAfter = new StringBuilder(BASIC_OUTPUT_LENGTH);

		logMessageAfter.append(clase);
		logMessageAfter.append(" Tiempo de respuesta: ");
		logMessageAfter.append(stopWatch.getTotalTimeMillis());
		logMessageAfter.append(" ms");
		return logMessageAfter;
	}

	/**
	 * Logea la entrada al metodo.
	 * 
	 * @param clase
	 *            the clase
	 * @param joinPoint
	 *            el joinPoint
	 */
	private void logEntrada(String clase, ProceedingJoinPoint joinPoint) {
		StringBuilder logMessage = new StringBuilder();
		logMessage.append(clase);
		logMessage.append('(');
		// append args
		Object[] args = joinPoint.getArgs();
		for (int i = 0; i < args.length; i++) {

			try {
				logMessage.append(JSONUtil.serialize(args[i])).append(',');
			} catch (JSONException e) {
				logMessage.append(args[i]).append(',');
			}
		}

		if (args.length > 0) {
			logMessage.deleteCharAt(logMessage.length() - 1);
		}

		logMessage.append(')');
		LOGGER.debug(logMessage.toString());
	}

	/**
	 * Obtiene el nombre de la clase que se esta logeando.
	 * 
	 * @param joinPoint
	 *            el joinpoint
	 * @return el nombre de la clase
	 */
	private String getClassString(ProceedingJoinPoint joinPoint) {
		StringBuilder logMessage = new StringBuilder();
		logMessage.append(joinPoint.getTarget().getClass().getSimpleName());
		logMessage.append('.');
		logMessage.append(joinPoint.getSignature().getName());
		return logMessage.toString();
	}

}
