package ar.com.osde.integracionsaludsoft.web.action.jsonServerMock;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jettison.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class JsonServerMock extends ActionSupport {
	
	private static final long serialVersionUID = 6397190444410952686L;
	
	private Map<String, String> parametrosIn;
	private Map<String, String> parametrosOut;
	
	public String execute() throws Exception {
		return null;
	}
	
	public String response() throws Exception {
		
		this.parametrosIn = new HashMap<String, String>();
		this.parametrosOut = new HashMap<String, String>();
		
		this.parametrosIn = (Map) ActionContext.getContext().getParameters();
		ServletActionContext.getRequest().getParameterMap();
		Map<String, String> paramsMap = new HashMap<String, String>();
		for(Entry<String, String> entry : parametrosIn.entrySet()) {
			String a = entry.getKey();
		    JSONObject jObject = new JSONObject(a);
		    jObject.toString();
			for (String pair : a.split("\\,")) {
				int idxOfEqual = pair.indexOf(":");
				if (idxOfEqual < 0) {
					paramsMap.put(pair, "null");
					continue;
				} else if (idxOfEqual == 0) {
					paramsMap.put("null", pair);
				}
				parametrosOut.put(pair.substring(0, idxOfEqual).replace('{', ' '), pair.substring(idxOfEqual + 1).replace('}', ' '));
			}
		}
		return SUCCESS;
	}

	
	public Map<String, String> getParametrosIn() {
		return parametrosIn;
	}
	public void setParametrosIn(Map<String, String> parametrosIn) {
		this.parametrosIn = parametrosIn;
	}

	public Map<String, String> getParametrosOut() {
		return parametrosOut;
	}

	public void setParametrosOut(Map<String, String> parametrosOut) {
		this.parametrosOut = parametrosOut;
	}
}
