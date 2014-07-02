package com.soginteractive.engine.core.consumables;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.battle.misc.Restore;
import com.soginteractive.engine.core.AbstractConsumable;

public class RestorativeItem extends AbstractConsumable {

	private Array<Restore> restores;

	public RestorativeItem(String name) {
		super(name);
		restores = new Array<Restore>();
	}

	public RestorativeItem restores(Restore... restores) {
		this.restores.addAll(restores);
		return this;
	}

	public Array<Restore> getRestores() {
		return restores;
	}

}
