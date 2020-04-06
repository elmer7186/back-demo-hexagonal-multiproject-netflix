package com.ceiba.demo.entity;

import static com.ceiba.demo.testdatabuilder.CategoryBuilder.aCategory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.ceiba.demo.exception.CinemaException;
import com.ceiba.demo.testdatabuilder.CategoryBuilder;

public class CategoryTest {

	private static final String EXCEPTION_EXPECTED = "Se esperaba excepcion";

	@Test
	public void categoryWithoutName() {
		// Arrange
		CategoryBuilder categoryBuilder = aCategory().withName(null);

		try {
			// Act
			categoryBuilder.build();
			fail(EXCEPTION_EXPECTED);
		} catch (CinemaException e) {
			// Assert
			assertEquals(Category.NAME_REQUIRED, e.getMessage());
		}
	}
	
	@Test
	public void categoryWithoutDescription() {
		// Arrange
		CategoryBuilder categoryBuilder = aCategory().withDescription(null);

		try {
			// Act
			categoryBuilder.build();
			fail(EXCEPTION_EXPECTED);
		} catch (CinemaException e) {
			// Assert
			assertEquals(Category.DESCRIPTION_REQUIRED, e.getMessage());
		}
	}
}
