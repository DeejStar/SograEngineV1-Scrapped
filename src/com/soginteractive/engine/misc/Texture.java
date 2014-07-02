package com.soginteractive.engine.misc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Texture extends com.badlogic.gdx.graphics.Texture {

	private String path;

	public Texture(String path) {
		this(Gdx.files.internal(path));
	}

	public Texture(FileHandle handle) {
		super(handle);
		path(handle.path());
	}

	private Texture path(String path) {
		this.path = path;
		return this;
	}

	public String getPath() {
		return path;
	}

}
