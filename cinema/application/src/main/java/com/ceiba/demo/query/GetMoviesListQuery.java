package com.ceiba.demo.query;

import com.ceiba.demo.entity.Movie;
import com.ceiba.demo.port.MovieRepository;
import java.util.Collection;

public class GetMoviesListQuery {

	private MovieRepository movieRepository;

	public GetMoviesListQuery(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public Collection<Movie> handler() {
		return this.movieRepository.findAll();
	}
}
