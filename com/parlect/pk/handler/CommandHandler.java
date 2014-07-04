package com.parlect.pk.handler;

import java.util.HashMap;
import java.util.Map;

import com.parlect.pk.api.ICommand;
import com.parlect.pk.command.CommandDisconnect;
import com.parlect.pk.format.CommandFormat;

public final class CommandHandler {
	
	public static final Map<String, ICommand> registry = new HashMap<String, ICommand>();
	
	static {
		register("disconnect", new CommandDisconnect());
	}
	
	public static final void register(String par1, ICommand par2) {
		registry.put(par1, par2);
	}
	
	public static final boolean isRegistered(String par1) {
		return registry.containsKey(par1);
	}
	
	public static final ICommand get(String par1) {
		return registry.get(par1);
	}
	
	/**
	 * Occurs when a command has been received by a client.
	 * @param par1 the command that was launched.
	 * @param par2 the arguments that were added.
	 */
	public static void onCommandReceived(int par1, String par2) {
		if (CommandFormat.isCommand(par2)) {
			String name = CommandFormat.getName(par2);
			ICommand command = get(name);
			if (CommandFormat.hasArguments(par2)) {
				command.execute(par1, CommandFormat.getArguments(par2));
			} else {
				command.execute(par1);
			}
		}
	}
	
	/**
	 * Occurs when a command has been received by a client (without arguments).
	 * @param par1 the command that was launched.
	 */
	public static void onCommandReceived(ICommand par1) {}
	
}
