package com.parlect.pk.api;

/**
 * This interface will be implemented by all the commands used by the CommandHandler.
 * The commands implmenting this interface, has to be registered with the CommandRegistry.
 * @author Nacorpio
 */
public interface ICommand {

	/**
	 * Returns the name of the command.
	 * @return the name.
	 */
	String getName();
	
	/**
	 * Returns the maximum amount of arguments that can be used
	 * with this command.
	 * @return the maximum amount of arguments.
	 */
	int getMaxArgs();
	
	/**
	 * Returns the permissions needed for this command to be executed.
	 * @return the permissions.
	 */
	IPermission[] getPermissions();
	
	/**
	 * Occurs when the command is executed.
	 * @param par1 the client.
	 * @param par2 the arguments.
	 */
	void execute(int par1, String... par2);
	
}
