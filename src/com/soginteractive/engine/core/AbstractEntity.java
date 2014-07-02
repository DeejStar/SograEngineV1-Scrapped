package com.soginteractive.engine.core;

import static com.soginteractive.engine.core.util.ScriptUtils.printFloat;
import static com.soginteractive.engine.core.util.ScriptUtils.printString;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.soginteractive.engine.misc.Texture;

public abstract class AbstractEntity implements Entity {

	private String name, path;

	protected Texture texture;
	protected TextureRegion region;

	protected float x, y, width, height;

	private final String NAME = "name";
	private final String X = "posX";
	private final String Y = "posY";
	private final String WID = "width";
	private final String HGHT = "height";

	public AbstractEntity(String name) {
		name(name);
	}

	@Override
	public Entity name(String name) {
		this.name = name;
		return this;
	}

	@Override
	public Entity path(String path) {
		this.path = path;
		return this;
	}

	@Override
	public Entity position(float x, float y) {
		x(x).y(y);
		return this;
	}

	@Override
	public Entity x(float x) {
		this.x = x;
		return this;
	}

	@Override
	public Entity y(float y) {
		this.y = y;
		return this;
	}

	@Override
	public Entity size(float width, float height) {
		width(width).height(height);
		return this;
	}

	@Override
	public Entity width(float width) {
		this.width = width;
		return this;
	}

	@Override
	public Entity height(float height) {
		this.height = height;
		return this;
	}

	@Override
	public void translate(float x, float y) {
		translateX(x);
		translateY(y);
	}

	@Override
	public void translateX(float x) {
		this.x += x;
	}

	@Override
	public void translateY(float y) {
		this.y += y;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public Vector2 getPosition() {
		return new Vector2(x, y);
	}

	@Override
	public Vector2 getSize() {
		return new Vector2(width, height);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

	protected void writeEntityScripts(Json json) {
		json.writeValue(NAME, name);
		json.writeValue(X, x);
		json.writeValue(Y, y);
		json.writeValue(WID, width);
		json.writeValue(HGHT, height);
	}

	protected void readEntityScripts(Json json, JsonValue jsonData) {
		JsonValue child = jsonData.child;

		name(child.getString(NAME));
		x(child.getFloat(X));
		y(child.getFloat(Y));
		width(child.getFloat(WID));
		height(child.getFloat(HGHT));
	}

	public void printJson() {
		printString(NAME, name);
		printFloat(X, x);
		printFloat(Y, y);
		printFloat(WID, width);
		printFloat(HGHT, height);
	}

}
