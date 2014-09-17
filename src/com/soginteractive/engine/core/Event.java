package com.soginteractive.engine.core;

public interface Event {

	Event name(String name);

	Event description(String description);

	String getName();

	String getDescription();

}
