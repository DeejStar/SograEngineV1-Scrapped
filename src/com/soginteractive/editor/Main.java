package com.soginteractive.editor;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {

	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "ArchengeiaAdventuresEditor";
		cfg.width = 800;
		cfg.height = 600;
		cfg.resizable = true;
		
		new LwjglApplication(new EditorMain(), cfg);
	}
}
