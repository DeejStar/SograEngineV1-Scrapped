package com.soginteractive.engine.core.equipment;

import static com.soginteractive.engine.core.util.ScriptUtils.printFloat;
import static com.soginteractive.engine.core.util.ScriptUtils.printInt;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.soginteractive.engine.core.AbstractEquipment;

public class Armor extends AbstractEquipment {

	private int defense, magicDefense;
	private float defenseRate, magicDefenseRate;

	private final String OBJ = "Armor";
	private final String DEF = "defense";
	private final String MAGD = "magicDefense";
	private final String DEFR = "defenseRate";
	private final String MAGDR = "magicDefenseRate";

	public Armor() {
		this("");
	}

	public Armor(String name) {
		super(name);
	}

	public Armor defense(int defense) {
		this.defense = defense;
		return this;
	}

	public Armor magicDefense(int magicDefense) {
		this.magicDefense = magicDefense;
		return this;
	}

	public Armor defenseRate(float defenseRate) {
		this.defenseRate = defenseRate;
		return this;
	}

	public Armor magicDefenseRate(float magicDefenseRate) {
		this.magicDefenseRate = magicDefenseRate;
		return this;
	}

	public int getDefense() {
		return defense;
	}

	public int getMagicDefense() {
		return magicDefense;
	}

	public float getDefenseRate() {
		return defenseRate;
	}

	public float getMagicDefenseRate() {
		return magicDefenseRate;
	}

	@Override
	public void write(Json json) {
		json.writeObjectStart(OBJ);
		{
			super.write(json);
			json.writeValue(DEF, defense);
			json.writeValue(MAGD, magicDefense);
			json.writeValue(DEFR, defenseRate);
			json.writeValue(MAGDR, magicDefenseRate);
		}
		json.writeObjectEnd();
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		super.read(json, jsonData);

		JsonValue child = jsonData.child;
		defense(child.getInt(DEF));
		magicDefense(child.getInt(MAGD));
		defenseRate(child.getFloat(DEFR));
		magicDefenseRate(child.getFloat(MAGDR));
	}

	@Override
	public void printJson() {
		super.printJson();

		printInt(DEF, defense);
		printInt(MAGD, magicDefense);
		printFloat(DEFR, defenseRate);
		printFloat(MAGDR, magicDefenseRate);
		System.out.println("\n");
	}
}
