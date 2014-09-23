package com.soginteractive.engine.core.equipment;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.soginteractive.engine.core.AbstractEquipment;

public class Accessory extends AbstractEquipment {

	private final String OBJ = "Accessory";

	public Accessory() {
		this("");
	}

	public Accessory(String name) {
		super(name);
	}

	@Override
	public void write(Json json) {
		json.writeObjectStart(OBJ);
		{
			super.write(json);
		}
		json.writeObjectEnd();
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		super.read(json, jsonData);
	}

	@Override
	public void printJson() {
		super.printJson();
		System.out.println("\n");
	}

}
