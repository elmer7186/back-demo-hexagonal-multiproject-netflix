package com.ceiba.demo.adapter;

import com.ceiba.demo.entity.Movie;
import com.ceiba.demo.mapper.MovieMapper;
import com.ceiba.demo.port.MovieRepository;
import java.util.Collection;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MovieJdbcRepository implements MovieRepository {

	private String sqlSaveMovie = "insert into Movie (name, description, category_id, active, deleted) "
			+ "values (:name, :description, :category_id, :active, :deleted)";

	private String sqlGetAllMovies = "SELECT movie.movie_id, movie.name as movie_name, "
			+ "movie.description as movie_description, movie.active, category.category_id, "
			+ "category.name as category_name, category.description as category_description FROM "
			+ "movie INNER JOIN category ON movie.category_id = category.category_id AND " + "deleted = false;";

	private String sqlGetMovie = "SELECT movie.movie_id, movie.name as movie_name, "
			+ "movie.description as movie_description, movie.active, category.category_id, "
			+ "category.name as category_name, category.description as category_description "
			+ "FROM movie INNER JOIN category ON movie.category_id = category.category_id AND " + "movie_id = :id;";

	private String sqlDeleteMovie = "UPDATE movie SET name = :name, description = :description, "
			+ "category_id = :category_id, active = :active, deleted = :deleted WHERE movie_id = :movie_id;";

	private String sqlUpdateMovie = "UPDATE Movie set name= :name, description= :description, "
			+ "category_id= :category_id, active= :active, deleted= :deleted " 
			+ "WHERE movie_id= :movie_id";

	private NamedParameterJdbcTemplate jdbcTemplate;
	private MovieMapper movieMapper;

	public MovieJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate, MovieMapper movieMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.movieMapper = movieMapper;
	}

	@Override
	public void save(Movie movie) {
		MapSqlParameterSource parameters = movieMapper.getInsertSqlParameters(movie);
		jdbcTemplate.update(sqlSaveMovie, parameters);
	}

	@Override
	public Collection<Movie> findAll() {
		return jdbcTemplate.query(sqlGetAllMovies, new MovieMapper());
	}

	@Override
	public void delete(int id) {
		MapSqlParameterSource parameters;
		Movie movie = findById(id);
		movie.setActive(false);
		movie.setDeleted(true);
		parameters = movieMapper.getInsertSqlParameters(movie);
		jdbcTemplate.update(sqlDeleteMovie, parameters);
	}

	@Override
	public Movie findById(int id) {
		MapSqlParameterSource parameters = movieMapper.getDeleteSqlParameters(id);
		Movie movie;
		try {
			movie = jdbcTemplate.queryForObject(sqlGetMovie, parameters, movieMapper);
		} catch (EmptyResultDataAccessException e) {
			movie = null;
		}
		return movie;
	}

	public void update(Movie movie) {
		MapSqlParameterSource parameters = movieMapper.getInsertSqlParameters(movie);
		jdbcTemplate.update(sqlUpdateMovie, parameters);
	}

}
