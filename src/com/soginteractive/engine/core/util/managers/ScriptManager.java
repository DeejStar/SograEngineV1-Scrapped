package com.soginteractive.engine.core.util.managers;

import static com.soginteractive.engine.core.globals.Globals.DEV_MODE;
import static com.soginteractive.engine.core.util.ScriptUtils.concatStrings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.core.util.ScriptReader;
import com.soginteractive.engine.menu.Menu;
import com.soginteractive.engine.menu.managers.MenuManager;

public class ScriptManager extends AbstractManager {

	private MenuManager menuManager;

	private Array<ScriptReader> menuReaders;

	public ScriptManager(String path) {
		super(path);
		menuReaders = new Array<ScriptReader>();
	}

	public ScriptManager menuManager(MenuManager menuManager) {
		this.menuManager = menuManager;
		createMenuReaders();
		return this;
	}

	private void createMenuReaders() {
		FileHandle dirHandle = Gdx.files.internal(concatStrings(path,
				menuManager.getPath()));
		for (FileHandle handle : dirHandle.list()) {
			if (!handle.isDirectory()) {
				menuReaders.add(new ScriptReader(handle));
			}
		}
	}

	public void readScripts(Json json) {
		readMenus(json);

		checkDevModeToPrintJson();

	}

	private void readMenus(Json json) {
		for (int i = 0; i < menuReaders.size; i++) {
			ScriptReader reader = menuReaders.get(i);
			reader.readScriptFile();
			menuManager.menu(json.fromJson(Menu.class, reader.getStream()));
		}
	}

	private void checkDevModeToPrintJson() {
		if (DEV_MODE) {
//			printMenus();
		}
	}

	// private void printMenus() {
	// for (Menu menu : menuManager.getMenus()) {
	// menu.printJson();
	// }
	// }

}
