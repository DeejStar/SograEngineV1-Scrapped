package com.soginteractive.engine.battle.misc;

import static com.soginteractive.engine.core.util.ScriptUtils.printInt;
import static com.soginteractive.engine.core.util.ScriptUtils.printString;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class Cost implements Serializable {

	private String type;
	private int amount;

	private final String OBJ = "cost";
	private final String NAME = "type";
	private final String AMT = "amount";

	public Cost() {
		this("", 0);
	}
	
	public Cost(String type, int amount) {
		type(type).amount(amount);
	}

	public Cost type(String type) {
		this.type = type;
		return this;
	}

	public Cost amount(int amount) {
		this.amount = amount;
		return this;
	}

	public String getType() {
		return type;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public void write(Json json) {
		json.writeObjectStart(OBJ);
		{
			json.writeValue(NAME, type);
			json.writeValue(AMT, amount);
		}
		json.writeObjectEnd();
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		JsonValue child = jsonData.child;
		type(child.getString(NAME));
		amount(child.getInt(AMT));
	}

	public void printJson() {
		printString(NAME, type);
		printInt(AMT, amount);
		System.out.println("\n");
	}

}
