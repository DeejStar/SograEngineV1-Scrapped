package com.soginteractive.editor;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.soginteractive.editor.screens.MainScreen;

public class EditorMain extends Game {

	private Batch batch;
	private InputMultiplexer multiplexer;

	@Override
	public void create() {
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		boolean keepAspectRatio = true;

		batch = new SpriteBatch();
		multiplexer = new InputMultiplexer();

		setScreen(new MainScreen(this, width, height, keepAspectRatio, batch)
				.multiplexer(multiplexer));

		Gdx.input.setInputProcessor(multiplexer);
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
