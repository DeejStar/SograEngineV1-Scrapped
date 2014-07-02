package com.soginteractive.engine.field.misc.manager;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;

public class EventManager extends AbstractManager {

	private Array<Event> events;

	public EventManager(String path) {
		super(path);
		events = new Array<Event>();
	}

	public EventManager event(Event event) {
		this.events.add(event);
		return this;
	}

	public Array<Event> getEvents() {
		return events;
	}

}
