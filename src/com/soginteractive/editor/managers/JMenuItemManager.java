package com.soginteractive.editor.managers;

import javax.swing.JMenu;
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

	protected void attachMenuItemsToMenu(JMenu menu) {
		for (int i = 0; i < menuItems.size; i++) {
			menu.add(menuItems.get(i));
		}
	}

	public Array<JMenuItem> getMenuItems() {
		return menuItems;
	}

}
