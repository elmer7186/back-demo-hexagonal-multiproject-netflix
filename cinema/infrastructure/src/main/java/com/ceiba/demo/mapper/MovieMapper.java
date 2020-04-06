package com.ceiba.demo.mapper;

import com.ceiba.demo.entity.Category;
import com.ceiba.demo.entity.Movie;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper implements RowMapper<Movie> {

	@Override
	public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
		Movie movie = new Movie();
		movie.setId(rs.getInt("movie_id"));
		movie.setName(rs.getString("movie_name"));
		movie.setDescription(rs.getString("movie_description"));
		Category category = new Category();
		category.setId(rs.getInt("category_id"));
		category.setName(rs.getString("category_name"));
		category.setDescription(rs.getString("category.description"));
		movie.setCategory(category);
		movie.setActive(rs.getBoolean("active"));
		return movie;
	}
	
	public MapSqlParameterSource getInsertSqlParameters(Movie movie) {
		return new MapSqlParameterSource()
				.addValue("movie_id", movie.getId())
				.addValue("name", movie.getName())
				.addValue("description", movie.getDescription())
				.addValue("category_id", movie.getCategory().getId())
				.addValue("active", movie.isActive())
				.addValue("deleted", movie.isDeleted());
	}
	
	public MapSqlParameterSource getSqlParameters(Movie movie) {
		return new MapSqlParameterSource().addValue("id", movie.getId())
				.addValue("name", movie.getName())
				.addValue("description", movie.getDescription()).addValue("category_id", movie.getCategory().getId())
				.addValue("active", movie.isActive()).addValue("deleted", movie.isDeleted());
	}

	public MapSqlParameterSource getDeleteSqlParameters(int id) {
		return new MapSqlParameterSource().addValue("id", id);
	}
	
}
