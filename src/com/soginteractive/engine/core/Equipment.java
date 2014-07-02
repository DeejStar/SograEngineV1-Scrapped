package com.soginteractive.engine.core;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.misc.Effect;
import com.soginteractive.engine.core.misc.Element;
import com.soginteractive.engine.core.misc.Modifier;
import com.soginteractive.engine.core.misc.Requirement;
import com.soginteractive.engine.core.misc.Restriction;

public interface Equipment {

	Equipment name(String name);

	Equipment description(String description);

	Equipment type(String type);

	Equipment location(String location);

	Equipment requirement(Requirement requirement);

	Equipment modifier(Modifier modifier);

	Equipment restriction(Restriction restriction);

	Equipment element(Element element);

	Equipment effect(Effect effect);

	String getName();

	String getDescription();

	String getType();

	String getLocation();

	Array<Requirement> getRequirements();

	Array<Modifier> getModifiers();

	Array<Restriction> getRestrictions();

	Array<Element> getElements();

	Array<Effect> getEffects();
	
	void printJson();

}
