package com.ceiba.demo.entity;

public class MovieDto {

	private int id;
	private String name;
	private String description;
	private Category category;
	private boolean active;
	
	public MovieDto() {
		
	}

	public MovieDto(int id, String name, String description, Category category, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
