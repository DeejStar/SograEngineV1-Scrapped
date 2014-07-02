package com.soginteractive.engine.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public abstract class AbstractScripter implements Scripter {

	protected FileHandle handle;

	public AbstractScripter(String path) {
		this(Gdx.files.internal(path));
	}

	public AbstractScripter(FileHandle handle) {
		handle(handle);
	}

	@Override
	public Scripter handle(FileHandle handle) {
		this.handle = handle;
		return this;
	}

	@Override
	public FileHandle getHandle() {
		return handle;
	}

	@Override
	public String getPath() {
		return handle.path();
	}

	@Override
	public String getParentPath() {
		return (handle.parent().path().concat("/"));
	}

}
