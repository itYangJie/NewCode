package com.xmu.xz2017;

import java.util.Scanner;

public class PalindromeSeq {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] items = new int[n];
		for(int i=0;i<n;i++)
			items[i] = in.nextInt();
		int count = 0;
		for(int left=0,right=n-1;left<right;) {
			if(items[left] == items[right]) {
				left++;
				right--;
				continue;
			}
			count++;
			if(items[left] < items[right]) {
				items[left+1] += items[left];
				left++;
			}else {
				items[right-1] += items[right];
				right--;
			}
		}
		System.out.println(count);
	}

}
