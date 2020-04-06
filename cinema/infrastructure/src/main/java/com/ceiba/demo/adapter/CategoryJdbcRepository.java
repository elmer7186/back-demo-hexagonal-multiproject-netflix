package com.ceiba.demo.adapter;

import com.ceiba.demo.entity.Category;
import com.ceiba.demo.mapper.CategoryMapper;
import com.ceiba.demo.port.CategoryRepository;
import java.util.Collection;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryJdbcRepository implements CategoryRepository {

	private String sqlFindAll = "SELECT cat.category_id, cat.name, cat.description FROM category as cat";

	private NamedParameterJdbcTemplate jdbcTemplate;

	private CategoryMapper categoryMapper;

	public CategoryJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate,
			CategoryMapper categoryMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.categoryMapper = categoryMapper;
	}

	@Override
	public Collection<Category> findAll() {
		return jdbcTemplate.query(sqlFindAll, categoryMapper);
	}

}
