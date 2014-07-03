package com.parlect.pk.command;

import com.parlect.pk.api.IClient;
import com.parlect.pk.api.ICommand;
import com.parlect.pk.api.IPermission;

public class CommandKick implements ICommand {

	@Override
	public String getName() {
		return "kick";
	}

	@Override
	public int getMaxArgs() {
		return 2;
	}

	@Override
	public void execute(IClient par1, String... par2) {
		
	}

	@Override
	public void execute(IClient par1) {
		
	}

	@Override
	public IPermission[] getPermissions() {
		return new IPermission[]{};
	}

}
