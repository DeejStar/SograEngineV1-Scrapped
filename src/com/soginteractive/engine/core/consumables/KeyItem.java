package com.soginteractive.engine.core.consumables;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractConsumable;
import com.soginteractive.engine.core.Event;

public class KeyItem extends AbstractConsumable {

	private Array<Event> events;

	public KeyItem(String name) {
		super(name);
		events = new Array<Event>();
	}

	public KeyItem event(Event event) {
		this.events.add(event);
		return this;
	}

	public Array<Event> getEvents() {
		return events;
	}

}
