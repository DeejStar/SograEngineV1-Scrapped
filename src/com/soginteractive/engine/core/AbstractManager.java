package com.soginteractive.engine.core;

public abstract class AbstractManager implements Manager {

	protected String path;

	public AbstractManager(String path) {
		path(path);
	}

	@Override
	public Manager path(String path) {
		this.path = path;
		checkPath();
		return this;
	}

	private void checkPath() {
		if (!path.endsWith("/")) {
			path = path.concat("/");
		}
	}

	@Override
	public String getPath() {
		return path;
	}

	protected void checkPath(Manager manager) {
		path = path.concat(manager.getPath());
	}

}
