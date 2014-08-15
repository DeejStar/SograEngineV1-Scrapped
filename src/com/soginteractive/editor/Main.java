package com.soginteractive.editor;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private EditorMain edMain;

	public Main() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final Container container = getContentPane();
		container.setLayout(new BorderLayout());

		edMain = new EditorMain();
		edMain.createMainMenus();

		LwjglAWTCanvas canvas = new LwjglAWTCanvas(edMain);
		container.add(canvas.getCanvas(), BorderLayout.CENTER);
		container.add(edMain.getMenuBar(), BorderLayout.NORTH);

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
