package com.soginteractive.engine.core;

import com.badlogic.gdx.utils.Array;

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

	@Override
	public void writeAllScripts() {

	}

	@Override
	public void writeScript(Scripter writer) {

	}

	@Override
	public void writeScript(Scripter writer, Object object) {

	}

	@Override
	public void readAllScripts() {

	}

	@Override
	public void readScript(Scripter reader) {

	}

	@Override
	public void readScript(Scripter reader, Object object) {

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
