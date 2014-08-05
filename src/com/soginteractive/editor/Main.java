package com.soginteractive.editor;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas;
import com.badlogic.gdx.utils.Array;
import com.soginteractive.editor.managers.JMenuItemManager;
import com.soginteractive.editor.managers.JMenuManager;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JMenuManager menuManager, subMenuManager;
	private JMenuItemManager menu1ItemManager, menu2ItemManager,
			menu3ItemManager, menu3SubMenuItemManager;

	public Main() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final Container container = getContentPane();
		container.setLayout(new BorderLayout());

		LwjglAWTCanvas canvas = new LwjglAWTCanvas(new EditorMain());
		container.add(canvas.getCanvas(), BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();

		menuManager = new JMenuManager("Menus");
		subMenuManager = new JMenuManager("SubMenus");

		JMenu menu = new JMenu("File");
		JMenu menu2 = new JMenu("Edit");
		JMenu menu3 = new JMenu("Window");

		menu1ItemManager = new JMenuItemManager("FileMenuItems");
		menu2ItemManager = new JMenuItemManager("EditMenuItems");
		menu3ItemManager = new JMenuItemManager("WindowMenuItems");
		menu3SubMenuItemManager = new JMenuItemManager("EditorsMenuItems");

		JMenuItem menuItem1 = new JMenuItem("New Project");
		JMenuItem menuItem2 = new JMenuItem("Open Project");
		JMenuItem menuItem3 = new JMenuItem("Save Project");
		JMenuItem menuItem4 = new JMenuItem("Close Project");

		JMenuItem menu2Item1 = new JMenuItem("Cut");
		JMenuItem menu2Item2 = new JMenuItem("Copy");
		JMenuItem menu2Item3 = new JMenuItem("Paste");

		JMenuItem menu3Item1 = new JMenuItem("Main");

		JMenu menu3Submenu1 = new JMenu("Editors");

		JMenuItem m3S1Item1 = new JMenuItem("Map");
		JMenuItem m3S1Item2 = new JMenuItem("Character");
		JMenuItem m3S1Item3 = new JMenuItem("Enemy");
		JMenuItem m3S1Item4 = new JMenuItem("Equipment");
		JMenuItem m3S1Item5 = new JMenuItem("Item");
		JMenuItem m3S1Item6 = new JMenuItem("Event");

		menu1ItemManager.menuItem(menuItem1).menuItem(menuItem2)
				.menuItem(menuItem3).menuItem(menuItem4);

		menu2ItemManager.menuItem(menu2Item1).menuItem(menu2Item2)
				.menuItem(menu2Item3);

		menu3ItemManager.menuItem(menu3Item1);

		menu3SubMenuItemManager.menuItem(m3S1Item1).menuItem(m3S1Item2)
				.menuItem(m3S1Item3).menuItem(m3S1Item4).menuItem(m3S1Item5)
				.menuItem(m3S1Item6);

		subMenuManager.menu(menu3Submenu1);

		subMenuManager.menuItemManager(menu3SubMenuItemManager);

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

		Array<JMenu> menus = menuManager.getMenus();
		for (int i = 0; i < menus.size; i++) {
			menuBar.add(menus.get(i));
		}

		container.add(menuBar, BorderLayout.NORTH);

		pack();
		setVisible(true);
		setSize(800, 600);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main();
			}
		});
	}

}
