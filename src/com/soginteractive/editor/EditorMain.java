package com.soginteractive.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.soginteractive.editor.screens.MainScreen;
import com.soginteractive.editor.ui.managers.JMenuItemManager;
import com.soginteractive.editor.ui.managers.JMenuManager;

public class EditorMain extends Game implements ActionListener, ItemListener {

	private Batch batch;
	private InputMultiplexer multiplexer;

	private JMenuBar menuBar;
	private JMenu menu, menu2, menu3, menu3Submenu1;
	private JMenuItem menuItem1, menuItem2, menuItem3, menuItem4, menuItem5,
			menuItem6;
	private JMenuItem menu2Item1, menu2Item2, menu2Item3;
	private JMenuItem menu3Item1;
	private JMenuItem m3S1Item1, m3S1Item2, m3S1Item3, m3S1Item4, m3S1Item5,
			m3S1Item6;
	private JMenuManager metaMenuManager, menuManager, subMenuManager;
	private JMenuItemManager menu1ItemManager, menu2ItemManager,
			menu3ItemManager, menu3SubMenuItemManager;

	public void createMainMenus() {
		menuBar = new JMenuBar();

		metaMenuManager = new JMenuManager("MenuManagers");
		menuManager = new JMenuManager("Menus");
		subMenuManager = new JMenuManager("SubMenus");

		menu = new JMenu("File");
		menu2 = new JMenu("Edit");
		menu3 = new JMenu("Window");

		menu1ItemManager = new JMenuItemManager("FileMenuItems");
		menu2ItemManager = new JMenuItemManager("EditMenuItems");
		menu3ItemManager = new JMenuItemManager("WindowMenuItems");
		menu3SubMenuItemManager = new JMenuItemManager("EditorsMenuItems");

		menuItem1 = new JMenuItem("New Project");
		menuItem2 = new JMenuItem("Open Project");
		menuItem3 = new JMenuItem("Save Project");
		menuItem4 = new JMenuItem("Import Spreadsheet");
		menuItem5 = new JMenuItem("Close Project");
		menuItem6 = new JMenuItem("Quit");

		menu2Item1 = new JMenuItem("Cut");
		menu2Item2 = new JMenuItem("Copy");
		menu2Item3 = new JMenuItem("Paste");

		menu3Item1 = new JMenuItem("Main");

		menu3Submenu1 = new JMenu("Editors");

		m3S1Item1 = new JMenuItem("Map");
		m3S1Item2 = new JMenuItem("Character");
		m3S1Item3 = new JMenuItem("Enemy");
		m3S1Item4 = new JMenuItem("Equipment");
		m3S1Item5 = new JMenuItem("Item");
		m3S1Item6 = new JMenuItem("Event");

		menu1ItemManager.menuItem(menuItem1).menuItem(menuItem2)
				.menuItem(menuItem3).menuItem(menuItem4).menuItem(menuItem5)
				.menuItem(menuItem6);

		menu2ItemManager.menuItem(menu2Item1).menuItem(menu2Item2)
				.menuItem(menu2Item3);

		menu3ItemManager.menuItem(menu3Item1);

		menu3SubMenuItemManager.menuItem(m3S1Item1).menuItem(m3S1Item2)
				.menuItem(m3S1Item3).menuItem(m3S1Item4).menuItem(m3S1Item5)
				.menuItem(m3S1Item6);

		subMenuManager.menu(menu3Submenu1);

		subMenuManager.menuItemManager(menu3SubMenuItemManager);

		subMenuManager.attachActionListenerToMenuItems(this);
		subMenuManager.attachItemListenerToMenuItems(this);

		menuManager.menu(menu).menu(menu2).menu(menu3);

		menuManager.subMenuManager(subMenuManager);

		menuManager.menuItemManager(menu1ItemManager)
				.menuItemManager(menu2ItemManager)
				.menuItemManager(menu3ItemManager);

		menuManager.attachMenuItemsToMenu(menu, menu1ItemManager);
		menuManager.attachMenuItemsToMenu(menu2, menu2ItemManager);
		menuManager.attachMenuItemsToMenu(menu3, menu3ItemManager);
		menuManager.attachMenuItemsToMenu(menu3Submenu1,
				menu3SubMenuItemManager);

		menuManager.attachSubMenuMenusToMenu(menu3, subMenuManager);

		menuManager.attachActionListenerToMenuItems(this);
		menuManager.attachItemListenerToMenuItems(this);

		metaMenuManager.subMenuManager(menuManager).subMenuManager(
				subMenuManager);

		Array<JMenu> menus = menuManager.getMenus();
		for (int i = 0; i < menus.size; i++) {
			menuBar.add(menus.get(i));
		}

	}

	@Override
	public void create() {
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		boolean keepAspectRatio = true;

		batch = new SpriteBatch();
		multiplexer = new InputMultiplexer();

		setScreen(new MainScreen(this, width, height, keepAspectRatio, batch)
				.multiplexer(multiplexer));

		Gdx.input.setInputProcessor(multiplexer);
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem) e.getSource();

		for (int i = 0; i < metaMenuManager.getSubMenuManagers().size; i++) {
			JMenuManager menuManager = metaMenuManager.getSubMenuManagers()
					.get(i);
			for (int j = 0; j < menuManager.getMenuItemManagers().size; j++) {
				JMenuItemManager menuItemManager = menuManager
						.getMenuItemManagers().get(j);

				// if (menuItemManager.isMenuItemActionPerformed(source)) {
				// System.out.println("Item clicked: " + e.getActionCommand());
				// }
				checkMenuItemClicked(menuItemManager, source, e);

			}

		}

	}

	private void checkMenuItemClicked(JMenuItemManager manager,
			JMenuItem source, ActionEvent e) {
		if (manager.isMenuItemActionPerformed(source)) {
			if (source.getActionCommand() == "New Project") {
				System.out.println("Item clicked: " + e.getActionCommand());
			}
		}
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
