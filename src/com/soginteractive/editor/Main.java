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

@SuppressWarnings("serial")
public class Main extends JFrame {

	private Array<JButton> buttons;

	public Main() {
		buttons = new Array<JButton>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final Container container = getContentPane();
		container.setLayout(new BorderLayout());

		LwjglAWTCanvas canvas = new LwjglAWTCanvas(new EditorMain());
		container.add(canvas.getCanvas(), BorderLayout.CENTER);

		createNewButton("Main Screen");
		createNewButton("Character Screen");
		createNewButton("Enemy Screen");
		createNewButton("Equipment Screen");
		createNewButton("Event Screen");
		createNewButton("Menu Screen");

		JPanel panel = new JPanel(new GridLayout(buttons.size, 1));

		addButtonsToPanel(buttons, panel);

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

	private void createNewButton() {
		createNewButton("");
	}

	private void createNewButton(String text) {
		addButtonToArray(new JButton(text));
	}

	private void addButtonToArray(JButton button) {
		if (buttons != null) {
			buttons.add(button);
		}
	}

	private void removeButtonFromArray() {
		for (int i = 0; i < buttons.size; i++) {
			removeButtonFromArray(i);
		}
	}

	private void removeButtonFromArray(int index) {
		buttons.removeIndex(index);
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
