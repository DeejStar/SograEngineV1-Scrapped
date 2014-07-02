package com.soginteractive.engine.field.entities;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.soginteractive.engine.core.util.ScriptReader;
import com.soginteractive.engine.menu.entities.Background;
import com.soginteractive.engine.menu.entities.Text;

import static com.soginteractive.engine.core.util.ScriptUtils.*;

public class Dialog extends Text {

	private ScriptReader reader;

	private Background background;

	private static final String BCKGP = "backgroundPath";
	private static final String BCKGN = "backgroundName";

	public Dialog(String name) {
		super(name);
	}

	public Dialog background(Background background) {
		this.background = background;
		return this;
	}

	public Background getBackground() {
		return background;
	}

	@Override
	public void write(Json json) {
		super.write(json);
		{
			checkBackgroundNull(json);
		}
		json.writeObjectEnd();
	}

	private void checkBackgroundNull(Json json) {
		if (background != null) {
			json.writeValue(BCKGP, background.getPath());
		}
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		super.read(json, jsonData);
		JsonValue child = jsonData.child;
		checkBackground(json, child);
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

	public void printJson() {
		super.printJson();
		if (background != null) {
			printString(BCKGN, background.getName());
		}
	}

}
