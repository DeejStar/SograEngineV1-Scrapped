package com.soginteractive.engine.core.equipment.managers;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.soginteractive.engine.core.equipment.Armor;
import com.soginteractive.engine.core.managers.EquipmentManager;

public class ArmorManager extends EquipmentManager {

	private Array<Armor> armors;
	
	public ArmorManager(String path) {
		super(path);
		armors = new Array<Armor>();
	}
	
	public ArmorManager armor(Armor armor) {
		this.armors.add(armor);
		return this;
	}
	
	public Array<Armor> getArmors() {
		return armors;
	}
	
	@Override
	public void writeAllScripts(Json json) {
		super.writeAllScripts(json);
		for (int i = 0; i < writers.size; i++) {
			for (int j = 0; j < armors.size; j++) {
				Armor armor = armors.get(j);
				checkObjectForWriting(writers.get(i), json, armor);
			}
		}
	}

}
