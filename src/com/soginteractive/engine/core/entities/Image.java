package com.soginteractive.engine.core.entities;

import static com.soginteractive.engine.core.util.ScriptUtils.printString;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.soginteractive.engine.core.AbstractEntity;
import com.soginteractive.engine.core.Entity;
import com.soginteractive.engine.misc.Texture;

public abstract class Image extends AbstractEntity {

	protected String texturePath;

	protected Texture texture;
	protected TextureRegion region;
	protected Sprite sprite;

	private final String TXTP = "texturePath";

	public Image(String name) {
		super(name);
	}

	public Entity texture(String path) {
		texture(new Texture(path));
		return this;
	}

	public Entity texture(Texture texture) {
		this.texture = texture;
		texturePath(texture.getPath());
		region(texture);
		return this;
	}

	private Entity texturePath(String texturePath) {
		this.texturePath = texturePath;
		return this;
	}

	public Entity region(Texture texture) {
		region(texture, texture.getWidth(), texture.getHeight());
		return this;
	}

	public Entity region(Texture texture, int width, int height) {
		region(texture, 0, 0, width, height);
		return this;
	}

	public Entity region(Texture texture, int x, int y, int width, int height) {
		region(new TextureRegion(texture, x, y, width, height));
		return this;
	}

	public Entity region(TextureRegion region) {
		this.region = region;
		sprite(region);
		return this;
	}

	public Entity sprite(Texture texture) {
		sprite(new TextureRegion(texture));
		return this;
	}

	public Entity sprite(TextureRegion region) {
		sprite(new Sprite(region));
		return this;
	}

	public Entity sprite(Sprite sprite) {
		this.sprite = sprite;
		return this;
	}

	public Texture getTexture() {
		return texture;
	}

	public TextureRegion getRegion() {
		return region;
	}

	public Sprite getSprite() {
		sprite.setBounds(x, y, width, height);
		return sprite;
	}

	@Override
	public void write(Json json) {
		super.write(json);
		json.writeValue(TXTP, texturePath);
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		JsonValue child = jsonData.child;
		super.read(json, jsonData);
		texture(child.getString(TXTP));
	}

	public void printJson() {
		super.printJson();
		printString(TXTP, texturePath);
	}

}
