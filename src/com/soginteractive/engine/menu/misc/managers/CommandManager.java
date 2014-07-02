package com.soginteractive.engine.menu.misc.managers;

import com.badlogic.gdx.utils.Array;
import com.soginteractive.engine.core.AbstractManager;
import com.soginteractive.engine.menu.misc.Command;

public class CommandManager extends AbstractManager {

	private Array<Command> commands;

	public CommandManager(String path) {
		super(path);
		commands = new Array<Command>();
	}

	public CommandManager command(Command command) {
		this.commands.add(command);
		return this;
	}

	public Array<Command> getCommands() {
		return commands;
	}

}
