package com.parlect.pk.rank;

public enum EnumRank {

	GUEST(0, "Guest", true),
	MODERATOR(1, "Moderator"),
	ADMINISTRATOR(2, "Administrator");
	
	private int id;
	private String name;
	private boolean def;
	
	EnumRank(int par1, String par2, boolean par3) {
		id = par1;
		name = par2;
		def = par3;
	}
	
	EnumRank(int par1, String par2) {
		this(par1, par2, false);
	}
	
	/**
	 * Returns the rank with the specified name.
	 * @param par1 the name.
	 * @return the rank.
	 */
	public final EnumRank getRank(String par1) {
		for (EnumRank var: values()) {
			if (var.name == par1)
				return var;
		}
		return null;
	}
	
	/**
	 * Returns the rank with the specified id.
	 * @param par1 the id.
	 * @return the rank.
	 */
	public final EnumRank getRank(int par1) {
		for (EnumRank var: values()) {
			if (var.id == par1) 
				return var;
		}
		return null;
	}
	
	/**
	 * Returns the id of the rank.
	 * @return the id.
	 */
	public final int getId() {
		return id;
	}
	
	/**
	 * Returns the name of the rank.
	 * @return the name.
	 */
	public final String getName() {
		return name;
	}
	
	/**
	 * Returns whether this rank will be assigned to the client when joining.
	 * @return if the rank is default.
	 */
	public final boolean isDefault() {
		return def;
	}
	
}
