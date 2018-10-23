package com.xum.other;

public class RearrangementSeries {

	public static void main(String[] args) {
		System.out.println(solve(new int[] {1,2,3,4}));

	}
	
	public static boolean solve(int[] A) {
		int count4 = 0;
		int countOdd = 0;
		int count2  =0;
		for(int i=A.length-1;i>=0;i--) {
			if(A[i]%2==1)
				countOdd++;
			else {
				if(A[i]%4==0)
					count4++;
				else
					count2++;
			}
		}
		return count4<countOdd-1 && (count2==0 || count4-countOdd>=0);
	}
}
