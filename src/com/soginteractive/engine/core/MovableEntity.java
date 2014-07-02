package com.soginteractive.engine.core;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public interface MovableEntity extends Entity {

	MovableEntity upTexture(String path);

	MovableEntity upTexture(Texture upTexture);

	MovableEntity upRegion(Texture upTexture);

	MovableEntity upRegion(Texture upTexture, int width, int height);

	MovableEntity upRegion(Texture upTexture, int x, int y, int width,
			int height);

	MovableEntity upRegion(TextureRegion upRegion);

	MovableEntity downTexture(String path);

	MovableEntity downTexture(Texture downTexture);

	MovableEntity downRegion(Texture downTexture);

	MovableEntity downRegion(Texture downTexture, int width, int height);

	MovableEntity downRegion(Texture downTexture, int x, int y, int width,
			int height);

	MovableEntity downRegion(TextureRegion downRegion);

	MovableEntity leftTexture(String path);

	MovableEntity leftTexture(Texture leftTexture);

	MovableEntity leftRegion(Texture leftTexture);

	MovableEntity leftRegion(Texture leftTexture, int width, int height);

	MovableEntity leftRegion(Texture leftTexture, int x, int y, int width,
			int height);

	MovableEntity leftRegion(TextureRegion leftRegion);

	MovableEntity rightTexture(String path);

	MovableEntity rightTexture(Texture rightTexture);

	MovableEntity rightRegion(Texture rightTexture);

	MovableEntity rightRegion(Texture rightTexture, int width, int height);

	MovableEntity rightRegion(Texture rightTexture, int x, int y, int width,
			int height);

	MovableEntity rightRegion(TextureRegion rightRegion);

	MovableEntity velocity(float velX, float velY);

	MovableEntity velocityX(float velX);

	MovableEntity velocityY(float velY);

	Texture getUpTexture();

	TextureRegion getUpRegion();

	Texture getDownTexture();

	TextureRegion getDownRegion();

	Texture getLeftTexture();

	TextureRegion getLeftRegion();

	Texture getRightTexture();

	TextureRegion getRightRegion();

	Vector2 getVelocity();

}
