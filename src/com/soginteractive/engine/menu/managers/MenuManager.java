package com.soginteractive.engine.menu.managers;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.menu.Menu;
import com.soginteractive.engine.menu.entities.managers.BackgroundManager;
import com.soginteractive.engine.menu.entities.managers.TextManager;
import com.soginteractive.engine.menu.misc.managers.CommandManager;

public class MenuManager extends AbstractManager {

	private Array<Menu> menus;

	private BackgroundManager backgroundManager;
	private CommandManager commandManager;
	private TextManager textManager;

	public MenuManager(String path) {
		super(path);
		menus = new Array<Menu>();
	}

	public MenuManager menu(Menu menu) {
		menus.add(menu);
		return this;
	}

	public MenuManager backgroundManager(BackgroundManager backgroundManager) {
		this.backgroundManager = backgroundManager;
		return this;
	}

	public MenuManager commandManager(CommandManager commandManager) {
		this.commandManager = commandManager;
		return this;
	}

	public MenuManager textManager(TextManager textManager) {
		this.textManager = textManager;
		return this;
	}

	public Array<Menu> getMenus() {
		return menus;
	}

	public BackgroundManager getBackgroundManager() {
		return backgroundManager;
	}

	public CommandManager getCommandManager() {
		return commandManager;
	}

	public TextManager getTextManager() {
		return textManager;
	}

}
