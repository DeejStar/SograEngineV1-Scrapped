package com.soginteractive.engine.menu.entities;

import static com.soginteractive.engine.core.util.ScriptUtils.printBoolean;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.soginteractive.engine.core.entities.Image;
import com.soginteractive.engine.misc.Texture;

public class Background extends Image implements Serializable {

	private boolean stretch;

	private Stage stage;

	private final String OBJ = "Background";
	private final String STRC = "stretch";

	public Background() {
		this("");
	}

	public Background(String name) {
		super(name);
		stretch = false;
	}

	public Background stage(Stage stage) {
		this.stage = stage;
		return this;
	}

	public Background stretch(boolean stretch) {
		this.stretch = stretch;
		return this;
	}

	private void checkSize(Stage stage) {
		if (stretch) {
			position(0, 0).size(stage.getWidth(), stage.getHeight());
		}
	}

	@Override
	public void translate(float translateX, float translateY) {
		translateX(translateX);
		translateY(translateY);
	}

	@Override
	public void translateX(float translateX) {
		sprite.translateX(translateX);
	}

	@Override
	public void translateY(float translateY) {
		sprite.translateY(translateY);
	}

	public boolean isStretched() {
		return stretch;
	}

	public Texture getTexture() {
		return texture;
	}

	public TextureRegion getRegion() {
		return region;
	}

	@Override
	public Sprite getSprite() {
		if (stretch) {
			if (stage != null) {
				checkSize(stage);
			}
		}
		return super.getSprite();
	}

	@Override
	public Actor getActor() {
		return null;
	}

	@Override
	public void write(Json json) {
		json.writeObjectStart(OBJ);
		{
			writeImageScripts(json);
			json.writeValue(STRC, stretch);
		}
		json.writeObjectEnd();
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		JsonValue child = jsonData.child;
		readImageScripts(json, jsonData);
		stretch(child.getBoolean(STRC));
	}

	public void printJson() {
		super.printJson();
		printBoolean(STRC, stretch);
	}

}
