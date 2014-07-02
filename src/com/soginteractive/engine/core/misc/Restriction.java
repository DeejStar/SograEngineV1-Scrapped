package com.soginteractive.engine.core.misc;

import static com.soginteractive.engine.core.util.ScriptUtils.printString;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;


public class Restriction implements Serializable {

	private String name;
	
	private final String OBJ = "restriction";
	private final String NAME = "name";

	public Restriction() {
		this("");
	}

	public Restriction(String name) {
		name(name);
	}

	public Restriction name(String name) {
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
	public void read(Json json, JsonValue jsonData) {
		name(jsonData.child.getString(NAME));
	}
	
	public void printJson() {
		printString(NAME, name);
		System.out.println("\n");
	}
	
}
