package ar.com.osde.integracionsaludsoft.web.action.integration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ParameterAware;
import org.codehaus.jettison.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

import ar.com.osde.framework.business.exception.BusinessException;
import ar.com.osde.framework.integration.cache.CacheAdminFactory;
import ar.com.osde.integracionsaludsoft.backend.integration.handler.common.UrlRequestType;
import ar.com.osde.integracionsaludsoft.handler.IntegrationHandler;
import ar.com.osde.integracionsaludsoft.services.IntegrationService;
import ar.com.osde.integracionsaludsoft.utils.MapUtils;

/**
 * The Class IntegrationAction.
 */
public class IntegrationAction extends ActionSupport implements ParameterAware {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -479086727842464270L;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(IntegrationAction.class);

	/** The integration service. */
	private transient IntegrationService integrationService;

	/** The integration Handler. */
	private transient IntegrationHandler integrationHandler;

	/** The Struts request parameters. */
	private transient Map<String, String[]> parameters;

	/** The target url GI. */
	private String targetUrl;

	private String stringifiedParams;

	@SuppressWarnings("unchecked")
	public String process() throws Exception {
		Map<String, Object> eventInfo = CacheAdminFactory.getCacheHTTP().decodeInformationURL(ServletActionContext.getRequest());
		targetUrl = integrationService.resolveTargetUrl(UrlRequestType.SERVICIO, parameters.get("codigo")[0], MapUtils.toParametrosMapWrapper(eventInfo));
		
		String urlFormatedParams =targetUrl.split("\\?")[1]; 
		targetUrl = targetUrl.split("\\?")[0];
		
		Map<String, String> paramsMap = new HashMap<String, String>();
		for (String pair : urlFormatedParams.split("&")) {
			int idxOfEqual = pair.indexOf("=");
			if (idxOfEqual < 0) {
				paramsMap.put(pair, "null");
				continue;
			} else if (idxOfEqual == 0) {
				System.out.println(pair);
				paramsMap.put("null", pair.substring(idxOfEqual + 1));
				
				continue;
			}
			paramsMap.put(pair.substring(0, idxOfEqual), pair.substring(idxOfEqual + 1));
		}
//		this.setStringifiedParams(new JSONObject(this.excludeKeysWithNullValues(MapUtils.toParametrosMapWrapper(eventInfo).getMap())).toString());
		this.setStringifiedParams(new JSONObject(paramsMap).toString());
		
		return SUCCESS;
	}
	
	private HashMap <String, String> excludeKeysWithNullValues(HashMap<String, String> map){
		HashMap <String, String> cleanMap = new HashMap<String, String>();
		for (Map.Entry<String, String> entry : map.entrySet()){
			String k = entry.getKey();
			String v = entry.getValue();
			if (v != "null" && v != "" && v != null && v != "[]") {
				cleanMap.put(k, v);
			}
		}
		return cleanMap;
	}
	
	/**
	 * Execute common service.
	 *
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	public String executeCommonService() throws Exception {
		try {
			getIntegrationHandler().handlerCommonServiceEvent(ServletActionContext.getRequest().getReader(),
					ServletActionContext.getResponse().getWriter());
		} catch (BusinessException e) {
			LOGGER.error(e);
			throw e;
		}

		return null;
	}

	/**
	 * Execute GI service.
	 *
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	public String executeGIService() throws Exception {
		try {
			targetUrl = getIntegrationHandler().handlerGIServiceRequest(ServletActionContext.getRequest());
		} catch (BusinessException e) {
			LOGGER.error(e);
			throw e;
		}

		return SUCCESS;
	}

	/**
	 * Gets the target url GI.
	 *
	 * @return the target url GI
	 */
	public String getTargetUrl() {
		return targetUrl;
	}

	/**
	 * Sets the target url GI.
	 *
	 * @param targetUrlGI
	 *            the new target url GI
	 */
	public void setTargetUrl(String targetUrlGI) {
		this.targetUrl = targetUrlGI;
	}

	/**
	 * Gets the integration handler.
	 *
	 * @return the integration handler
	 */
	public IntegrationHandler getIntegrationHandler() {
		return integrationHandler;
	}

	/**
	 * Sets the integration handler.
	 *
	 * @param integrationHandler
	 *            the new integration handler
	 */
	public void setIntegrationHandler(IntegrationHandler integrationHandler) {
		this.integrationHandler = integrationHandler;
	}

	public IntegrationService getIntegrationService() {
		return integrationService;
	}

	public void setIntegrationService(IntegrationService integrationService) {
		this.integrationService = integrationService;
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}

	public String getStringifiedParams() {
		return stringifiedParams;
	}

	public void setStringifiedParams(String stringifiedParams) {
		this.stringifiedParams = stringifiedParams;
	}

}
