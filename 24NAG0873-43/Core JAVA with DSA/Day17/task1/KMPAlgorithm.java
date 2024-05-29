package com.day17.task1;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {
	public List<Integer> KMPSearch(String txt,String pattern) {
		List<Integer> list = new ArrayList<>();
		if(txt.length()==0 || pattern.length()==0 )
			return list;
		int n=txt.length();
		int m=pattern.length();
		
		int[] lps = computeLPSArray(pattern);
		int i=0;
		int j=0;
		while(i<n) {
			if(pattern.charAt(j)==txt.charAt(i)) {
				i++;
				j++;
			}
			if(j==m) {
				list.add(i-j);
				j=lps[j-1];
			}
			else if(i<n && pattern.charAt(j)!=txt.charAt(i)) {
				if(j!=0)
					j=lps[j-1];
				else
					i=i+1;
			}
		}
		return list;
	}
	public int[] computeLPSArray(String pat) {
		int[] lps=new int[pat.length()];
		int len=0;
		int i=1;
		
		while(i<pat.length()) {
			if(pat.charAt(i)==pat.charAt(len)) {
				len++;
				lps[i]=len;
				i++;
			}else {
				if(len!=0)
					len=lps[len-1];
				else {
					lps[i]=len;
					i++;
				}
			}
		}
		return lps;
	}
	
	public static void main(String[] args) {
		KMPAlgorithm kmp = new KMPAlgorithm();
		String txt="ABABDDCDABAADCDABABABA";
		String pat="DCDABA";
		
		List<Integer> search = kmp.KMPSearch(txt, pat);
		if(search.isEmpty())
			System.out.println("Pattern not found in the text..");
		else
			System.out.println("Patten found at: "+search);
	}
}
