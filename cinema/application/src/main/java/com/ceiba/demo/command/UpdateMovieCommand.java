package com.ceiba.demo.command;

import com.ceiba.demo.entity.Movie;
import com.ceiba.demo.entity.MovieDto;
import com.ceiba.demo.port.MovieRepository;

public class UpdateMovieCommand {

	private MovieRepository movieRepository;

	public UpdateMovieCommand(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public void handler(MovieDto movie) {
		this.movieRepository.update(new Movie(movie.getId(), movie.getName(), movie.getDescription(),
				movie.getCategory(), movie.isActive(), false));
	}
}