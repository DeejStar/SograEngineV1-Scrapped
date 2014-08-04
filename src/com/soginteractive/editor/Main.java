package com.soginteractive.editor;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas;

@SuppressWarnings("serial")
public class Main extends JFrame {

	public Main() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final Container container = getContentPane();
		container.setLayout(new BorderLayout());

		LwjglAWTCanvas canvas = new LwjglAWTCanvas(new EditorMain());
		container.add(canvas.getCanvas(), BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();

		JMenu menu = new JMenu("File");
		JMenu menu2 = new JMenu("Edit");
		JMenu menu3 = new JMenu("Window");

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

		menu.add(menuItem1);
		menu.add(menuItem2);
		menu.add(menuItem3);
		menu.add(menuItem4);

		menu2.add(menu2Item1);
		menu2.add(menu2Item2);
		menu2.add(menu2Item3);

		menu3.add(menu3Item1);

		menu3Submenu1.add(m3S1Item1);
		menu3Submenu1.add(m3S1Item2);
		menu3Submenu1.add(m3S1Item3);
		menu3Submenu1.add(m3S1Item4);
		menu3Submenu1.add(m3S1Item5);
		menu3Submenu1.add(m3S1Item6);

		menu3.add(menu3Submenu1);

		menuBar.add(menu);
		menuBar.add(menu2);
		menuBar.add(menu3);

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
