package com.day16.task2;

public class StringOperations {
	public static void main(String[] args) {
		String s1="syam ";
		String s2="prasad";
		
		operations(s1,s2,5);
	}

	public static void operations(String s1, String s2,int length) {
//		Concatenating the strings using third string
		String concat;
		if(s1.length()==0&&s2.length()==0) 
			throw new NullPointerException("Empty strings");
		else if(s1.length()==0)
			concat=s2;
		else if(s2.length()==0)
			concat=s1;
		else
			concat=s1+s2;
		
//		Reversing the string
		System.out.println("Before: "+concat);
		String reversed="";
		for(int i=concat.length()-1;i>=0;i--)
			reversed+=concat.charAt(i);
		
		System.out.println("After: "+reversed);
		
//		Extracting the middle substring of given length
		String middle = "";
		int mid=reversed.length()/2;
		int start=mid-length/2;
		int end=start+length;
		
		if(reversed.length()==0 || length>reversed.length())
			System.out.println("Invalid input");
		if(length>concat.length())
			System.out.println("Substring length is greater than concatenated string");
		for(int i=start;i<end;i++) {
			middle+=reversed.charAt(i);
		}
		System.out.println("Middle string: "+middle);
	}
}
