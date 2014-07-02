package com.soginteractive.engine.core.misc.managers;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.core.misc.Modifier;

public class ModifierManager extends AbstractManager {

	private Array<Modifier> modifiers;

	public ModifierManager(String path) {
		super(path);
		modifiers = new Array<Modifier>();
	}

	public ModifierManager modifier(Modifier modifier) {
		this.modifiers.add(modifier);
		return this;
	}

	public Array<Modifier> getModifiers() {
		return modifiers;
	}

}
