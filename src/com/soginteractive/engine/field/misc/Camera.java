package com.soginteractive.engine.field.misc;

import com.badlogic.gdx.math.Vector2;

public class Camera {

	private String name;
	private float x, y;
	private float offsetX, offsetY;
	private float scaleX, scaleY;

	public Camera() {
		this("");
	}

	public Camera(String name) {
		name(name);
	}

	public Camera name(String name) {
		this.name = name;
		return this;
	}

	public Camera position(float x, float y) {
		x(x).y(y);
		return this;
	}

	public Camera x(float x) {
		this.x = x;
		return this;
	}

	public Camera y(float y) {
		this.y = y;
		return this;
	}

	public Camera offsetX(float offsetX) {
		this.offsetX = offsetX;
		return this;
	}

	public Camera offsetY(float offsetY) {
		this.offsetY = offsetY;
		return this;
	}

	public Camera scaleX(float scaleX) {
		this.scaleX = scaleX;
		return this;
	}

	public Camera scaleY(float scaleY) {
		this.scaleY = scaleY;
		return this;
	}

	public String getName() {
		return name;
	}

	public Vector2 getPosition() {
		return new Vector2(x, y);
	}

	public float getOffsetX() {
		return offsetX;
	}

	public float getOffsetY() {
		return offsetY;
	}

	public float getScaleX() {
		return scaleX;
	}

	public float getScaleY() {
		return scaleY;
	}

}
