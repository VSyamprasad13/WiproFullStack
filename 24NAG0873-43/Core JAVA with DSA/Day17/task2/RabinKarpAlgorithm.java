package com.day17.task2;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpAlgorithm {
	private final static int d=256;
	private final static int q=101;
	
	public List<Integer> search(String text,String pattern){
		int i,j = 0;
		int p=0;
		int t=0;
		int h=1;
		
		List<Integer> result=new ArrayList<Integer>();
		
		for(i=0;i<pattern.length()-1;i++)
			h=(h*d)%q;
		
		for(i=0;i<pattern.length();i++) {
			p=(d*p+pattern.charAt(i))%q;
			t=(d*t+text.charAt(i))%q;
		}
		for(i=0;i<text.length()-pattern.length();i++) {
			if(p==t) {
				for(j=0;j<pattern.length();j++)
					if(text.charAt(i+j)!=pattern.charAt(j))
						break;
			if(j==pattern.length())
				result.add(i);
			}
			else {
				t=(d*(t-text.charAt(i)*h)+text.charAt(i+1))%q;
				if(t<0)
					t=t+q;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		RabinKarpAlgorithm rk = new RabinKarpAlgorithm();
		
		String text="GEEKS FOR GEEKS";
		String pattern="GEEK";
		
		List<Integer> search = rk.search(text, pattern);
		
		if(search.isEmpty())
			System.out.println("Pattern Not found");
		else
			System.out.println("Pattern found at: "+search);
	}
}
/*
 * Explanation:
 * First we calculate the hash values for both given string of length pattern and patten
 * Then we check for same hash value
 * If we get hash value same for both substring and pattern
 * Then we check whether the characters are same or not
 * If same we print pattern matched message with index
 * Otherwise we move one index of the string and repeat the process until we get matched pattern in the string
 */
