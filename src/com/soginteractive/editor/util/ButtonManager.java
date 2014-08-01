package com.soginteractive.editor.util;

import javax.swing.JButton;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;

public class ButtonManager extends AbstractManager {

	private Array<JButton> buttons;

	public ButtonManager(String path) {
		super(path);
		buttons = new Array<JButton>();
	}

	public ButtonManager button(String text) {
		button(new JButton(text));
		return this;
	}

	public ButtonManager button(JButton button) {
		buttons.add(button);
		return this;
	}

	public Array<JButton> getButtons() {
		return buttons;
	}

}
