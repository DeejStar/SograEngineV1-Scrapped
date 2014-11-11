package com.soginteractive.engine.core;

import java.util.UUID;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

public interface Manager {

	Manager path(String path);

	abstract Manager writer(Scripter writer);

	abstract Manager reader(Scripter reader);

	abstract void writeAllScripts();

	abstract void writeScript(Scripter writer, Object object);

	abstract void writeScript(Scripter writer, Json json, Object object);

	abstract void writeScript(Scripter writer, Json json, Object object,
			boolean append);

	abstract void writeScript(UUID uuid);

	abstract void readAllScripts();

	abstract void readScript(Scripter reader);

	abstract void readScript(UUID uuid);

	String getPath();

	abstract Array<Scripter> getWriters();

	abstract Array<Scripter> getReaders();

	abstract Array<UUID> getUUIDs();

}
