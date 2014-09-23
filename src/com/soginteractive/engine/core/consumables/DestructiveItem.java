package com.soginteractive.engine.core.consumables;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractConsumable;
import com.soginteractive.engine.core.misc.Destroy;

public class DestructiveItem extends AbstractConsumable {

	private float hitChance;

	private Array<Destroy> destroys;

	public DestructiveItem(String name) {
		super(name);
		destroys = new Array<Destroy>();
	}

	public DestructiveItem hitChance(float hitChance) {
		this.hitChance = hitChance;
		return this;
	}

	public DestructiveItem destroy(Destroy destroy) {
		destroys.add(destroy);
		return this;
	}

	public float getHitChance() {
		return hitChance;
	}

	public Array<Destroy> getDestroys() {
		return destroys;
	}

}
