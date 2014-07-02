package com.soginteractive.engine.core.misc;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

import static com.soginteractive.engine.core.util.ScriptUtils.*;

public class Modifier implements Serializable {

	private String stat;
	private int amount;

	private final String OBJ = "modifier";
	private final String NAME = "stat";
	private final String AMNT = "amount";

	public Modifier() {
		this("", 0);
	}

	public Modifier(String stat, int amount) {
		stat(stat).amount(amount);
	}

	public Modifier stat(String stat) {
		this.stat = stat;
		return this;
	}

	public Modifier amount(int amount) {
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
			json.writeValue(AMNT, amount);
		}
		json.writeObjectEnd();
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		JsonValue child = jsonData.child;
		stat(child.getString(NAME));
		amount(child.getInt(AMNT));
	}
	
	public void printJson() {
		printString(NAME, stat);
		printInt(AMNT, amount);
		System.out.println("\n");
	}

}
