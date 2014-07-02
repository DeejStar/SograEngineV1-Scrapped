package com.soginteractive.engine.core;

import com.badlogic.gdx.utils.Array;

public abstract class AbstractConsumable implements Consumable {

	private String name, description;
	private int amount;
	private boolean usable;

	private Array<String> targets;

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
	public Consumable targets(String... targets) {
		this.targets.addAll(targets);
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

}
