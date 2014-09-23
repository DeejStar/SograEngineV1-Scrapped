package com.soginteractive.engine.core.consumables;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractConsumable;
import com.soginteractive.engine.core.misc.Restore;

public class RestorativeItem extends AbstractConsumable {

	private Array<Restore> restores;

	public RestorativeItem(String name) {
		super(name);
		restores = new Array<Restore>();
	}

	public RestorativeItem restores(Restore restore) {
		restores.add(restore);
		return this;
	}

	public Array<Restore> getRestores() {
		return restores;
	}

}
