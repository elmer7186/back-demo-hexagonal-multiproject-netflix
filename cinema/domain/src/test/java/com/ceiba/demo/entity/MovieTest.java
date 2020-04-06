package com.ceiba.demo.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.ceiba.demo.testdatabuilder.MovieBuilder;
import org.junit.Test;

import com.ceiba.demo.exception.CinemaException;

public class MovieTest {

	private static final String EXCEPTION_EXPECTED = "Se esperaba excepcion";

	@Test
	public void movieWithoutName() {
		// Arrange
		MovieBuilder movieBuilder = MovieBuilder.aMovie().withName(null);

		try {
			// Act
			movieBuilder.build();
			fail(EXCEPTION_EXPECTED);
		} catch (CinemaException e) {
			// Assert
			assertEquals(Movie.NAME_REQUIRED, e.getMessage());
		}
	}

	@Test
	public void movieWithoutDescription() {
		// Arrange
		MovieBuilder movieBuilder = MovieBuilder.aMovie().withDescription(null);

		try {
			// Act
			movieBuilder.build();
			fail(EXCEPTION_EXPECTED);
		} catch (CinemaException e) {
			// Assert
			assertEquals(Movie.DESCRIPTION_REQUIRED, e.getMessage());
		}
	}

	@Test
	public void movieWithoutCategory() {
		// Arrange
		MovieBuilder movieBuilder = MovieBuilder.aMovie().withCategory(null);

		try {
			// Act
			movieBuilder.build();
			fail(EXCEPTION_EXPECTED);
		} catch (CinemaException e) {
			// Assert
			assertEquals(Movie.CATEGORY_REQUIRED, e.getMessage());
		}
	}

	@Test
	public void createMovieWithId() {
		// Arrange
		Movie movie = MovieBuilder.aMovie().withId(2).build();

		// Act - Assert
		assertEquals(movie.getId(), 2);

	}
}
