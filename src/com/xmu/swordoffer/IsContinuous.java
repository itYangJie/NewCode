package com.xmu.swordoffer;

import java.util.Arrays;

public class IsContinuous {

	public static void main(String[] args) {
		System.out.println(new IsContinuous().isContinuous(new int[] {1,3,0,0,5}));

	}
	public boolean isContinuous(int [] numbers) {
		if(numbers.length<5)
			return false;
		Arrays.sort(numbers);
		int countKing = 0;
		int ind = 0;
		while(ind<5) {
			if(numbers[ind]==0) {
				countKing++;
				ind++;
			}else
				break;
		}
		
		int needCount = 0;
		while(ind<4) {
			if(numbers[ind+1]==numbers[ind])
				return false;
			needCount = needCount+numbers[ind+1]-numbers[ind]-1;
			ind++;
		}
		if(needCount<=countKing)
			return true;
		return false;
    }
}
