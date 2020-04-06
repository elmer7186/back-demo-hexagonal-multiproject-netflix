package com.ceiba.demo.config;

import com.ceiba.demo.port.MovieRepository;
import com.ceiba.demo.service.MovieService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ceiba.demo"})
public class DomainCinemaConfigurationBeans {

	@Bean
	public MovieService movieService(MovieRepository movieRepository) {
		return new MovieService(movieRepository);
	}

}
