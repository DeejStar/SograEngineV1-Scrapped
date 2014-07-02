package com.soginteractive.editor.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Json;
import com.soginteractive.engine.core.AbstractScripter;

public class ScriptWriter extends AbstractScripter {

	public ScriptWriter(String path) {
		this(Gdx.files.local(path));
	}

	public ScriptWriter(FileHandle handle) {
		super(handle);
	}

	public void writeScriptFile(Object object) {
		writeScriptFile(new Json(), object);
	}

	public void writeScriptFile(Json json, Object object) {
		writeScriptFile(json, object, false);
	}

	public void writeScriptFile(Json json, Object object, boolean append) {
		handle.writeString(json.prettyPrint(object), append);
	}

	public void writeSkinFile(Skin skin) {
		writeSkinFile(skin, false);
	}

	public void writeSkinFile(Skin skin, boolean append) {
		handle.writeString((new Json()).prettyPrint(skin), append);
	}

}