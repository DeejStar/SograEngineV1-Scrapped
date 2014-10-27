package com.soginteractive.engine.core;

import static com.soginteractive.engine.core.util.ScriptUtils.createArrayFromJson;
import static com.soginteractive.engine.core.util.ScriptUtils.printString;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.soginteractive.engine.core.misc.Effect;
import com.soginteractive.engine.core.misc.Element;
import com.soginteractive.engine.core.misc.Modifier;
import com.soginteractive.engine.core.misc.Requirement;
import com.soginteractive.engine.core.misc.Restriction;

public abstract class AbstractEquipment implements Equipment, Serializable {

	protected String name, description, type, location;
	protected String path;
	protected Array<Requirement> requirements;
	protected Array<Modifier> modifiers;
	protected Array<Restriction> restrictions;
	protected Array<Element> elements;
	protected Array<Effect> effects;

	private final String NAME = "name";
	private final String DESC = "description";
	private final String TYPE = "type";
	private final String LOC = "location";
	private final String REQS = "requirements";
	private final String MODS = "modifiers";
	private final String RESTS = "restrictions";
	private final String ELMNS = "elements";
	private final String EFCTS = "effects";

	protected AbstractEquipment(String name) {
		name(name);
		requirements = new Array<Requirement>();
		modifiers = new Array<Modifier>();
		restrictions = new Array<Restriction>();
		elements = new Array<Element>();
		effects = new Array<Effect>();
	}

	@Override
	public Equipment name(String name) {
		this.name = name;
		return null;
	}

	@Override
	public Equipment description(String description) {
		this.description = description;
		return this;
	}

	@Override
	public Equipment type(String type) {
		this.type = type;
		return this;
	}

	@Override
	public Equipment location(String location) {
		this.location = location;
		return this;
	}

	@Override
	public Equipment requirement(Requirement requirement) {
		requirements.add(requirement);
		return this;
	}

	@Override
	public Equipment modifier(Modifier modifier) {
		modifiers.add(modifier);
		return this;
	}

	@Override
	public Equipment restriction(Restriction restriction) {
		restrictions.add(restriction);
		return this;
	}

	@Override
	public Equipment element(Element element) {
		elements.add(element);
		return this;
	}

	@Override
	public Equipment effect(Effect effect) {
		effects.add(effect);
		return this;
	}

	@Override
	public Equipment path(String path) {
		this.path = path;
		return this;
	}

	@Override
	public Equipment requirementPath(Requirement requirement, String reqPath) {

		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getLocation() {
		return location;
	}

	@Override
	public Array<Requirement> getRequirements() {
		return requirements;
	}

	@Override
	public Array<Modifier> getModifiers() {
		return modifiers;
	}

	@Override
	public Array<Restriction> getRestrictions() {
		return restrictions;
	}

	@Override
	public Array<Element> getElements() {
		return elements;
	}

	@Override
	public Array<Effect> getEffects() {
		return effects;
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public String getRequirementName(Requirement requirement) {
		return "";
	}

	@Override
	public void write(Json json) {
		json.writeValue(NAME, name);
		json.writeValue(DESC, description);
		json.writeValue(TYPE, type);
		json.writeValue(LOC, location);
		json.writeValue(REQS, requirements);
		json.writeValue(MODS, modifiers);
		json.writeValue(RESTS, restrictions);
		json.writeValue(ELMNS, elements);
		json.writeValue(EFCTS, effects);
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		JsonValue child = jsonData.child;
		name(child.getString(NAME));
		description(child.getString(DESC));
		type(child.getString(TYPE));
		location(child.getString(LOC));

		createArrayFromJson(REQS, json, child, requirements);
		createArrayFromJson(MODS, json, child, modifiers);
		createArrayFromJson(RESTS, json, child, restrictions);
		createArrayFromJson(ELMNS, json, child, elements);
		createArrayFromJson(EFCTS, json, child, effects);

	}

	@Override
	public void printJson() {
		printString(NAME, name);
		printString(DESC, description);
		printString(TYPE, type);
		printString(LOC, location);

		for (int i = 0; i < requirements.size; i++) {
			Requirement requirement = requirements.get(i);
			requirement.printJson();
		}

		for (int i = 0; i < modifiers.size; i++) {
			Modifier modifier = modifiers.get(i);
			modifier.printJson();
		}

		for (int i = 0; i < restrictions.size; i++) {
			Restriction restriction = restrictions.get(i);
			restriction.printJson();
		}

		for (int i = 0; i < elements.size; i++) {
			Element element = elements.get(i);
			element.printJson();
		}

		for (int i = 0; i < effects.size; i++) {
			Effect effect = effects.get(i);
			effect.printJson();
		}

	}

}
