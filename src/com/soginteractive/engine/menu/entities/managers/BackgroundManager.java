package com.soginteractive.engine.menu.entities.managers;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.menu.entities.Background;

public class BackgroundManager extends AbstractManager {

	private Array<Background> backgrounds;

	public BackgroundManager(String path) {
		super(path);
		backgrounds = new Array<Background>();
	}

	public BackgroundManager background(Background background) {
		backgrounds.add(background);
		return this;
	}

	public Array<Background> getBackgrounds() {
		return backgrounds;
	}

}
