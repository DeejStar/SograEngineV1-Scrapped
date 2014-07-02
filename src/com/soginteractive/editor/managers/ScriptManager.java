package com.soginteractive.editor.managers;

import static com.soginteractive.engine.core.util.ScriptUtils.concatStrings;
import static com.soginteractive.engine.core.util.ScriptUtils.writerInstance;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.soginteractive.editor.util.ScriptWriter;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.core.Scripter;
import com.soginteractive.engine.menu.Menu;
import com.soginteractive.engine.menu.entities.Background;
import com.soginteractive.engine.menu.entities.Text;
import com.soginteractive.engine.menu.managers.MenuManager;
import com.soginteractive.engine.menu.misc.Command;

public class ScriptManager extends AbstractManager {

	private final String extension = ".json";

	private Array<Scripter> menuWriters;
	private Array<Menu> menus;

	private MenuManager menuManager;

	public ScriptManager(String path) {
		super(path);
		menuWriters = new Array<Scripter>();
	}

	public ScriptManager menuManager(MenuManager menuManager) {
		this.menuManager = menuManager;
		createMenuWriters();
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
		menuWriters.add(writerInstance(concatStrings(menuPath, menu.getName(),
				extension)));
		addPathToMenu(menu, menuPath);
	}

	private void addPathToMenu(Menu menu, String menuPath) {
		menu.menuPath(menuPath);
	}

	public void writeScripts(Json json) {
		writeMenus(json);
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
		writerInstance(concatStrings(writer.getParentPath(), commandPath))
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
		writerInstance(concatStrings(writer.getParentPath(), textPath))
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
		writerInstance(concatStrings(writer.getParentPath(), backgroundPath))
				.writeScriptFile(json, menu.getBackground());
	}

	private void addBackgroundPathToMenu(Menu menu, Background background,
			String backgroundPath) {
		menu.backgroundPath(background, backgroundPath);
	}

}
