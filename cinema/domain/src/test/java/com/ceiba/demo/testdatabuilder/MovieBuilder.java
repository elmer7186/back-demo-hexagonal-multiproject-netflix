package com.ceiba.demo.testdatabuilder;

import com.ceiba.demo.entity.Category;
import com.ceiba.demo.entity.Movie;

;

public class MovieBuilder {

	private int id;
	private String name;
	private String description;
	private Category category;
	private boolean active;
	private boolean deleted;

	public MovieBuilder() {
		id = 1;
		name = "The Conjuring";
		description = "";
		category = CategoryBuilder.aCategory().build();
		active = true;
		deleted = false;
	}

	public MovieBuilder withId(int id) {
		this.id = id;
		return this;
	}

	public MovieBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public MovieBuilder withDescription(String description) {
		this.description = description;
		return this;
	}

	public MovieBuilder withCategory(Category category) {
		this.category = category;
		return this;
	}

	public MovieBuilder withActive(boolean active) {
		this.active = active;
		return this;
	}

	public MovieBuilder withDeleted(boolean deleted) {
		this.deleted = deleted;
		return this;
	}

	public Movie build() {
		return new Movie(id, name, description, category, active, deleted);
	}

	public static MovieBuilder aMovie() {
		return new MovieBuilder();
	}

}
