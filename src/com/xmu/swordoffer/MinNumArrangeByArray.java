package com.xmu.swordoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MinNumArrangeByArray {

	public static void main(String[] args) {
		System.out.println(PrintMinNumber(new int[] {3,32,321}));
	}
	public static String PrintMinNumber(int [] numbers) {
		int n = numbers.length;
		ArrayList<String> nums = new ArrayList<>();
		for(int i=0;i<n;i++)
			nums.add(""+numbers[i]);
		Collections.sort(nums, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.parseInt(o1+o2)-Integer.parseInt(o2+o1);
			}
		});
		StringBuffer sb = new StringBuffer();
		for(String str:nums)
			sb.append(str);
		return sb.toString();
    }
}
