package ar.com.osde.integracionsaludsoft.test.utils;

import java.lang.reflect.InvocationTargetException;

import org.junit.Assert;
import org.junit.Test;

import ar.com.osde.integracionsaludsoft.utils.CustomError;

/**
 * The Class CustomErrorTest.
 */
public class CustomErrorTest {

	/**
	 * Gets the code test.
	 *
	 * @return the code test
	 */
	@Test
	public void getCodeTest() {
		Assert.assertNotNull(CustomError.REQUIRED_NAME.getCode());
	}

	/**
	 * To string test.
	 */
	@Test
	public void toStringTest() {
		String expectedString = CustomError.REQUIRED_NAME.getCode() + ": " + CustomError.REQUIRED_NAME.getDescription();
		Assert.assertEquals(expectedString, CustomError.REQUIRED_NAME.toString());
	}

	/**
	 * Values.
	 */
	@Test
	public void values() {
		CustomError[] values = CustomError.values();
		Assert.assertNotNull(values);
		Assert.assertTrue(values.length > 0);
	}

	/**
	 * Valueof.
	 *
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 * @throws InvocationTargetException
	 *             the invocation target exception
	 * @throws NoSuchMethodException
	 *             the no such method exception
	 * @throws SecurityException
	 *             the security exception
	 */
	@Test
	public void valueof() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		CustomError valueOf = CustomError.valueOf("REQUIRED_CODE");
		Assert.assertNotNull(valueOf);
		Assert.assertEquals(CustomError.REQUIRED_CODE.toString(), valueOf.toString());
	}
	
}
