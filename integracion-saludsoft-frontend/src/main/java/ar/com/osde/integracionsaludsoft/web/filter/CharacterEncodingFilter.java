package ar.com.osde.integracionsaludsoft.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * The Class CharacterEncodingFilter.
 */
public class CharacterEncodingFilter extends OncePerRequestFilter {

	/** The encoding. */
	private String encoding;

	/** The force encoding. */
	@SuppressWarnings("unused")
	private boolean forceEncoding;

	/**
	 * Sets the encoding.
	 * 
	 * @param encoding
	 *            the new encoding
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * Sets the force encoding.
	 * 
	 * @param forceEncoding
	 *            the new force encoding
	 */
	public void setForceEncoding(boolean forceEncoding) {
		this.forceEncoding = forceEncoding;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		request.setCharacterEncoding(encoding);
		filterChain.doFilter(new FixedEncodingHttpRequest(request), response);
	}
	
}
