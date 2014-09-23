package com.soginteractive.engine.core.misc.managers;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.core.misc.Restore;

public class RestoreManager extends AbstractManager {
	private Array<Restore> restores;

	public RestoreManager(String path) {
		super(path);
		this.restores = new Array<Restore>();
	}

	public RestoreManager Restore(Restore restore) {
		restores.add(restore);
		return this;
	}

	public Array<Restore> getRestores() {
		return restores;
	}

}
