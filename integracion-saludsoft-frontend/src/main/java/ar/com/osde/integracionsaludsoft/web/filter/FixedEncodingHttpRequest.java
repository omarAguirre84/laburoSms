package ar.com.osde.integracionsaludsoft.web.filter;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;

/**
 * The Class FixedEncodingHttpRequest.
 */
public class FixedEncodingHttpRequest extends HttpServletRequestWrapper {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(FixedEncodingHttpRequest.class);

	/** The parameter map. */
	@SuppressWarnings("rawtypes")
	private Map parameterMap;

	/** The struts encoding. */
	private String strutsEncoding;

	/**
	 * Instantiates a new fixed encoding http request.
	 * 
	 * @param request
	 *            the request
	 */
	public FixedEncodingHttpRequest(HttpServletRequest request) {
		super(request);
		strutsEncoding = "ISO-8859-1";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletRequestWrapper#setCharacterEncoding(java.lang.String
	 * )
	 */
	@Override
	public void setCharacterEncoding(String encoding) throws UnsupportedEncodingException {
		strutsEncoding = encoding;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequestWrapper#getParameterMap()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getParameterMap() {
		// WORKAROUND for ajax calls with GET method
		if (parameterMap == null) {
			if (getMethod().equals("GET")) {
				parameterMap = new HashMap();
				final Map<String, String[]> originalParameterMap = super.getParameterMap();
				for (Map.Entry<String, String[]> entry : originalParameterMap.entrySet()) {
					final String[] values = new String[entry.getValue().length];
					for (int i = 0; i < values.length; i++) {
						try {
							values[i] = new String(entry.getValue()[i].getBytes(strutsEncoding),
									getCharacterEncoding());
						} catch (UnsupportedEncodingException ex) {
							LOGGER.info("Se omite la excepcion", ex);
						}
					}
					parameterMap.put(entry.getKey(), values);
				}
			} else if (getMethod().equals("PUT") || getMethod().equals("POST")) {
				parameterMap = new HashMap();
				final Map<String, String[]> originalParameterMap = super.getParameterMap();
				for (Map.Entry<String, String[]> entry : originalParameterMap.entrySet()) {
					final String[] values = new String[entry.getValue().length];
					for (int i = 0; i < values.length; i++) {
						values[i] = StringEscapeUtils.unescapeHtml(entry.getValue()[i]);
					}
					parameterMap.put(entry.getKey(), values);
				}
			} else {
				parameterMap = super.getParameterMap();
			}
		}
		return parameterMap;
	}

}
