package com.soginteractive.editor.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.soginteractive.engine.core.AbstractScreen;
import com.soginteractive.engine.menu.entities.Background;

public class MainScreen extends AbstractScreen {
	private Background background, background2;

	public static boolean EDITOR_DEV_MODE = false;

	public MainScreen(Game game, float width, float height,
			boolean keepAspectRatio, Batch batch) {
		super(game, width, height, keepAspectRatio, batch);
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		addProcessor();

		stage.act(delta);
		stage.draw();

		batch.begin();
		{

		}
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height);
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		stage.dispose();
		background.getTexture().dispose();
		background2.getTexture().dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.D) {
			background.x(background.getPosition().x
					+ Gdx.graphics.getDeltaTime() * 100);
			System.out.println(background.getPosition().x);
			return true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		touchDragged(screenX, screenY, pointer);
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		if (screenX >= background2.getPosition().x
				&& screenX <= (background2.getPosition().x + background2
						.getSize().x)
				&& screenY >= (stage.getHeight() - background2.getPosition().y - background2
						.getSize().y)
				&& screenY <= (stage.getHeight() - background2.getPosition().y)) {
			System.out.println("Clicked at " + screenX + ":" + screenY);
			background2.x(screenX).y(stage.getHeight() - screenY);
			return true;
		}
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
