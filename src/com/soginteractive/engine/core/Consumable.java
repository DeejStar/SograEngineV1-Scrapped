package com.soginteractive.engine.core;

import com.badlogic.gdx.utils.Array;

public interface Consumable {

	Consumable name(String name);

	Consumable description(String description);

	Consumable amount(int amount);

	Consumable target(String target);

	Consumable usable(boolean usable);

	String getName();

	String getDescription();

	int getAmount();

	Array<String> getTargets();

	boolean isUsable();

}
