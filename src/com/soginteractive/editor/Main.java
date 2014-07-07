package com.soginteractive.editor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

		JPanel panel = new JPanel(new GridLayout(6, 1));

		JButton mainButton = new JButton("Main Screen");
		JButton characterButton = new JButton("Character Screen");
		JButton enemyButton = new JButton("Enemy Screen");
		JButton equipmentButton = new JButton("Equipment Screen");
		JButton eventButton = new JButton("Event Screen");
		JButton menuScreen = new JButton("Menu Screen");

		panel.add(mainButton);
		panel.add(characterButton);
		panel.add(enemyButton);
		panel.add(equipmentButton);
		panel.add(eventButton);
		panel.add(menuScreen);

		container.add(panel, BorderLayout.WEST);

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
