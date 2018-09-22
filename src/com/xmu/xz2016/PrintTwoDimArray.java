package com.xmu.xz2016;

import java.util.Arrays;

public class PrintTwoDimArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(arrayPrint(new int[][] {
			{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}
		},4)));
	}
	
    // 1  2  3  4
    // 5  6  7  8
    // 9  10 11 12
    // 13 14 15 16
	public static int[] arrayPrint(int[][] arr, int n) {
		if(n==1)
			return new int[] {arr[0][0]};
		int nums[] = new int[n*n];
		
		int ind = 0;
		for(int j=n-1;j>=0;j--) {
			int x = 0,y = j;
			while(x<n && y<n) {
				nums[ind++] = arr[x][y];
				x++;y++;
			}
		}
		for(int i=1;i<n;i++) {
			int x = i,y = 0;
			while(x<n && y<n) {
				nums[ind++] = arr[x][y];
				x++;y++;
			}
		}
		return nums;
	}
}
