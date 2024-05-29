package com.day18.task2;

public class UniqueElementFinder {

	public static void main(String[] args) {
		int[] arr= {4,2,4,5,2,3,3,7};
		findNonRepeat(arr);
		
	}
	public static void findNonRepeat(int[] arr) {
		int xorResult=0;
		
		for(int n:arr) {
			xorResult^=n;
		}
		
		int setBit= xorResult & - xorResult;
		int x=0;
		int y=0;
		
		for(int n:arr) {
			if((n & setBit)==0)
				x^=n;
			else
				y^=n;
		}
		System.out.println("The two non repeating elements are "+x+" and "+y);
	}

}
