package com.soginteractive.editor.util.managers;

import static com.soginteractive.engine.core.util.ScriptUtils.concatStrings;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.soginteractive.editor.util.ScriptWriter;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.core.Scripter;
import com.soginteractive.engine.core.equipment.Weapon;
import com.soginteractive.engine.core.equipment.managers.WeaponManager;
import com.soginteractive.engine.core.misc.Requirement;
import com.soginteractive.engine.menu.Menu;
import com.soginteractive.engine.menu.entities.Background;
import com.soginteractive.engine.menu.entities.Text;
import com.soginteractive.engine.menu.managers.MenuManager;
import com.soginteractive.engine.menu.misc.Command;

public class ScriptManager extends AbstractManager {

	private final String extension = ".json";

	private Array<Scripter> menuWriters;
	private Array<Menu> menus;

	private Array<Scripter> weaponWriters;
	private Array<Weapon> weapons;

	private MenuManager menuManager;
	private WeaponManager weaponManager;

	public ScriptManager(String path) {
		super(path);
		menuWriters = new Array<Scripter>();
		weaponWriters = new Array<Scripter>();
	}

	public ScriptManager menuManager(MenuManager menuManager) {
		this.menuManager = menuManager;
		createMenuWriters();
		return this;
	}

	public ScriptManager weaponManager(WeaponManager weaponManager) {
		this.weaponManager = weaponManager;
		createWeaponWriters();
		return this;
	}

	private void createMenuWriters() {
		menus = menuManager.getMenus();
		iterateThroughMenus();
	}

	private void iterateThroughMenus() {
		for (int i = 0; i < menus.size; i++) {
			Menu menu = menus.get(i);
			addToMenuWriters(menu);
		}
	}

	private void addToMenuWriters(Menu menu) {
		String menuPath = path.concat(menuManager.getPath());
		menuWriters.add(new ScriptWriter(concatStrings(menuPath,
				menu.getName(), extension)));
		addPathToMenu(menu, menuPath);
	}

	private void addPathToMenu(Menu menu, String menuPath) {
		menu.menuPath(menuPath);
	}

	private void createWeaponWriters() {
		weapons = weaponManager.getWeapons();
		iterateThroughWeapons();
	}

	private void iterateThroughWeapons() {
		for (int i = 0; i < weapons.size; i++) {
			Weapon weapon = weapons.get(i);
			addToWeaponWriters(weapon);
		}
	}

	private void addToWeaponWriters(Weapon weapon) {
		String weaponPath = path.concat(weaponManager.getPath());
		weaponWriters.add(new ScriptWriter(concatStrings(weaponPath,
				weapon.getName(), extension)));
		addPathToWeapon(weapon, weaponPath);
	}

	private void addPathToWeapon(Weapon weapon, String weaponPath) {
		weapon.path(weaponPath);
	}

	public void writeScripts(Json json) {
		if (menuWriters != null) {
			writeMenus(json);
		}
		
		if(weaponWriters != null) {
			writeWeapons(json);
		}

	}

	private void writeMenus(Json json) {
		iterateThroughMenuWriters(json);
	}

	private void iterateThroughMenuWriters(Json json) {
		for (int i = 0; i < menuWriters.size; i++) {
			ScriptWriter writer = (ScriptWriter) menuWriters.get(i);
			iterateThroughMenus(json, writer);
		}
	}

	private void iterateThroughMenus(Json json, ScriptWriter writer) {
		for (int j = 0; j < menus.size; j++) {
			Menu menu = menus.get(j);
			checkWriterContainsMenuName(json, writer, menu);
		}
	}

	private void checkWriterContainsMenuName(Json json, ScriptWriter writer,
			Menu menu) {
		if (writer.getPath().contains(menu.getName())) {
			checkMenuHasCommands(json, writer, menu);
			checkMenuHasTexts(json, writer, menu);
			checkMenuHasBackground(json, writer, menu);
			writer.writeScriptFile(json, menu);
		}
	}

	private void checkMenuHasCommands(Json json, ScriptWriter writer, Menu menu) {
		if (menu.getCommands() != null) {
			String commandPath = "";
			iterateThroughMenuCommandsToGetNames(json, writer, menu,
					commandPath);
		}
	}

	private void iterateThroughMenuCommandsToGetNames(Json json,
			ScriptWriter writer, Menu menu, String commandPath) {
		Array<Command> commands = menu.getCommands();
		Command command = null;
		for (int i = 0; i < commands.size; i++) {
			command = commands.get(i);
			commandPath = concatStrings(menuManager.getCommandManager()
					.getPath(), menu.getCommandName(command), extension);

			addCommandPathToMenu(menu, command, commandPath);

			writeMenuCommands(json, writer, command, commandPath);
		}
	}

