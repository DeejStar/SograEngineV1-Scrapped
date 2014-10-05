package com.soginteractive.engine.battle;

import static com.soginteractive.engine.core.util.ScriptUtils.createArrayFromJson;
import static com.soginteractive.engine.core.util.ScriptUtils.printInt;
import static com.soginteractive.engine.core.util.ScriptUtils.printString;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.soginteractive.engine.core.misc.Cost;
import com.soginteractive.engine.core.misc.Target;

public abstract class AbstractAttack implements Attack, Serializable {

	private String name, description, type;
	private int baseDamage, hits;

	private Array<Target> targets;
	private Array<Cost> costs;

	private final String NAME = "name";
	private final String DESC = "description";
	private final String TYPE = "type";
	private final String BDMG = "base damage";
	private final String HITS = "hits";
	private final String TGTS = "targets";
	private final String CSTS = "costs";

	protected AbstractAttack(String name) {
		name(name);
		targets = new Array<Target>();
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
	public Attack target(Target target) {
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
	public Array<Target> getTargets() {
		return targets;
	}

	@Override
	public Array<Cost> getCosts() {
		return costs;
	}

	@Override
	public void write(Json json) {
		json.writeValue(NAME, name);
		json.writeValue(DESC, description);
		json.writeValue(TYPE, type);
		json.writeValue(BDMG, baseDamage);
		json.writeValue(HITS, hits);
		json.writeValue(TGTS, targets);
		json.writeValue(CSTS, costs);
	}

	@Override
	public void read(Json json, JsonValue value) {
		JsonValue child = value.child;
		name(child.getString(NAME));
		description(child.getString(description));
		type(child.getString(TYPE));
		baseDamage(child.getInt(BDMG));
		hits(child.getInt(HITS));
		createArrayFromJson(TGTS, json, child, targets);
		createArrayFromJson(CSTS, json, child, costs);
	}

	@Override
	public void printJson() {
		printString(NAME, name);
		printString(DESC, description);
		printString(TYPE, type);
		printInt(BDMG, baseDamage);
		printInt(HITS, hits);

		for (int i = 0; i < targets.size; i++) {
			Target target = targets.get(i);
			target.printJson();
		}

		for (int i = 0; i < costs.size; i++) {
			Cost cost = costs.get(i);
			cost.printJson();
		}
	}

}
