package com.parlect.pk.permission;

import com.parlect.pk.api.IPermission;
import com.parlect.pk.rank.EnumRank;

public class PermissionRank implements IPermission {

	@Override
	public boolean isDefault() {
		return false;
	}

	@Override
	public EnumRank[] getRank() {
		return new EnumRank[] {EnumRank.MODERATOR, EnumRank.ADMINISTRATOR};
	}

	@Override
	public String getPermission() {
		return "perm.rank";
	}

}
