package com.soginteractive.engine.core;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public abstract class AbstractConsumable implements Consumable, Serializable {

	private String name, description;
	private int amount;
	private boolean usable;

	private Array<String> targets;

	private final String NAME = "name";
	private final String DESC = "description";
	private final String AMT = "amount";
	private final String USBL = "usable";

	public AbstractConsumable(String name) {
		name(name);
		usable = false;
		targets = new Array<String>();
	}

	@Override
	public Consumable name(String name) {
		this.name = name;
		return this;
	}

	@Override
	public Consumable description(String description) {
		this.description = description;
		return this;
	}

	@Override
	public Consumable amount(int amount) {
		this.amount = amount;
		return this;
	}

	@Override
	public Consumable target(String target) {
		this.targets.add(target);
		return this;
	}

	@Override
	public Consumable usable(boolean usable) {
		this.usable = usable;
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public int getAmount() {
		return amount;
	}

	@Override
	public Array<String> getTargets() {
		return targets;
	}

	@Override
	public boolean isUsable() {
		return usable;
	}

	@Override
	public void write(Json json) {
		json.writeValue(NAME, name);
		json.writeValue(DESC, description);
		json.writeValue(AMT, amount);
		json.writeValue(USBL, usable);
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		JsonValue child = jsonData.child;

		name(child.getString(NAME));
		description(child.getString(DESC));
		amount(child.getInt(AMT));
		usable(child.getBoolean(USBL));
	}

}
