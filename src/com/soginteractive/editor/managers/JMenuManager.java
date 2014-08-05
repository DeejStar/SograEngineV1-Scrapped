package com.soginteractive.editor.managers;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;

public class JMenuManager extends AbstractManager {

	private Array<JMenu> menus;
	private Array<JMenuItemManager> menuItemManagers;
	private Array<JMenuManager> subMenuManagers;

	public JMenuManager(String path) {
		super(path);

		menus = new Array<JMenu>();
		menuItemManagers = new Array<JMenuItemManager>();
		subMenuManagers = new Array<JMenuManager>();
	}

	public JMenuManager menu(JMenu menu) {
		menus.add(menu);
		return this;
	}

	public JMenuManager menuItemManager(JMenuItemManager menuItemManager) {
		menuItemManagers.add(menuItemManager);
		return this;
	}

	public JMenuManager subMenuManager(JMenuManager subMenuManager) {
		subMenuManagers.add(subMenuManager);
		return this;
	}

	public void attachMenuItemsToMenu(JMenu menu,
			JMenuItemManager menuItemManager) {
		Array<JMenuItem> menuItems = menuItemManager.getMenuItems();
		for (int i = 0; i < menuItems.size; i++) {
			menu.add(menuItems.get(i));
		}
	}

	public void attachSubMenuMenusToMenu(JMenu menu, JMenuManager subMenuManager) {
		Array<JMenu> menus = subMenuManager.getMenus();
		for (int i = 0; i < menus.size; i++) {
			menu.add(menus.get(i));
		}
	}

	public Array<JMenu> getMenus() {
		return menus;
	}

	public Array<JMenuItemManager> getMenuItemManagers() {
		return menuItemManagers;
	}

	public Array<JMenuManager> getSubMenuManagers() {
		return subMenuManagers;
	}

}
