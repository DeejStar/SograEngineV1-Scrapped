package com.soginteractive.editor.test;

import com.badlogic.gdx.utils.Json;
import com.soginteractive.editor.util.managers.ScriptManager;
import com.soginteractive.engine.core.Equipment;
import com.soginteractive.engine.core.equipment.Weapon;
import com.soginteractive.engine.core.equipment.managers.WeaponManager;
import com.soginteractive.engine.core.misc.Effect;
import com.soginteractive.engine.core.misc.Element;
import com.soginteractive.engine.core.misc.Modifier;

public class ScriptingTest {

	private ScriptManager scriptManager;

	public ScriptingTest(ScriptManager scriptManager) {
		scriptManager(scriptManager);
	}

	public ScriptingTest scriptManager(ScriptManager scriptManager) {
		this.scriptManager = scriptManager;
		return this;
	}

	public void testScripter(Json json) {
		Equipment weapon = new Weapon("Doodles the PainBringer")
				.description("WTF").effect(new Effect("tickle", 0.25f))
				.element(new Element("love")).modifier(new Modifier("HP", 50))
				.location("Left Arm");
		WeaponManager weaponManager = new WeaponManager("weapons")
				.weapon((Weapon) weapon);
		
		scriptManager.weaponManager(weaponManager);
		
		scriptManager.writeScripts(json);
	}

	public ScriptManager getScriptManager() {
		return scriptManager;
	}
}
