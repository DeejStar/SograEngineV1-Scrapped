package com.soginteractive.engine.core.managers;

import com.badlogic.gdx.utils.Json;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.core.misc.managers.EffectManager;
import com.soginteractive.engine.core.misc.managers.ElementManager;
import com.soginteractive.engine.core.misc.managers.ModifierManager;
import com.soginteractive.engine.core.misc.managers.RequirementManager;
import com.soginteractive.engine.core.misc.managers.RestrictionManager;

public abstract class EquipmentManager extends AbstractManager {

	private RequirementManager requirementManager;
	private ModifierManager modifierManager;
	private RestrictionManager restrictionManager;
	private ElementManager elementManager;
	private EffectManager effectManager;

	public EquipmentManager(String path) {
		super(path);
	}

	public EquipmentManager requirementManager(
			RequirementManager requirementManager) {
		this.requirementManager = requirementManager;
		return this;
	}

	public EquipmentManager modifierManager(ModifierManager modifierManager) {
		this.modifierManager = modifierManager;
		return this;
	}

	public EquipmentManager restrictionManager(
			RestrictionManager restrictionManager) {
		this.restrictionManager = restrictionManager;
		return this;
	}

	public EquipmentManager elementManager(ElementManager elementManager) {
		this.elementManager = elementManager;
		return this;
	}

	public EquipmentManager effectManager(EffectManager effectManager) {
		this.effectManager = effectManager;
		return this;
	}

	public RequirementManager getRequirementManager() {
		return requirementManager;
	}

	public ModifierManager getModifierManager() {
		return modifierManager;
	}

	public RestrictionManager getRestricitonManager() {
		return restrictionManager;
	}

	public ElementManager getElementManager() {
		return elementManager;
	}

	public EffectManager getEffectManager() {
		return effectManager;
	}

	@Override
	public void writeAllScripts(Json json) {
		super.writeAllScripts(json);
		checkManagersForWriting(json);
	}

}
