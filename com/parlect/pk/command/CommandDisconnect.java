package com.parlect.pk.command;

import com.parlect.pk.Client;
import com.parlect.pk.Start;
import com.parlect.pk.api.ICommand;
import com.parlect.pk.api.IPermission;

public class CommandDisconnect implements ICommand {

	@Override
	public String getName() {
		return "disconnect";
	}

	@Override
	public int getMaxArgs() {
		return 0;
	}

	@Override
	public IPermission[] getPermissions() {
		return null;
	}

	@Override
	public void execute(int par1, String... par2) {
		Client var1 = Start.connectionHnd.connections.get(par1);
		var1.send("Disconnected from server.");
		var1.disconnect();
	}

}
