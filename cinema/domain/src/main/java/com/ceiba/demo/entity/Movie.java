package com.ceiba.demo.entity;

public class Movie {

	public static final String NAME_REQUIRED = "El campo nombre es requerido";
	public static final String DESCRIPTION_REQUIRED = "El campo descripcion es requerido";
	public static final String CATEGORY_REQUIRED = "El campo categoria es requerido";

	private int id;
	private String name;
	private String description;
	private Category category;
	private boolean active;
	private boolean deleted;

	public Movie() {
	}

	public Movie(int id, String name, String description, Category category, boolean active, boolean deleted) {
		this.id = id;
		ArgumentValidator.validateRequired(name, NAME_REQUIRED);
		this.name = name;
		ArgumentValidator.validateRequired(description, DESCRIPTION_REQUIRED);
		this.description = description;
		ArgumentValidator.validateRequired(category, CATEGORY_REQUIRED);
		this.category = category;
		this.active = active;
		this.deleted = deleted;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
