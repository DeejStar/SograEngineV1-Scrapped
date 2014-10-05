package com.soginteractive.engine.core.misc;

import static com.soginteractive.engine.core.util.ScriptUtils.printString;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class Target implements Serializable {

	private String name;

	private final String OBJ = "target";
	private final String NAME = "name";

	public Target() {
		this("");
	}

	public Target(String name) {
		name(name);
	}

	public Target name(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	@Override
	public void write(Json json) {
		json.writeObjectStart(OBJ);
		{
			json.writeValue(NAME, name);
		}
		json.writeObjectEnd();
	}

	@Override
	public void read(Json json, JsonValue value) {
		JsonValue child = value.child;
		name(child.getString(NAME));
	}

	public void printJson() {
		printString(NAME, name);
	}
}
