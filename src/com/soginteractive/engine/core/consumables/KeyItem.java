package com.soginteractive.engine.core.consumables;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractConsumable;
import com.soginteractive.engine.core.Event1;

public class KeyItem extends AbstractConsumable {

	private Array<Event1> events;

	public KeyItem(String name) {
		super(name);
		events = new Array<Event1>();
	}

	public KeyItem event(Event1 event) {
		this.events.add(event);
		return this;
	}

	public Array<Event1> getEvents() {
		return events;
	}

}
