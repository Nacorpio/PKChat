package com.parlect.pk.api;

import com.parlect.pk.rank.EnumRank;

public interface IPermission {

	/**
	 * Returns whether this permission is assigned to the client at joining.
	 * @return true/false.
	 */
	boolean isDefault();

	/**
	 * Returns the ranks that will use these permission, which means that if you
	 * get assigned one of the ranks in this array, you'll have this permission.
	 * @return the ranks.
	 */
	EnumRank[] getRank();
	
	/**
	 * Returns the permission in a String format.
	 * @return the permission.
	 */
	String getPermission();
	
}
