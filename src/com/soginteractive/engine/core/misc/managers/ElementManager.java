package com.soginteractive.engine.core.misc.managers;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.core.misc.Element;

public class ElementManager extends AbstractManager {

	private Array<Element> elements;

	public ElementManager(String path) {
		super(path);
		elements = new Array<Element>();
	}

	public ElementManager element(Element element) {
		this.elements.add(element);
		return this;
	}

	public Array<Element> getElements() {
		return elements;
	}

}
