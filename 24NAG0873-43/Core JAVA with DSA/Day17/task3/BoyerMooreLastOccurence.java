package com.day17.task3;

import java.util.Arrays;

public class BoyerMooreLastOccurence {
	public int lastOccurence(String text,String pattern) {
		int n=text.length();
		int m=pattern.length();
		if(m==0) return 0;
		if(n<m) return -1;
		
		int[] lastOcc=preprocessLastOccurence(pattern);
		
		int i=m-1;
		int j=m-1;
		
		while(i<n) {
			if(text.charAt(i)==pattern.charAt(j)) {
				if(j==0)
					return i;
				i--;
				j--;
			}else {
				i+=m-Math.min(j, 1+lastOcc[text.charAt(i)]);
				j=m-1;
			}
		}
		return -1;
	}

	private int[] preprocessLastOccurence(String pattern) {
		int[] lastOcc=new int[256];
		Arrays.fill(lastOcc, -1);
		for(int i=0;i<pattern.length();i++)
			lastOcc[pattern.charAt(i)]=i;
		return lastOcc;
	}
	public static void main(String[] args) {
		BoyerMooreLastOccurence occurence = new BoyerMooreLastOccurence();
		String text="ABACADABRAC";
		String pattern="ABRA";
		
		int lastOccurence = occurence.lastOccurence(text, pattern);
		if(lastOccurence!=-1)
			System.out.println("Last ocuurence found at: "+lastOccurence);
		else
			System.out.println("Pattern not found");
	}
}
/*Explanation:
 * preprocesssLastOcuurence: This method preprocesses the pattern to
 * calculate the last ocuurence of each character in the pattern. This 
 * information is stored in an array for quick lookup during the search phase.
 * LastOcuurence: This method performs the actual search using the Boyer-
 * Moore algorithm. It iterates through the text and pattern, comparing characters
 * from right to left. If a mismatch occurs, it uses the precomputes table to skip
 * multiple charcters in the text based on the last occurence of the mismatched 
 * charcter in the pattern.
 */
