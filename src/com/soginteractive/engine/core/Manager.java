package com.soginteractive.engine.core;

import com.badlogic.gdx.utils.Array;

public interface Manager {

	Manager path(String path);

	abstract Manager writer(Scripter writer);

	abstract Manager reader(Scripter reader);

	abstract void writeAllScripts();

	abstract void writeScript(Scripter writer);
	
	abstract void writeScript(Scripter writer, Object object);

	abstract void readAllScripts();

	abstract void readScript(Scripter reader);
	
	abstract void readScript(Scripter reader, Object object);

	String getPath();

	abstract Array<Scripter> getWriters();

	abstract Array<Scripter> getReaders();

}
