package com.soginteractive.engine.core.equipment.managers;

import com.badlogic.gdx.utils.Array;
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

}
