package com.soginteractive.engine.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class AbstractScreen implements Screen, InputProcessor {

	protected Game game;
	private OrthographicCamera camera;
	private Viewport viewport;
	protected Stage stage;
	protected Batch batch;

	protected InputMultiplexer multiplexer;
	protected boolean inputAdded = false;

	public AbstractScreen() {
		this(null);
	}

	public AbstractScreen(Game game) {
		this(game, null);
	}

	public AbstractScreen(Game game, Batch batch) {
		this(game, 800, 600, batch);
	}

	public AbstractScreen(Game game, float width, float height, Batch batch) {
		this(game, width, height, false, batch);
	}

	public AbstractScreen(Game game, float width, float height,
			boolean keepAspectRatio, Batch batch) {
		this.game = game;

		camera = new OrthographicCamera(width, height);
		camera.setToOrtho(false);

		if (keepAspectRatio) {
			viewport = new StretchViewport(width, height, camera);
		}

		else {
			viewport = new ScalingViewport(Scaling.fit, width, height, camera);
		}

		stage = new Stage(viewport, batch);
		
		this.batch = stage.getBatch();
	}

	@Override
	public Screen multiplexer(InputMultiplexer multiplexer) {
		this.multiplexer = multiplexer;
		return this;
	}

	@Override
	public InputMultiplexer getInputMultiplexer() {
		return multiplexer;
	}

	protected void addProcessor() {
		if (!inputAdded) {
			multiplexer.addProcessor(this);
			inputAdded = true;
		}
	}

}
