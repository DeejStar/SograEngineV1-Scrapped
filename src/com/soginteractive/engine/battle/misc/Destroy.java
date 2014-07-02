package com.soginteractive.engine.battle.misc;

import static com.soginteractive.engine.core.util.ScriptUtils.printInt;
import static com.soginteractive.engine.core.util.ScriptUtils.printString;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class Destroy implements Serializable {

	private String stat;
	private int amount;

	private final String OBJ = "destroy";
	private final String NAME = "stat";
	private final String AMT = "amount";

	public Destroy() {
		this("", 0);
	}
	
	public Destroy(String stat, int amount) {
		stat(stat).amount(amount);
	}

	public Destroy stat(String stat) {
		this.stat = stat;
		return this;
	}

	public Destroy amount(int amount) {
		this.amount = amount;
		return this;
	}

	public String getStat() {
		return stat;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public void write(Json json) {
		json.writeObjectStart(OBJ);
		{
			json.writeValue(NAME, stat);
			json.writeValue(AMT, amount);
		}
		json.writeObjectEnd();
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		JsonValue child = jsonData.child;
		stat(child.getString(NAME));
		amount(child.getInt(AMT));
	}

	public void printJson() {
		printString(NAME, stat);
		printInt(AMT, amount);
		System.out.println("\n");
	}

}