	private void addCommandPathToMenu(Menu menu, Command command,
			String commandPath) {
		menu.commandPath(command, commandPath);
	}

	private void writeMenuCommands(Json json, ScriptWriter writer,
			Command command, String commandPath) {
		new ScriptWriter(concatStrings(writer.getParentPath(), commandPath))
				.writeScriptFile(json, command);
	}

	private void checkMenuHasTexts(Json json, ScriptWriter writer, Menu menu) {
		if (menu.getTexts() != null) {
			String textPath = "";
			iterateThroughMenuTextsToGetNames(json, writer, menu, textPath);
		}
	}

	private void iterateThroughMenuTextsToGetNames(Json json,
			ScriptWriter writer, Menu menu, String textPath) {
		Array<Text> texts = menu.getTexts();
		Text text = null;

		for (int i = 0; i < texts.size; i++) {
			text = texts.get(i);
			textPath = concatStrings(menuManager.getTextManager().getPath(),
					menu.getTextName(text), extension);

			addTextPathToMenu(menu, text, textPath);

			writeMenuTexts(json, writer, text, textPath);
		}
	}

	private void addTextPathToMenu(Menu menu, Text text, String textPath) {
		menu.textPath(text, textPath);

		System.out.println(menu.getTextPath(text));
	}

	private void writeMenuTexts(Json json, ScriptWriter writer, Text text,
			String textPath) {
		new ScriptWriter(concatStrings(writer.getParentPath(), textPath))
				.writeScriptFile(json, text);
	}

	private void checkMenuHasBackground(Json json, ScriptWriter writer,
			Menu menu) {
		Background background = menu.getBackground();

		if (background != null) {
			String backgroundPath = concatStrings(menuManager
					.getBackgroundManager().getPath(),
					menu.getBackgroundName(background), extension);

			addBackgroundPathToMenu(menu, background, backgroundPath);

			writeMenuBackground(json, writer, menu, backgroundPath);
		}
	}

	private void writeMenuBackground(Json json, ScriptWriter writer, Menu menu,
			String backgroundPath) {
		new ScriptWriter(concatStrings(writer.getParentPath(), backgroundPath))
				.writeScriptFile(json, menu.getBackground());
	}

	private void addBackgroundPathToMenu(Menu menu, Background background,
			String backgroundPath) {
		menu.backgroundPath(background, backgroundPath);
	}
	
	private void writeWeapons(Json json) {
		iterateThroughWeaponWriters(json);
	}
	
	private void iterateThroughWeaponWriters(Json json) {
		for (int i = 0; i < weaponWriters.size; i++) {
			ScriptWriter writer = (ScriptWriter) weaponWriters.get(i);
			iterateThroughWeapons(json, writer);
		}
	}

	private void iterateThroughWeapons(Json json, ScriptWriter writer) {
		for(int i = 0; i < weapons.size; i++) {
			Weapon weapon = weapons.get(i);
			checkWeaponHasRequirements(json, writer, weapon);
			
		}
	}
	
	private void checkWeaponHasRequirements(Json json, ScriptWriter writer, Weapon weapon) {
		if(weapon.getRequirements() != null) {
			String reqPath = "";
			iterateThroughWeaponRequirementsToGetNames(json, writer, weapon, reqPath);
		}
	}
	
	private void iterateThroughWeaponRequirementsToGetNames(Json json,
			ScriptWriter writer, Weapon weapon, String requirementPath) {
		Array<Requirement> requirements = weapon.getRequirements();
		Requirement requirement = null;

		for (int i = 0; i < requirements.size; i++) {
			requirement = requirements.get(i);
//			requirementPath = concatStrings(weaponManager.getRequirementManager().getRequirementPath(),
//					weapon.getRequirementName(requirement), extension);

			addPathToWeapon(weapon, requirement, requirementPath);

			writeWeaponRequirements(json, writer, requirement, requirementPath);
		}
	}

	private void addPathToWeapon(Weapon weapon, Requirement requirement, String requirementPath) {
		weapon.requirementPath(requirement, requirementPath);

		//System.out.println(weapon.getRequirementPath(requirement));
	}

	private void writeWeaponRequirements(Json json, ScriptWriter writer, Requirement requirement,
			String requirementPath) {
		new ScriptWriter(concatStrings(writer.getParentPath(), requirementPath))
				.writeScriptFile(json, requirement);
	}

}
