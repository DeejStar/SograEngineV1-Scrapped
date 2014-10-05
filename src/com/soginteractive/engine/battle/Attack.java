package com.soginteractive.engine.battle;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.misc.Cost;
import com.soginteractive.engine.core.misc.Target;

public interface Attack {

	Attack name(String name);

	Attack description(String description);

	Attack type(String type);

	Attack baseDamage(int baseDamage);

	Attack hits(int hits);

	Attack target(Target target);

	Attack cost(Cost cost);

	String getName();

	String getDescription();

	String getType();

	int getBaseDamage();

	int getHits();

	Array<Target> getTargets();

	Array<Cost> getCosts();

	void printJson();

}
