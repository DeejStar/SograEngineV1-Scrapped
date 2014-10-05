package com.soginteractive.engine.core.util;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public final class ScriptUtils {

	private static final String DIV = ": ";

	private ScriptUtils() {

	}

	public static String concatStrings(String base, Array<String> strings) {
		String newString = base;
		iterateThroughStringArray(strings, newString);
		return newString;
	}

	private static void iterateThroughStringArray(Array<String> strings,
			String string) {
		for (int i = 0; i < strings.size; i++) {
			string = string.concat(strings.get(i));
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public static void createArrayFromJson(String name, Json json,
			JsonValue child, Array array) {
		Array array2;
		if (child.has(name)) {
			array2 = json.fromJson(Array.class, child.get(name).toString());

			iterateThroughArrayToArray(array2, array);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void iterateThroughArrayToArray(Array array2, Array array) {
		Object object;
		for (int i = 0; i < array2.size; i++) {
			object = array2.get(i);
			if (checkIfObjectIsNotNull(object)) {
				array.add(object);
			}
		}
	}

	private static boolean checkIfObjectIsNotNull(Object object) {
		return (object != null);
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

}
