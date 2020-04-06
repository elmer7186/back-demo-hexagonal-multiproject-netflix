package com.ceiba.demo.entity;

public class Category {
	
	public static final String NAME_REQUIRED = "El campo nombre es requerido";
	public static final String DESCRIPTION_REQUIRED = "El campo descripcion es requerido";

	private int id;
	private String name;
	private String description;
	
	public Category() {
		
	}

	public Category(int id, String name, String description) {
		super();
		this.id = id;
		ArgumentValidator.validateRequired(name, NAME_REQUIRED);
		this.name = name;
		ArgumentValidator.validateRequired(description, DESCRIPTION_REQUIRED);
		this.description = description;
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

}
