package com.parlect.pk.handler;

import com.parlect.pk.api.ICommand;

public final class CommandHandler {

	/**
	 * Occurs when a command has been received by a client.
	 * @param par1 the command that was launched.
	 * @param par2 the arguments that were added.
	 */
	public void onCommandReceived(ICommand par1, String... par2) {}
	
	/**
	 * Occurs when a command has been received by a client (without arguments).
	 * @param par1 the command that was launched.
	 */
	public void onCommandReceived(ICommand par1) {}
	
}
