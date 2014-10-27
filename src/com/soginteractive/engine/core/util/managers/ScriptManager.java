package com.soginteractive.engine.core.util.managers;

import static com.soginteractive.engine.core.globals.Globals.DEV_MODE;
import static com.soginteractive.engine.core.util.ScriptUtils.concatStrings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.core.Scripter;
import com.soginteractive.engine.core.equipment.Weapon;
import com.soginteractive.engine.core.equipment.managers.WeaponManager;
import com.soginteractive.engine.core.util.ScriptReader;
import com.soginteractive.engine.menu.Menu;
import com.soginteractive.engine.menu.managers.MenuManager;

public class ScriptManager extends AbstractManager {

	private MenuManager menuManager;
	private WeaponManager weaponManager;

	private Array<Scripter> menuReaders;
	private Array<Scripter> weaponReaders;

	public ScriptManager(String path) {
		super(path);
		menuReaders = new Array<Scripter>();
		weaponReaders = new Array<Scripter>();
	}

	public ScriptManager menuManager(MenuManager menuManager) {
		this.menuManager = menuManager;
		createMenuReaders();
		return this;
	}

	public ScriptManager weaponManager(WeaponManager weaponManager) {
		this.weaponManager = weaponManager;
		createWeaponReaders();
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

	private void createWeaponReaders() {
		FileHandle dirHandle = Gdx.files.internal(concatStrings(path,
				weaponManager.getPath()));
		for (FileHandle handle : dirHandle.list()) {
			if (!handle.isDirectory()) {
				weaponReaders.add(new ScriptReader(handle));
			}
		}
	}

	public void readScripts(Json json) {
		readMenus(json);
		readWeapons(json);
		checkDevModeToPrintJson();

	}

	private void readMenus(Json json) {
		for (int i = 0; i < menuReaders.size; i++) {
			ScriptReader reader = (ScriptReader) menuReaders.get(i);
			reader.readScriptFile();
			menuManager.menu(json.fromJson(Menu.class, reader.getStream()));
		}
	}

	private void readWeapons(Json json) {
		for (int i = 0; i < weaponReaders.size; i++) {
			ScriptReader reader = (ScriptReader) weaponReaders.get(i);
			reader.readScriptFile();
			weaponManager
					.weapon(json.fromJson(Weapon.class, reader.getStream()));
		}
	}

	private void checkDevModeToPrintJson() {
		if (DEV_MODE) {
			// printMenus();
		}
	}

	// private void printMenus() {
	// for (Menu menu : menuManager.getMenus()) {
	// menu.printJson();
	// }
	// }

}
