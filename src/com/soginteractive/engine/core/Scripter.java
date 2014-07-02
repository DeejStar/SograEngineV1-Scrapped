package com.soginteractive.engine.core;

import com.badlogic.gdx.files.FileHandle;

public interface Scripter {

	Scripter handle(FileHandle handle);

	FileHandle getHandle();

	String getPath();

	String getParentPath();

}
