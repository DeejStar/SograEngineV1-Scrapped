package com.soginteractive.engine.core;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public abstract class AbstractMovableEntity extends AbstractEntity implements
		MovableEntity {

	protected Texture upTexture, downTexture, leftTexture, rightTexture;
	protected TextureRegion upRegion, downRegion, leftRegion, rightRegion;

	private float velX, velY;

	public AbstractMovableEntity(String name) {
		super(name);
	}

	@Override
	public MovableEntity upTexture(String path) {
		upTexture(new Texture(path));
		return this;
	}

	@Override
	public MovableEntity upTexture(Texture upTexture) {
		this.upTexture = upTexture;
		upRegion(upTexture);
		return this;
	}

	@Override
	public MovableEntity upRegion(Texture upTexture) {
		upRegion(upTexture, upTexture.getWidth(), upTexture.getHeight());
		return this;
	}

	@Override
	public MovableEntity upRegion(Texture upTexture, int width, int height) {
		upRegion(upTexture, 0, 0, width, height);
		return this;
	}

	@Override
	public MovableEntity upRegion(Texture upTexture, int x, int y, int width,
			int height) {
		upRegion(new TextureRegion(upTexture, x, y, width, height));
		return this;
	}

	@Override
	public MovableEntity upRegion(TextureRegion upRegion) {
		this.upRegion = upRegion;
		return this;
	}

	@Override
	public MovableEntity downTexture(String path) {
		downTexture(new Texture(path));
		return this;
	}

	@Override
	public MovableEntity downTexture(Texture downTexture) {
		this.downTexture = downTexture;
		downRegion(downTexture);
		return this;
	}

	@Override
	public MovableEntity downRegion(Texture downTexture) {
		downRegion(downTexture, downTexture.getWidth(), downTexture.getHeight());
		return this;
	}

	@Override
	public MovableEntity downRegion(Texture downTexture, int width, int height) {
		downRegion(downTexture, 0, 0, width, height);
		return this;
	}

	@Override
	public MovableEntity downRegion(Texture downTexture, int x, int y,
			int width, int height) {
		downRegion(new TextureRegion(downTexture, x, y, width, height));
		return this;
	}

	@Override
	public MovableEntity downRegion(TextureRegion downRegion) {
		this.downRegion = downRegion;
		return this;
	}

	@Override
	public MovableEntity leftTexture(String path) {
		leftTexture(new Texture(path));
		return this;
	}

	@Override
	public MovableEntity leftTexture(Texture leftTexture) {
		this.leftTexture = leftTexture;
		leftRegion(leftTexture);
		return this;
	}

	@Override
	public MovableEntity leftRegion(Texture leftTexture) {
		leftRegion(leftTexture, leftTexture.getWidth(), leftTexture.getHeight());
		return this;
	}

	@Override
	public MovableEntity leftRegion(Texture leftTexture, int width, int height) {
		leftRegion(leftTexture, 0, 0, width, height);
		return this;
	}

	@Override
	public MovableEntity leftRegion(Texture leftTexture, int x, int y,
			int width, int height) {
		leftRegion(new TextureRegion(leftTexture, x, y, width, height));
		return this;
	}

	@Override
	public MovableEntity leftRegion(TextureRegion leftRegion) {
		this.leftRegion = leftRegion;
		return this;
	}

	@Override
	public MovableEntity rightTexture(String path) {
		rightTexture(new Texture(path));
		return this;
	}

	@Override
	public MovableEntity rightTexture(Texture rightTexture) {
		this.rightTexture = rightTexture;
		rightRegion(rightTexture);
		return this;
	}

	@Override
	public MovableEntity rightRegion(Texture rightTexture) {
		rightRegion(rightTexture, rightTexture.getWidth(),
				rightTexture.getHeight());
		return this;
	}

	@Override
	public MovableEntity rightRegion(Texture rightTexture, int width, int height) {
		rightRegion(rightTexture, 0, 0, width, height);
		return this;
	}

	@Override
	public MovableEntity rightRegion(Texture rightTexture, int x, int y,
			int width, int height) {
		rightRegion(new TextureRegion(rightTexture, x, y, width, height));
		return this;
	}

	@Override
	public MovableEntity rightRegion(TextureRegion rightRegion) {
		this.rightRegion = rightRegion;
		return this;
	}

	@Override
	public MovableEntity velocity(float velX, float velY) {
		velocityX(velX).velocityY(velY);
		return this;
	}

	@Override
	public MovableEntity velocityX(float velX) {
		this.velX = velX;
		return this;
	}

	@Override
	public MovableEntity velocityY(float velY) {
		this.velY = velY;
		return this;
	}

	@Override
	public Texture getUpTexture() {
		return upTexture;
	}

	@Override
	public TextureRegion getUpRegion() {
		return upRegion;
	}

	@Override
	public Texture getDownTexture() {
		return downTexture;
	}

	@Override
	public TextureRegion getDownRegion() {
		return downRegion;
	}

	@Override
	public Texture getLeftTexture() {
		return leftTexture;
	}

	@Override
	public TextureRegion getLeftRegion() {
		return leftRegion;
	}

	@Override
	public Texture getRightTexture() {
		return rightTexture;
	}

	@Override
	public TextureRegion getRightRegion() {
		return rightRegion;
	}

	@Override
	public Vector2 getVelocity() {
		return new Vector2(velX, velY);
	}

}
