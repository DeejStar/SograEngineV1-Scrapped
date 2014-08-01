package com.soginteractive.editor.util;

import javax.swing.JButton;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.Manager;

public class ButtonManager implements Manager {

	private String path;

	private Array<JButton> buttons;

	public ButtonManager() {
		buttons = new Array<JButton>();
	}

	@Override
	public Manager path(String path) {
		this.path = path;
		return this;
	}

	@Override
	public String getPath() {
		return path;
	}

}
