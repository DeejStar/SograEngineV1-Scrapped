package com.soginteractive.engine.core.misc.managers;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.core.misc.Effect;

public class EffectManager extends AbstractManager {

	private Array<Effect> effects;

	public EffectManager(String path) {
		super(path);
		effects = new Array<Effect>();
	}

	public EffectManager effect(Effect effect) {
		this.effects.add(effect);
		return this;
	}

	public Array<Effect> getEffects() {
		return effects;
	}

}
