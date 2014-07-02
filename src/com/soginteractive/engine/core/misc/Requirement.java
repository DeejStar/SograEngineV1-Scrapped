package com.soginteractive.engine.core.misc;

import static com.soginteractive.engine.core.util.ScriptUtils.printInt;
import static com.soginteractive.engine.core.util.ScriptUtils.printString;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class Requirement implements Serializable {

	private String requirement;
	private int amount;

	private final String OBJ = "requirement";
	private final String NAME = "name";
	private final String AMNT = "amount";

	public Requirement() {
		this("", 0);
	}

	public Requirement(String requirement, int amount) {
		requirement(requirement).amount(amount);
	}

	public Requirement requirement(String requirement) {
		this.requirement = requirement;
		return this;
	}

	public Requirement amount(int amount) {
		this.amount = amount;
		return this;
	}

	public String getRequirement() {
		return requirement;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public void write(Json json) {
		json.writeObjectStart(OBJ);
		{
			json.writeValue(NAME, requirement);
			json.writeValue(AMNT, amount);
		}
		json.writeObjectEnd();
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		JsonValue child = jsonData.child;
		requirement(child.getString(NAME));
		amount(child.getInt(AMNT));
	}

	public void printJson() {
		printString(NAME, requirement);
		printInt(AMNT, amount);
		System.out.println("\n");
	}

}
