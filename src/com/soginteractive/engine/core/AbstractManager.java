package com.soginteractive.engine.core;

import java.util.UUID;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.soginteractive.editor.util.ScriptWriter;
import com.soginteractive.engine.core.util.ScriptReader;

public abstract class AbstractManager implements Manager {

	protected String path;

	protected Array<Scripter> writers;
	protected Array<Scripter> readers;
	protected Array<UUID> uuids;
	protected Array<Manager> managers;

	public AbstractManager(String path) {
		path(path);
		writers = new Array<Scripter>();
		readers = new Array<Scripter>();
		uuids = new Array<UUID>();
		managers = new Array<Manager>();
	}

	@Override
	public Manager path(String path) {
		this.path = path;
		checkPath();
		return this;
	}
	
	@Override
	public Manager manager(Manager manager) {
		this.managers.add(manager);
		return this;
	}

	private void checkPath() {
		if (!path.endsWith("/") || !path.endsWith("\\")) {
			path = path.concat("/");
		}
	}

	@Override
	public Manager writer(Scripter writer) {
		writers.add(writer);
		return this;
	}

	@Override
	public Manager reader(Scripter reader) {
		readers.add(reader);
		return this;
	}

	/**
	 * This is left empty due to how each manager will write their scripts; But,
	 * some managers might not use any scripts at all.
	 */
	@Override
	public void writeAllScripts() {
		writeAllScripts(new Json());
	}

	@Override
	public void writeAllScripts(Json json) {
		writeAllScripts(json, false);
	}

	@Override
	public void writeAllScripts(Json json, boolean append) {

	}

	@Override
	public void writeScript(Scripter writer, Object object) {
		if (writer != null && writer instanceof ScriptWriter) {
			writeScript(writer, new Json(), object);
		}
	}

	@Override
	public void writeScript(Scripter writer, Json json, Object object) {
		writeScript(writer, json, object, false);
	}

	@Override
	public void writeScript(Scripter writer, Json json, Object object,
			boolean append) {
		((ScriptWriter) writer).writeScriptFile(json, object, append);
	}

	/**
	 * Write script only if its source contains a specific unique ID
	 */
	@Override
	public void writeScript(UUID uuid) {

	}

	@Override
	public void readAllScripts() {
		for (int i = 0; i < readers.size; i++) {
			readScript(readers.get(i));
		}
	}

	@Override
	public void readScript(Scripter reader) {
		if (reader != null && reader instanceof ScriptReader) {
			((ScriptReader) reader).readScriptFile();
		}
	}

	/**
	 * This is used to read script files based on their unique IDs.
	 */
	@Override
	public void readScript(UUID uuid) {

	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public Array<Scripter> getWriters() {
		return writers;
	}

	@Override
	public Array<Scripter> getReaders() {
		return readers;
	}

	@Override
	public Array<UUID> getUUIDs() {
		return uuids;
	}

	@Override
	public Array<Manager> getManagers() {
		return managers;
	}

	protected void checkPath(Manager manager) {
		path = path.concat(manager.getPath());
	}

	protected void checkObjectForWriting(Scripter writer, Json json,
			Object object) {
		checkObjectForWriting(writer, json, object, false);
	}

	protected void checkObjectForWriting(Scripter writer, Json json,
			Object object, boolean append) {
		if (object != null) {
			writeScript(writer, json, object, append);
		}
	}

	protected void checkManagersForWriting(Json json) {
		for (int i = 0; i < managers.size; i++) {
			checkManagerForWriting(managers.get(i), json);
		}
	}

	protected void checkManagerForWriting(Manager manager, Json json) {
		checkManagerForWriting(manager, json, false);
	}

	protected void checkManagerForWriting(Manager manager, Json json,
			boolean append) {
		if (manager != null) {
			manager.writeAllScripts(json, append);
		}
	}
}
