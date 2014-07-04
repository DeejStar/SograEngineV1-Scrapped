package com.soginteractive.editor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.soginteractive.game.archAdv.core.GameMain;

@SuppressWarnings("serial")
public class Main extends JFrame {

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final Container container = getContentPane();
		container.setLayout(new BorderLayout());

		LwjglAWTCanvas canvas = new LwjglAWTCanvas(new EditorMain());
		container.add(canvas.getCanvas(), BorderLayout.CENTER);

		JPanel panel = new JPanel(new GridLayout(2, 4));

		JButton button = new JButton("Sex is good");
		JButton button2 = new JButton("But Food is Better.");
		//JButton button3 = new JButton("Aye, Aye, Aye.");
		button.setSize(25, 50);
		// button.setVisible(true);

		panel.add(button);
		panel.add(button2);
		//panel.add(button3);
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
