package com.soginteractive.engine.core.misc.managers;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.core.misc.Restriction;

public class RestrictionManager extends AbstractManager {

	private Array<Restriction> restrictions;

	public RestrictionManager(String path) {
		super(path);
		restrictions = new Array<Restriction>();
	}

	public RestrictionManager restriction(Restriction restriction) {
		this.restrictions.add(restriction);
		return this;
	}

	public Array<Restriction> getRestrictions() {
		return restrictions;
	}

}
