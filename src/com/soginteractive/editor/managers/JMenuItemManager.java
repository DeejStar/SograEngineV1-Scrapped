package com.soginteractive.editor.managers;

import javax.swing.JMenuItem;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;

public class JMenuItemManager extends AbstractManager {

	private Array<JMenuItem> menuItems;

	public JMenuItemManager(String path) {
		super(path);

		menuItems = new Array<JMenuItem>();
	}

	public JMenuItemManager menuItem(JMenuItem menuItem) {
		menuItems.add(menuItem);
		return this;
	}

	public Array<JMenuItem> getMenuItems() {
		return menuItems;
	}

}
