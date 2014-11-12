package com.soginteractive.engine.core.equipment.managers;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.soginteractive.engine.core.equipment.Accessory;
import com.soginteractive.engine.core.managers.EquipmentManager;

public class AccessoryManager extends EquipmentManager {

	private Array<Accessory> accessories;

	public AccessoryManager(String path) {
		super(path);
		accessories = new Array<Accessory>();
	}

	public AccessoryManager accessory(Accessory accessory) {
		this.accessories.add(accessory);
		return this;
	}

	public Array<Accessory> getAccessories() {
		return accessories;
	}

	@Override
	public void writeAllScripts(Json json) {
		super.writeAllScripts(json);
		for (int i = 0; i < writers.size; i++) {
			for (int j = 0; j < accessories.size; j++) {
				Accessory accessory = accessories.get(j);
				checkObjectForWriting(writers.get(i), json, accessory);
			}
		}
	}

}
