package com.soginteractive.engine.field.entities.managers;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.field.entities.Dialog;

public class DialogManager extends AbstractManager {

	private Array<Dialog> dialogs;

	public DialogManager(String path) {
		super(path);
		dialogs = new Array<Dialog>();
	}

	public DialogManager dialog(Dialog dialog) {
		this.dialogs.add(dialog);
		return this;
	}

	public Array<Dialog> getDialogs() {
		return dialogs;
	}

}
