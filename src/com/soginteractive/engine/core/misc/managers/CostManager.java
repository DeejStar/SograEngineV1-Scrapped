package com.soginteractive.engine.core.misc.managers;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.core.misc.Cost;

public class CostManager extends AbstractManager {

	private Array<Cost> costs;

	public CostManager(String path) {
		super(path);
		this.costs = new Array<Cost>();
	}

	public CostManager cost(Cost cost) {
		costs.add(cost);
		return this;
	}

	public Array<Cost> getCosts() {
		return costs;
	}

}
