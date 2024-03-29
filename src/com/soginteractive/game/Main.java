package com.soginteractive.game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.soginteractive.game.archAdv.core.GameMain;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "ArchAdventures";
		cfg.width = 1280;
		cfg.height = 720;
		
		new LwjglApplication(new GameMain(), cfg);
	}
}
