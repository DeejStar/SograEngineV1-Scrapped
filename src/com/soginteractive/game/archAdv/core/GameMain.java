package com.soginteractive.game.archAdv.core;

import static com.soginteractive.engine.globals.Globals.DEV_MODE;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.soginteractive.engine.core.util.managers.ScriptManager;
import com.soginteractive.engine.menu.entities.managers.BackgroundManager;
import com.soginteractive.engine.menu.managers.MenuManager;

public class GameMain implements ApplicationListener {
	private Stage stage;
	private OrthographicCamera camera;

	private Json json;

	private MenuManager menuManager;
	// private WeaponManager weaponManager;
	private BackgroundManager backgroundManager;
	private ScriptManager scriptManager;

	private boolean read, menuChecked;

	@Override
	public void create() {
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(width, height);

		stage = new Stage(new StretchViewport(width, height, camera));

		json = new Json();

		menuManager = new MenuManager("menus");

		// weaponManager = new WeaponManager("weapons");

		backgroundManager = new BackgroundManager("backgrounds");
		menuManager.backgroundManager(backgroundManager);

		scriptManager = new ScriptManager("scripts").menuManager(menuManager);

		read = false;
		menuChecked = false;

		DEV_MODE = true;
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

	@Override
	public void render() {
		stage.act();

		if (!read) {
			scriptManager.readScripts(json);
			read = true;
		}

		if (!menuChecked) {
			// menuManager.checkMenusHaveBackground();
			menuChecked = true;
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
