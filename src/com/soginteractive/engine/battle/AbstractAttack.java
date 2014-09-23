package com.soginteractive.engine.battle;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.misc.Cost;

public abstract class AbstractAttack implements Attack {

	private String name, description, type;
	private int baseDamage, hits;

	private Array<String> targets;
	private Array<Cost> costs;

	protected AbstractAttack(String name) {
		name(name);
		targets = new Array<String>();
		costs = new Array<Cost>();
	}

	@Override
	public Attack name(String name) {
		this.name = name;
		return this;
	}

	@Override
	public Attack description(String description) {
		this.description = description;
		return this;
	}

	@Override
	public Attack type(String type) {
		this.type = type;
		return this;
	}

	@Override
	public Attack baseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
		return this;
	}

	@Override
	public Attack hits(int hits) {
		this.hits = hits;
		return this;
	}

	@Override
	public Attack target(String target) {
		this.targets.add(target);
		return this;
	}

	@Override
	public Attack cost(Cost cost) {
		this.costs.add(cost);
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return (description != null ? description : "");
	}

	@Override
	public String getType() {
		return (type != null ? type : "");
	}

	@Override
	public int getBaseDamage() {
		return baseDamage;
	}

	@Override
	public int getHits() {
		return hits;
	}

	@Override
	public Array<String> getTargets() {
		return targets;
	}

	@Override
	public Array<Cost> getCosts() {
		return costs;
	}

}
