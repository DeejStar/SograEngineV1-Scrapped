package com.soginteractive.engine.core.misc.managers;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.core.misc.Destroy;

public class DestroyManager extends AbstractManager {

	private Array<Destroy> destroys;

	public DestroyManager(String path) {
		super(path);
		this.destroys = new Array<Destroy>();
	}

	public DestroyManager destroy(Destroy destroy) {
		destroys.add(destroy);
		return this;
	}

	public Array<Destroy> getDestroys() {
		return destroys;
	}
}
