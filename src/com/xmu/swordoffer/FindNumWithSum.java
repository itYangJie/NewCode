package com.xmu.swordoffer;

import java.util.ArrayList;

public class FindNumWithSum {
	public static void main(String[] args) {

	}

	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int left = 0, right = array.length-1;
		while (left < right) {
			int cur = array[left]+array[right];
			if (cur < sum)
				left++;
			else if (cur > sum)
				right--;
			else {
				res.add(array[left]);
				res.add(array[right]);
				break;
			}
		}
		return res;
	}

	public String LeftRotateString(String str,int n) {
        n = n%str.length();
        if(n==0)
            return str;
        return str.substring(n)+str.substring(0,n);
    }
}
