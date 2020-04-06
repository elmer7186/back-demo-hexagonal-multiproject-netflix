package com.ceiba.demo.command;

import com.ceiba.demo.entity.Movie;
import com.ceiba.demo.entity.MovieDto;
import com.ceiba.demo.port.MovieRepository;

public class CreateMovieCommand {
	
	private MovieRepository movieRepository;
	
	public CreateMovieCommand(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public void handler(MovieDto movieDto) {
		movieRepository.save(new Movie(movieDto.getId(), 
											movieDto.getName(),
											movieDto.getDescription(), 
											movieDto.getCategory(), 
											movieDto.isActive(),
											false));
	}

}
