package com.ceiba.demo.query;

import com.ceiba.demo.entity.Category;
import com.ceiba.demo.port.CategoryRepository;
import java.util.Collection;

public class GetAllCategoriesQuery {

	private CategoryRepository categoryRepository;

	public GetAllCategoriesQuery(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Collection<Category> handler() {
		return categoryRepository.findAll();
	}

}
