package ar.com.osde.integracionsaludsoft.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.http.NameValuePair;

/**
 * The Class ResolverUtils.
 */
public class ResolverUtils {

	/**
	 * Gets the all parameters.
	 *
	 * @param info
	 *            the info
	 * @return the all parameters
	 */
	public static List<NameValuePair> getNameValueList(final Map<String, String> info) {
		return info.entrySet().stream().map(entry -> {
			NameValuePair nvp = new NameValuePair() {
				public String getValue() {
					return entry.getValue();
				}

				public String getName() {
					return entry.getKey();
				}
			};
			return nvp;
		}).collect(Collectors.toList());
	}
}