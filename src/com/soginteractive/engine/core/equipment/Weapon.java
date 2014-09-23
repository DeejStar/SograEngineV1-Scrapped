package com.soginteractive.engine.core.equipment;

import static com.soginteractive.engine.core.util.ScriptUtils.printFloat;
import static com.soginteractive.engine.core.util.ScriptUtils.printInt;
import static com.soginteractive.engine.core.util.ScriptUtils.printString;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.soginteractive.engine.core.AbstractEquipment;

public class Weapon extends AbstractEquipment {

	private int damage;
	private float hitChance;
	private String range;

	private final String OBJ = "Weapon";
	private final String DMG = "damage";
	private final String HITC = "hitChance";
	private final String RNG = "range";

	public Weapon() {
		this("");
	}

	public Weapon(String name) {
		super(name);
	}

	public Weapon damage(int damage) {
		this.damage = damage;
		return this;
	}

	public Weapon hitChance(float hitChance) {
		this.hitChance = hitChance;
		return this;
	}

	public Weapon range(String range) {
		this.range = range;
		return this;
	}

	public int getDamage() {
		return damage;
	}

	public float getHitChance() {
		return hitChance;
	}

	public String getRange() {
		return range;
	}

	@Override
	public void write(Json json) {
		json.writeObjectStart(OBJ);
		{
			super.write(json);
			json.writeValue(DMG, damage);
			json.writeValue(HITC, hitChance);
			json.writeValue(RNG, range);
		}
		json.writeObjectEnd();
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		super.read(json, jsonData);

		JsonValue child = jsonData.child;
		damage(child.getInt(DMG));
		hitChance(child.getFloat(HITC));
		range(child.getString(RNG));
	}

	@Override
	public void printJson() {
		super.printJson();
		printInt(DMG, damage);
		printFloat(HITC, hitChance);
		printString(RNG, range);
		System.out.println("\n");
	}

}
