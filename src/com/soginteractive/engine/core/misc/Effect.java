package com.soginteractive.engine.core.misc;

import static com.soginteractive.engine.core.util.ScriptUtils.printFloat;
import static com.soginteractive.engine.core.util.ScriptUtils.printString;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class Effect implements Serializable {

	private String effect;
	private float chance;

	private final String OBJ = "effect";
	private final String NAME = "name";
	private final String CHNC = "chance";

	public Effect() {
		this("", 0);
	}

	public Effect(String effect, float chance) {
		effect(effect).chance(chance);
	}

	public Effect effect(String effect) {
		this.effect = effect;
		return this;
	}

	public Effect chance(float chance) {
		this.chance = chance;
		return this;
	}

	public String getEffect() {
		return effect;
	}

	public float getChance() {
		return chance;
	}

	@Override
	public void write(Json json) {
		json.writeObjectStart(OBJ);
		{
			json.writeValue(NAME, effect);
			json.writeValue(CHNC, chance);
		}
		json.writeObjectEnd();
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		JsonValue child = jsonData.child;
		effect(child.getString(NAME));
		chance(child.getFloat(CHNC));
	}
	
	public void printJson() {
		printString(NAME, effect);
		printFloat(CHNC, chance);
		System.out.println("\n");
	}

}
