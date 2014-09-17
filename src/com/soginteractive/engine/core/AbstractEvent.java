package com.soginteractive.engine.core;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public abstract class AbstractEvent implements Event, Serializable {

	private String name, description;

	public AbstractEvent(String name) {
		name(name);
	}

	@Override
	public Event name(String name) {
		this.name = name;
		return this;
	}

	@Override
	public Event description(String description) {
		this.description = description;
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public void write(Json json) {
		
	}
	
	@Override
	public void read(Json json, JsonValue value) {
		
	}

}
