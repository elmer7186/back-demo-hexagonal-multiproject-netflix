package com.ceiba.demo.testdatabuilder;

import com.ceiba.demo.entity.Category;

public class CategoryBuilder {

	private int id;
	private String name;
	private String description;

	public CategoryBuilder() {
		id = 1;
		name = "Science Fiction";
		description = "";
	}

	public CategoryBuilder withId(int id) {
		this.id = id;
		return this;
	}

	public CategoryBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public CategoryBuilder withDescription(String description) {
		this.description = description;
		return this;
	}

	public Category build() {
		return new Category(id, name, description);
	}

	public static CategoryBuilder aCategory() {
		return new CategoryBuilder();
	}
}
