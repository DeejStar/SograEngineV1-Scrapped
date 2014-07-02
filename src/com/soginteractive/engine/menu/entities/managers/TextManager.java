package com.soginteractive.engine.menu.entities.managers;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.menu.entities.Text;

public class TextManager extends AbstractManager {

	private Array<Text> texts;

	public TextManager(String path) {
		super(path);
		texts = new Array<Text>();
	}

	public TextManager text(Text text) {
		this.texts.add(text);
		return this;
	}

	public Array<Text> getTexts() {
		return texts;
	}

}
