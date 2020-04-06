package com.ceiba.demo.port;

import com.ceiba.demo.entity.Movie;
import java.util.Collection;

public interface MovieRepository {

	Movie findById(int id);

	void save(Movie movie);

	Collection<Movie> findAll();

	void delete(int id);

	void update(Movie movie);

}
