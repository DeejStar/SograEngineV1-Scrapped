package com.soginteractive.engine.misc;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class TextureAtlas extends com.badlogic.gdx.graphics.g2d.TextureAtlas
		implements Serializable {

	private String packPath, imgPath;
	private boolean flip;
	private static Files files = Gdx.files;

	private final String OBJ = "atlas";
	private final String PACK = "packPath";
	private final String IMG = "imgPath";

	public TextureAtlas() {
		this("");
	}

	public TextureAtlas(String packPath) {
		this(packPath, false);
	}

	public TextureAtlas(String packPath, boolean flip) {
		this(files.internal(packPath), flip);
	}

	public TextureAtlas(String packPath, String imgPath) {
		this(packPath, imgPath, false);
	}

	public TextureAtlas(String packPath, String imgPath, boolean flip) {
		this(files.internal(packPath), files.internal(imgPath), flip);
	}

	public TextureAtlas(FileHandle packHandle) {
		this(packHandle, false);
	}

	public TextureAtlas(FileHandle packHandle, boolean flip) {
		this(packHandle, packHandle.parent(), flip);
	}

	public TextureAtlas(FileHandle packHandle, FileHandle imgHandle) {
		this(packHandle, imgHandle, false);
	}

	public TextureAtlas(FileHandle packHandle, FileHandle imgHandle,
			boolean flip) {
		super(packHandle, imgHandle, flip);
		packPath(packHandle.path()).imgPath(imgHandle.path()).flip(flip);
	}

	private TextureAtlas packPath(String packPath) {
		this.packPath = packPath;
		return this;
	}

	private TextureAtlas imgPath(String imgPath) {
		this.imgPath = imgPath;
		return this;
	}

	private TextureAtlas flip(boolean flip) {
		this.flip = flip;
		return this;
	}

	public String getPackPath() {
		return packPath;
	}

	public String getImgPath() {
		return imgPath;
	}

	public boolean isFlipped() {
		return flip;
	}

	@Override
	public void write(Json json) {
		json.writeObjectStart(OBJ);
		{
			json.writeValue(PACK, packPath);
			json.writeValue(IMG, imgPath);
		}
		json.writeObjectEnd();
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		JsonValue child = jsonData.child;
		packPath(PACK);
		imgPath(child.getString(IMG));
	}

}
