package com.day18.task1;

public class BitManipulation {

	public static void main(String[] args) {
		int num=10;
		System.out.println("The total number of set bits"
				+ " from 1 to "+num+" are "+countTotalSetBit(num));
	}
	private static int countTotalSetBit(int num) {
		int count=0;
		for(int i=1;i<=num;i++) {
			count+=countSetBits(i);
		}
		return count;
	}
	private static int countSetBits(int num) {
		int temp=num;
		int count=0;
		while(num>0) {
			count+=(num&1);
//			num=num>>1;
		}
		System.out.println("The set bits in "+temp+" are "+count);
		return count;
	}

}
