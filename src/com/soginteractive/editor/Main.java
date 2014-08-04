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
		JMenuItem item = new JMenuItem("New Project");

		JMenu menu2 = new JMenu("Window");
		JMenuItem item2 = new JMenuItem("Main");

		menu.add(item);
		menu2.add(item2);

		menuBar.add(menu);
		menuBar.add(menu2);

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
