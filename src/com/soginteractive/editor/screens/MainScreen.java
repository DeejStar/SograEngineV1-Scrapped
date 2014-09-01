package com.soginteractive.editor.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.soginteractive.engine.core.AbstractScreen;
import com.soginteractive.engine.menu.entities.Background;

public class MainScreen extends AbstractScreen {

	public static boolean EDITOR_DEV_MODE = false;

	private Background logo;

	public MainScreen(Game game, float width, float height,
			boolean keepAspectRatio, Batch batch) {
		super(game, width, height, keepAspectRatio, batch);

		logo = (Background) new Background("Logo").stage(stage).stretch(true)
				.texture("images/logo.png");
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		addProcessor();

		stage.act(delta);
		stage.draw();

		batch.begin();
		{
			logo.getSprite().draw(batch);
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
	}

	@Override
	public boolean keyDown(int keycode) {
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
