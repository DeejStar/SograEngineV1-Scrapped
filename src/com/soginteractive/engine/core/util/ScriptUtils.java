package com.soginteractive.engine.core.util;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.soginteractive.editor.util.ScriptWriter;

public final class ScriptUtils {

	private static final String DIV = ": ";

	private ScriptUtils() {

	}

	public static String concatStrings(String base, String... strings) {
		String newString = base;
		for (String string : strings) {
			newString = newString.concat(string);
		}
		return newString;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void createArrayFromJson(String name, Json json,
			JsonValue child, Array array) {
		Array array2;
		if (child.has(name)) {
			array2 = json.fromJson(Array.class, child.get(name).toString());

			for (Object object : array2) {
				array.add(object);
			}
		}
	}

	public static void printString(String name, String value) {
		System.out.println(name.concat(DIV).concat(value));
	}

	public static void printInt(String name, int value) {
		System.out.println(name.concat(DIV).concat(Integer.toString(value)));
	}

	public static void printFloat(String name, float value) {
		System.out.println(name.concat(DIV).concat(Float.toString(value)));
	}

	public static void printBoolean(String name, boolean value) {
		System.out.println(name.concat(DIV).concat(Boolean.toString(value)));
	}

	public static ScriptWriter writerInstance(String path) {
		return new ScriptWriter(path);
	}

	public static ScriptReader readerInstance(FileHandle handle) {
		return new ScriptReader(handle);
	}

}
