package com.soginteractive.engine.core.misc.managers;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.core.misc.Requirement;

public class RequirementManager extends AbstractManager {

	private Array<Requirement> requirements;

	public RequirementManager(String path) {
		super(path);
		requirements = new Array<Requirement>();
	}

	public RequirementManager requirement(Requirement requirement) {
		this.requirements.add(requirement);
		return this;
	}

	public Array<Requirement> getRequirements() {
		return requirements;
	}

}
