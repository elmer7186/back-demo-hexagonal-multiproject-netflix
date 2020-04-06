package com.ceiba.demo.mapper;

import com.ceiba.demo.entity.Category;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Category(rs.getInt("category_id"), rs.getString("name"), rs.getString("description"));
	}

}
