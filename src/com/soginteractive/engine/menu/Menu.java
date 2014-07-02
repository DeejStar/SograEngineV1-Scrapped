package com.soginteractive.engine.menu;

import static com.soginteractive.engine.core.util.ScriptUtils.concatStrings;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.soginteractive.engine.core.util.ScriptReader;
import com.soginteractive.engine.menu.entities.Background;
import com.soginteractive.engine.menu.entities.Text;
import com.soginteractive.engine.menu.misc.Command;

public class Menu implements Serializable {

	private String name;
	private String menuPath;

	private Array<Command> commands;
	private Array<Text> texts;

	private ScriptReader reader;

	private Background background;

	private final String OBJ = "Menu";
	private final String NAME = "name";
	private final String CMDS = "commands";
	private final String CMDP = "commandPath";
	private final String BCKGP = "backgroundPath";
	private final String TXTS = "texts";
	private final String TXTP = "textPath";

	public Menu() {
		this("");
	}

	public Menu(String name) {
		name(name);
		commands = new Array<Command>();
		texts = new Array<Text>();
	}

	public Menu name(String name) {
		this.name = name;
		return this;
	}

	public Menu menuPath(String menuPath) {
		this.menuPath = menuPath;
		return this;
	}

	public Menu command(Command command) {
		this.commands.add(command);
		return this;
	}

	public Menu background(Background background) {
		this.background = background;
		return this;
	}

	public Menu text(Text text) {
		this.texts.add(text);
		return this;
	}

	public Menu commandPath(Command command, String commandPath) {
		command.path(commandPath);
		return this;
	}

	public Menu backgroundPath(Background background, String backgroundPath) {
		background.path(backgroundPath);
		return this;
	}

	public Menu textPath(Text text, String textPath) {
		text.path(textPath);
		return this;
	}

	public String getName() {
		return name;
	}

	public Array<Command> getCommands() {
		return commands;
	}

	public Array<Text> getTexts() {
		return texts;
	}

	public Background getBackground() {
		return background;
	}

	public String getBackgroundName(Background background) {
		return background.getName();
	}

	public String getBackgroundPath(Background background) {
		return background.getPath();
	}

	public String getCommandName(Command command) {
		return command.getName();
	}

	public String getCommandPath(Command command) {
		return command.getPath();
	}

	public String getTextName(Text text) {
		return text.getName();
	}

	public String getTextPath(Text text) {
		return text.getPath();
	}

	@Override
	public void write(Json json) {
		json.writeObjectStart(OBJ);
		{
			json.writeValue(NAME, name);
			writeCommands(json);
			checkBackgroundNull(json);
			writeTexts(json);
		}
		json.writeObjectEnd();
	}

	private void writeCommands(Json json) {
		json.writeObjectStart(CMDS);
		{
			json.writeArrayStart(CMDP);
			{
				iterateThroughCommands(json);
			}
			json.writeArrayEnd();
		}
		json.writeObjectEnd();
	}

	private void iterateThroughCommands(Json json) {
		for (int i = 0; i < commands.size; i++) {
			checkCommandNull(json, commands.get(i));
		}
	}

	private void checkCommandNull(Json json, Command command) {
		if (command != null) {
			json.writeValue(concatStrings(menuPath, command.getPath()));
		}
	}

	private void checkBackgroundNull(Json json) {
		if (background != null) {
			json.writeValue(BCKGP,
					concatStrings(menuPath, background.getPath()));
		}
	}

	private void writeTexts(Json json) {
		json.writeObjectStart(TXTS);
		{
			json.writeArrayStart(TXTP);
			{
				iterateThroughTexts(json);
			}
			json.writeArrayEnd();
		}
		json.writeObjectEnd();
	}

	private void iterateThroughTexts(Json json) {
		for (int i = 0; i < texts.size; i++) {
			checkTextNull(json, texts.get(i));
		}
	}

	private void checkTextNull(Json json, Text text) {
		if (text != null) {
			json.writeValue(concatStrings(menuPath, text.getPath()));
		}
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		JsonValue child = jsonData.child;
		name(child.getString(NAME));
		checkCommands(json, child);
		checkBackground(json, child);
	}

	private void checkCommands(Json json, JsonValue child) {
		if (child.has(CMDS)) {
			checkCommandPaths(json, child.get(CMDS));
		}
	}

	private void checkCommandPaths(Json json, JsonValue child) {
		if (child.has(CMDP)) {
			createCommandPathsFromJson(json, child.get(CMDP));
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void createCommandPathsFromJson(Json json, JsonValue child) {
		Array paths = json.fromJson(Array.class, child.toString());
		iterateThroughCommandPathsFromJson(json, paths);
	}

	private void iterateThroughCommandPathsFromJson(Json json,
			Array<String> paths) {
		for (int i = 0; i < paths.size; i++) {
			createCommandFromJson(json, paths.get(i));
		}
	}

	private void createCommandFromJson(Json json, String string) {
		createNewReader(string);
		command(json.fromJson(Command.class, reader.getStream()));
	}

	private void checkBackground(Json json, JsonValue child) {
		if (child.has(BCKGP)) {
			createBackgroundFromJson(json, child.getString(BCKGP));
		}
	}

	private void createBackgroundFromJson(Json json, String string) {
		createNewReader(string);
		background(json.fromJson(Background.class, reader.getStream()));
	}

	private void createNewReader(String string) {
		reader = new ScriptReader(string);
		reader.readScriptFile();
	}

}
