package com.soginteractive.engine.core;

import static com.soginteractive.engine.core.util.ScriptUtils.printString;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public abstract class AbstractEvent implements Event, Serializable {

	private String name, description;

	private final String NAME = "name";
	private final String DESC = "description";

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
		json.writeValue(NAME, name);
		json.writeValue(DESC, description);
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		JsonValue child = jsonData.child;

		name(child.getString(NAME));
		description(child.getString(DESC));
	}

	public void printJson() {
		printString(NAME, name);
		printString(DESC, description);
	}

}
