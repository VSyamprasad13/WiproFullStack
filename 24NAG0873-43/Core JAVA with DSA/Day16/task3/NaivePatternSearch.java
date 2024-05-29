package com.day16.task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NaivePatternSearch {
	public static void search(String string,String pattern) {
		int n=string.length();
		int m=pattern.length();
		for(int i=0;i<n;i++) {
			int j;
			for(j=0;j<m;j++) {
				if(string.charAt(i+j)!=pattern.charAt(j))
					break;
			}
			if(j==m)
				System.out.println("Pattern found at "+i);
		}
	}
	public static void main(String[] args) {
		String s="AAABACACABAC";
		String p="ABA";
		
		search(s,p);
//		Using regular expression
		Pattern pattern = Pattern.compile(p);
		Matcher matcher = pattern.matcher(s);
		while(matcher.find())
			System.out.println("Pattern found at: "+matcher.start()
					+ " using regular expression "
					+ "ending at: "+matcher.end()+" pattern: "+matcher.group());
	}
}
