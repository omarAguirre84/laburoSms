package ar.com.osde.integracionsaludsoft.test.exception;

import org.junit.Assert;
import org.junit.Test;

import ar.com.osde.integracionsaludsoft.exception.ValidationException;

/**
 * The Class ExceptionsTest.
 */
public class ExceptionsTest {

	/**
	 * Constructors.
	 */
	@Test
	public void constructors() {
		Assert.assertNotNull(new ValidationException());
		Assert.assertNotNull(new ValidationException(new NumberFormatException()));
	}

}
