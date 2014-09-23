package com.soginteractive.engine.core.misc.managers;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.core.misc.Target;

public class TargetManager extends AbstractManager {

	private Array<Target> targets;

	public TargetManager(String path) {
		super(path);
		this.targets = new Array<Target>();
	}

	public TargetManager target(Target target) {
		this.targets.add(target);
		return this;
	}

	public Array<Target> getTargets() {
		return targets;
	}

}
