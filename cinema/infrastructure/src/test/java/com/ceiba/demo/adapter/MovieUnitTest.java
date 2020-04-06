package com.ceiba.demo.adapter;

import static com.ceiba.demo.testdatabuilder.MovieDtoBuilder.aMovieDto;
import static org.junit.Assert.assertEquals;

import com.ceiba.demo.command.CreateMovieCommand;
import com.ceiba.demo.command.UpdateMovieCommand;
import com.ceiba.demo.entity.Movie;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.demo.entity.MovieDto;
import com.ceiba.demo.query.GetMoviesListQuery;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MovieUnitTest {
	
	@Autowired
	private CreateMovieCommand createMovieCommand;
	
	@Autowired
	private UpdateMovieCommand updateMovieCommand;

	@Autowired
	private GetMoviesListQuery getMoviesListQuery;

	@Test
	public void updateMovieTest() {
		// Arrange
		MovieDto movieDto = aMovieDto().withId(1).build();

		// Act
		createMovieCommand.handler(movieDto);
		updateMovieCommand.handler(movieDto);
		ArrayList<Movie> movies = new ArrayList<>(getMoviesListQuery.handler());

		// Assert
		assertEquals("Avengers", movies.get(1).getName());
	}

}
