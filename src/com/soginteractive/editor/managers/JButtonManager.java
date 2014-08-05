package com.soginteractive.editor.managers;

import javax.swing.JButton;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;

public class JButtonManager extends AbstractManager {

	private Array<JButton> buttons;

	public JButtonManager(String path) {
		super(path);
		buttons = new Array<JButton>();
	}

	public JButtonManager button(String text) {
		button(new JButton(text));
		return this;
	}

	public JButtonManager button(JButton button) {
		buttons.add(button);
		return this;
	}

	public Array<JButton> getButtons() {
		return buttons;
	}

}
