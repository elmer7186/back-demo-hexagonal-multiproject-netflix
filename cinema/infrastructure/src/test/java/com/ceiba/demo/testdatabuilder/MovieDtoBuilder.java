package com.ceiba.demo.testdatabuilder;

import com.ceiba.demo.entity.Category;
import com.ceiba.demo.entity.MovieDto;

public class MovieDtoBuilder {

	private int id;
	private String name;
	private String description;
	private Category category;
	private boolean active;

	public MovieDtoBuilder() {
		name = "Avengers";
		description = "";
		category = CategoryBuilder.aCategory().build();
		active = true;
	}

	public MovieDtoBuilder withId(int id) {
		this.id = id;
		return this;
	}

	public MovieDtoBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public MovieDtoBuilder withDescription(String description) {
		this.description = description;
		return this;
	}

	public MovieDtoBuilder withCategory(Category category) {
		this.category = category;
		return this;
	}

	public MovieDtoBuilder withActive(boolean active) {
		this.active = active;
		return this;
	}

	public MovieDto build() {
		return new MovieDto(id, name, description, category, active);
	}

	public static MovieDtoBuilder aMovieDto() {
		return new MovieDtoBuilder();
	}

}
