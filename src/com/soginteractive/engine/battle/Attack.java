package com.soginteractive.engine.battle;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.misc.Cost;

public interface Attack {

	Attack name(String name);

	Attack description(String description);

	Attack type(String type);

	Attack baseDamage(int baseDamage);

	Attack hits(int hits);

	Attack target(String target);

	Attack cost(Cost cost);

	String getName();

	String getDescription();

	String getType();

	int getBaseDamage();

	int getHits();

	Array<String> getTargets();

	Array<Cost> getCosts();
}
