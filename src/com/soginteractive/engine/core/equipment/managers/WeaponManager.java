package com.soginteractive.engine.core.equipment.managers;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.soginteractive.engine.core.equipment.Weapon;
import com.soginteractive.engine.core.managers.EquipmentManager;

public class WeaponManager extends EquipmentManager {

	private Array<Weapon> weapons;

	public WeaponManager(String path) {
		super(path);
		weapons = new Array<Weapon>();
	}

	public WeaponManager weapon(Weapon weapon) {
		weapons.add(weapon);
		return this;
	}

	public Array<Weapon> getWeapons() {
		return weapons;
	}

	@Override
	public void writeAllScripts(Json json) {
		super.writeAllScripts(json);
		for (int i = 0; i < writers.size; i++) {
			for (int j = 0; j < weapons.size; j++) {
				Weapon weapon = weapons.get(j);
				checkObjectForWriting(writers.get(i), json, weapon);
			}
		}
	}

}
