package com.soginteractive.engine.field.managers;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.field.Field;
import com.soginteractive.engine.field.entities.managers.DialogManager;
import com.soginteractive.engine.field.misc.manager.EventManager;

public class FieldManager extends AbstractManager {

	private Array<Field> fields;

	private DialogManager dialogManager;
	private EventManager eventManager;

	public FieldManager(String path) {
		super(path);
		fields = new Array<Field>();
	}

	public FieldManager field(Field field) {
		this.fields.add(field);
		return this;
	}

	public FieldManager dialogManager(DialogManager dialogManager) {
		this.dialogManager = dialogManager;
		return this;
	}

	public FieldManager eventManager(EventManager eventManager) {
		this.eventManager = eventManager;
		return this;
	}

	public Array<Field> getFields() {
		return fields;
	}

	public DialogManager getDialogManager() {
		return dialogManager;
	}

	public EventManager getEventManager() {
		return eventManager;
	}

}
