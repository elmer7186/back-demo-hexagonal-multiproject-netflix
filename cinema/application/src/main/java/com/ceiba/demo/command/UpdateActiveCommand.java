package com.ceiba.demo.command;

import com.ceiba.demo.service.MovieService;

public class UpdateActiveCommand {

	private MovieService movieService;

	public UpdateActiveCommand(MovieService movieService) {
		this.movieService = movieService;
	}

	public void handler(int id, boolean active) {
		movieService.updateActive(id, active);
	}

}
