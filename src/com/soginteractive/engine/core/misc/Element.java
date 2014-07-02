package com.soginteractive.engine.core.misc;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

import static com.soginteractive.engine.core.util.ScriptUtils.*;

public class Element implements Serializable {

	private String name;
	private String neutralizes, halves, absorbs;

	private final String OBJ = "element";
	private final String NAME = "name";
	private final String NEUT = "neutralizes";
	private final String HLVS = "halves";
	private final String ABS = "absorbs";

	public Element() {
		this("");
	}

	public Element(String name) {
		name(name);
	}

	public Element name(String name) {
		this.name = name;
		return this;
	}

	public Element neutralizes(String neutralizes) {
		this.neutralizes = neutralizes;
		return this;
	}

	public Element halves(String halves) {
		this.halves = halves;
		return this;
	}

	public Element absorbs(String absorbs) {
		this.absorbs = absorbs;
		return this;
	}

	public String getName() {
		return name;
	}

	public String getNeutralizes() {
		return neutralizes;
	}

	public String getHalves() {
		return halves;
	}

	public String getAbsorbs() {
		return absorbs;
	}

	@Override
	public void write(Json json) {
		json.writeObjectStart(OBJ);
		{
			json.writeValue(NAME, name);
			json.writeValue(NEUT, neutralizes);
			json.writeValue(HLVS, halves);
			json.writeValue(ABS, absorbs);
		}
		json.writeObjectEnd();
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		JsonValue child = jsonData.child;
		name(child.getString(NAME));
		neutralizes(child.getString(NEUT));
		halves(child.getString(HLVS));
		absorbs(child.getString(ABS));
	}

	public void printJson() {
		printString(NAME, name);
		printString(NEUT, neutralizes);
		printString(HLVS, halves);
		printString(ABS, absorbs);
		System.out.println("\n");
	}
	
}
