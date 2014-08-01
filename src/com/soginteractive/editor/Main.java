package com.soginteractive.editor;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas;
import com.badlogic.gdx.utils.Array;
import com.soginteractive.editor.util.ButtonManager;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private ButtonManager buttonManager;

	public Main() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final Container container = getContentPane();
		container.setLayout(new BorderLayout());

		LwjglAWTCanvas canvas = new LwjglAWTCanvas(new EditorMain());
		container.add(canvas.getCanvas(), BorderLayout.CENTER);

		buttonManager = new ButtonManager("Buttons");

		buttonManager.button("Main Screen").button("Character Screen")
				.button("Enemy Screen").button("Equipment Screen")
				.button("Event Screen").button("Menu Screen");

		JPanel panel = new JPanel(new GridLayout(
				buttonManager.getButtons().size, 1));

		addButtonsToPanel(buttonManager.getButtons(), panel);

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

	private void addButtonsToPanel(Array<JButton> buttons, JPanel panel) {
		JButton button;
		for (int i = 0; i < buttons.size; i++) {
			button = buttons.get(i);
			if (button != null) {
				panel.add(button);
			}
		}
	}

}
