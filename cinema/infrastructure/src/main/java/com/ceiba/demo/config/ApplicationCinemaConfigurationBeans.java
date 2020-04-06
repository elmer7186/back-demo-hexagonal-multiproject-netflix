package com.ceiba.demo.config;

import com.ceiba.demo.command.CreateMovieCommand;
import com.ceiba.demo.command.DeleteMovieCommand;
import com.ceiba.demo.command.UpdateActiveCommand;
import com.ceiba.demo.command.UpdateMovieCommand;
import com.ceiba.demo.port.CategoryRepository;
import com.ceiba.demo.port.MovieRepository;
import com.ceiba.demo.query.GetAllCategoriesQuery;
import com.ceiba.demo.query.GetMoviesListQuery;
import com.ceiba.demo.service.MovieService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ceiba.demo")
public class ApplicationCinemaConfigurationBeans {

	@Bean
	public CreateMovieCommand createMovieCommand(MovieRepository movieRepository) {
		return new CreateMovieCommand(movieRepository);
	}

	@Bean
	public DeleteMovieCommand deleteMovieCommand(MovieRepository movieRepository) {
		return new DeleteMovieCommand(movieRepository);
	}

	@Bean
	public UpdateMovieCommand updateMovieCommand(MovieRepository movieRepository) {
		return new UpdateMovieCommand(movieRepository);
	}

	@Bean
	public UpdateActiveCommand updateActiveCommand(MovieService movieService) {
		return new UpdateActiveCommand(movieService);
	}

	@Bean
	public GetAllCategoriesQuery getAllCategoriesQuery(CategoryRepository categoryRepository) {
		return new GetAllCategoriesQuery(categoryRepository);
	}

	@Bean
	public GetMoviesListQuery getMoviesListQuery(MovieRepository movieRepository) {
		return new GetMoviesListQuery(movieRepository);
	}

}
