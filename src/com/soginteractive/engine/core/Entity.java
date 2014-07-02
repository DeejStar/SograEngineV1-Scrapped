package com.soginteractive.engine.core;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public interface Entity {

	Entity name(String name);

	Entity path(String path);

	Entity position(float x, float y);

	Entity x(float x);

	Entity y(float y);

	Entity size(float width, float height);

	Entity width(float width);

	Entity height(float height);

	void translate(float x, float y);

	void translateX(float x);

	void translateY(float y);

	String getName();

	String getPath();

	Vector2 getPosition();

	Vector2 getSize();

	Rectangle getBounds();

	Actor getActor();

}
