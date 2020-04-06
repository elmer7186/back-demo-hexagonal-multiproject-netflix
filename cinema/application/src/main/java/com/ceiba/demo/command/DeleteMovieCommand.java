package com.ceiba.demo.command;

import com.ceiba.demo.port.MovieRepository;

public class DeleteMovieCommand {

	private MovieRepository movieRepository;

	public DeleteMovieCommand(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public void handler(int id) {
		movieRepository.delete(id);
	}

}
