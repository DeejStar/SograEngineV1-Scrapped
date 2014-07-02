package com.soginteractive.engine.core.consumables;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.battle.misc.Destroy;
import com.soginteractive.engine.core.AbstractConsumable;

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

	public DestructiveItem destroys(Destroy... destroys) {
		this.destroys.addAll(destroys);
		return this;
	}

	public float getHitChance() {
		return hitChance;
	}

	public Array<Destroy> getDestroys() {
		return destroys;
	}

}
