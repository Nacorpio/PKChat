package com.parlect.pk.format;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static class Group {
		
		private String name;
		private String value;
		
		private int startIndex;
		private int endIndex;
		
		public Group(String par1, int par2, int par3) {
			this.value = par1;
			this.startIndex = par2;
			this.endIndex = par3;
		}
		
		@Deprecated
		public Group(String par1, String par2) {
			this.name = par1;
			this.value = par2;
		}
		
		public final int getStartIndex() {
			return startIndex;
		}
		
		public final int getEndIndex() {
			return endIndex;
		}
		
		public final String getName() {
			return this.name;
		}
		
		public final String getValue() {
			return this.value;
		}
		
	}
	
	public static class Match {
	
		private String value;
		private List<Group> groups = new ArrayList<Group>();
		
		private int length;
		private int index;
		
		private int startIndex;
		private int endIndex;
		
		public Match(String par1, int par2, int par3, int par4, int par5) {
			this.value = par1;
			this.length = par2;
			this.index = par3;
			this.startIndex = par4;
			this.endIndex = par5;
		}
		
		private final void addGroup(Group par1) {
			this.groups.add(par1);
		}
		
		public final Group getGroup(int par1) {
			return groups.get(par1);
		}
		
		public final int getStartIndex() {
			return startIndex;
		}
		
		public final int getEndIndex() {
			return endIndex;
		}
		
		public final String getValue() {
			return value;
		}
		
		public final int getLength() {
			return length;
		}
		
		public final int getIndex() {
			return index;
		}
		
	}
	
	private String pattern;
	
	/**
	 * Creates a new regular-expression with the specified pattern.
	 * @param par1 the regular-expression pattern.
	 */
	public RegularExpression(String par1) {
		this.pattern = par1;
	}
	
	/**
	 * Returns the matches that matched the pattern in the specified text.
	 * @param par1 the String to find the matches within.
	 * @return the matches.
	 */
	public final List<Match> getMatches(String par1) {
		
		List<Match> results = new ArrayList<Match>();
		
		Pattern var1 = Pattern.compile(pattern);
		Matcher var2 = var1.matcher(par1);
		
		int m = 0;
		while (var2.find()) {
		
			String varGroup1 = var2.group();
			Match varMatch1 = new Match(varGroup1, varGroup1.length(), m, var2.start(), var2.end());
	
			for (int i = 0; i < var2.groupCount(); i++) {
				varMatch1.addGroup(new Group(var2.group(i), var2.start(i), var2.end(i)));
			}
			
			results.add(varMatch1);
			
			m++;
			
		}
		
		return results;
		
	}
	
	/**
	 * Returns whether the pattern matches the specified String.
	 * @param par1 the String.
	 * @return true/false.
	 */
	public final boolean match(String par1) {
		return par1.matches(pattern);
	}
	
	/**
	 * Returns the pattern used for finding the matches.
	 * @return the pattern.
	 */
	public final String getPattern() {
		return pattern;
	}
	
}
