package com.xmu.swordoffer;

public class TwoDimArrayLookup {

	public static void main(String[] args) {

	}
	public boolean Find(int target, int [][] array) {
		int n = array.length;
		int m = array[0].length;
		
		int i=n-1,j=0;
		while(i>=0 && j<m) {
			if(array[i][j]==target)
				return true;
			if(array[i][j]>target)
				i--;
			else
				j++;
		}
		return false;
    }
}
