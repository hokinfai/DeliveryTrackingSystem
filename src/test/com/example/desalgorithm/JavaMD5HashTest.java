package com.example.desalgorithm;

import static org.junit.Assert.*;

import org.junit.Test;

public class JavaMD5HashTest {

	@Test
	public void testMd5() {
		// Arrange
		JavaMD5Hash md5 = new JavaMD5Hash();
		// Act
		String code = md5.md5("1234567");
		// Assert
		assertEquals("fcea920f7412b5da7be0cf42b8c93759", code);
	}

	@Test
	public void testNullMd5() {
		// Arrange
		JavaMD5Hash md5 = new JavaMD5Hash();
		// Act
		String code = md5.md5(null);
		// Assert
		assertEquals(null, code);
	}
}
