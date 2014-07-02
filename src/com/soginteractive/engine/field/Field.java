package com.soginteractive.engine.field;

public class Field {

	private String name;

	public Field() {
		this("");
	}

	public Field(String name) {
		name(name);
	}

	public Field name(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

}
