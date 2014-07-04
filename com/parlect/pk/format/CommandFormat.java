package com.parlect.pk.format;

import java.util.Arrays;
import java.util.List;

public final class CommandFormat {
	
	public static final String COMMAND_REGEX = "\\/(.*?)\\s?(.*?)$";
	
	public static final String getName(String par1) {
		/*
		 * Command: /name {arg1} {arg2}..
		 */
		if (isCommand(par1)) {
			
			String[] var1 = par1.substring(par1.indexOf("/") + 1, par1.length()).split(" ");
			return var1[0];
			
		}	
		return null;
	}
	
	public static final boolean hasArguments(String par1) {
		return par1.substring(par1.indexOf("/") + 1, par1.length()).split(" ").length > 1;
	}
	
	public static final String[] getArguments(String par1) {
		/*
		 * Command: /name {arg1} {arg2}..
		 */
		if (isCommand(par1)) {
			
			String[] var1 = par1.substring(par1.indexOf("/") + 1, par1.length()).split(" ");
			List<String> var2 = Arrays.asList(var1);
			
			var2.remove(0);
			return (String[]) var2.toArray();
			
		}
		return null;
	}
	
	public static final boolean isCommand(String par1) {
		return par1.matches(COMMAND_REGEX);
	}
	
}
