package com.ceiba.demo.controller;

import com.ceiba.demo.entity.Category;
import com.ceiba.demo.query.GetAllCategoriesQuery;
import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class CategoryController {

	private GetAllCategoriesQuery getAllCategoriesQuery;

	public CategoryController(GetAllCategoriesQuery getAllCategoriesQuery) {
		this.getAllCategoriesQuery = getAllCategoriesQuery;
	}

	@GetMapping
	public Collection<Category> getAll() {
		return getAllCategoriesQuery.handler();
	}

}
