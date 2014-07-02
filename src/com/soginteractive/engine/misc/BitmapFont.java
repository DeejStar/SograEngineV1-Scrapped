package com.soginteractive.engine.misc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class BitmapFont extends com.badlogic.gdx.graphics.g2d.BitmapFont {

	private FileHandle handle;
	private boolean flip;

	public BitmapFont(String fontPath) {
		this(fontPath, false);
	}

	public BitmapFont(String fontPath, boolean flip) {
		this(Gdx.files.internal(fontPath), flip);
	}

	public BitmapFont(FileHandle handle, boolean flip) {
		super(handle, flip);
		handle(handle).flip(flip);
	}

	public BitmapFont handle(FileHandle handle) {
		this.handle = handle;
		return this;
	}

	public BitmapFont flip(boolean flip) {
		this.flip = flip;
		return this;
	}

	public String getFontPath() {
		return handle.path();
	}

	public boolean isFlipped() {
		return flip;
	}

}
