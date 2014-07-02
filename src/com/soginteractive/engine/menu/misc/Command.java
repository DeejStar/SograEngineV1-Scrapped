package com.soginteractive.engine.menu.misc;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

import static com.soginteractive.engine.core.util.ScriptUtils.*;

public class Command implements Serializable {

	private String name, description, path;
	private boolean selected;

	private final String OBJ = "command";
	private final String NAME = "name";
	private final String DESC = "description";
	private final String SLCT = "selected";

	public Command() {
		this("");
	}

	public Command(String name) {
		name(name);
		selected = false;
	}

	public Command name(String name) {
		this.name = name;
		return this;
	}

	public Command description(String description) {
		this.description = description;
		return this;
	}

	public Command path(String path) {
		this.path = path;
		return this;
	}

	public Command selected(boolean selected) {
		this.selected = selected;
		return this;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return (description != null ? description : "");
	}

	public String getPath() {
		return path;
	}

	public boolean isSelected() {
		return selected;
	}

	@Override
	public void write(Json json) {
		json.writeObjectStart(OBJ);
		{
			json.writeValue(NAME, name);
			json.writeValue(DESC, description);
			json.writeValue(SLCT, selected);
		}
		json.writeObjectEnd();
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		JsonValue child = jsonData.child;

		name(child.getString(NAME));
		description(child.getString(DESC));
		selected(child.getBoolean(SLCT));
	}

	public void printJson() {
		printString(NAME, name);
		printString(DESC, description);
		printBoolean(SLCT, selected);
		System.out.println("\n");
	}

}
