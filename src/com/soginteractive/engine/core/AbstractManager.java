package com.soginteractive.engine.core;

import java.util.UUID;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.util.ScriptReader;

public abstract class AbstractManager implements Manager {

	protected String path;

	protected Array<Scripter> writers;
	protected Array<Scripter> readers;

	public AbstractManager(String path) {
		path(path);
		writers = new Array<Scripter>();
		readers = new Array<Scripter>();
	}

	@Override
	public Manager path(String path) {
		this.path = path;
		checkPath();
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
	 * All of these are left empty due to how each manager will write their scripts;
	 * But, some managers might not use any scripts at all.
	 */
	@Override
	public void writeAllScripts() {
		
	}

	@Override
	public void writeScript(Scripter writer) {

	}

	@Override
	public void writeScript(Scripter writer, UUID uuid) {

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
			readScript(reader, null);
		}
	}

	/**
	 * This is used to read script files based on their unique IDs.
	 */
	@Override
	public void readScript(Scripter reader, UUID uuid) {
		if (uuid == null) {
			((ScriptReader) reader).readScriptFile();
		}

		else {
			((ScriptReader) reader).readScriptFile(uuid);
		}
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

	protected void checkPath(Manager manager) {
		path = path.concat(manager.getPath());
	}

}
