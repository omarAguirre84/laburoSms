package ar.com.osde.integracionsaludsoft.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.osde.integracionsaludsoft.dto.ParametroDTO;
import edu.emory.mathcs.backport.java.util.Arrays;

public class MapUtils {
	
	
	@SuppressWarnings("unchecked")
	public static ParametrosMapWrapper toParametrosMapWrapper(Map<String, Object> eventInfo) {
		eventInfo.get("eventActividad");
		ParametrosMapWrapper pmw = new ParametrosMapWrapper();
		HashMap<String, String> map = new HashMap<String, String>();
		List<ParametroDTO> p = Arrays.asList(ParametroDTO.values());
		p.forEach((item -> {
			map.put(item.name() , item.getValor(eventInfo));
		}));
		pmw.setMap(map);
		return pmw;
	}
}
