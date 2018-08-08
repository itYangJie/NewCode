package com.xmu.xz2017;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class NumberStr implements Comparator<Integer> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			Integer[] num = new Integer[n];
			for(int i=0;i<n;i++) {
				num[i] = in.nextInt();
			}
			Arrays.sort(num,new NumberStr());
			StringBuffer sb = new StringBuffer();
			for(int i=n-1;i>=0;i--)
				sb.append(String.valueOf(num[i]));
			System.out.println(sb.toString());
		}
	}


	@Override
	public int compare(Integer o1, Integer o2) {
		String str1 = String.valueOf(o1)+String.valueOf(o2);
		String str2 = String.valueOf(o2)+String.valueOf(o1);
		return str1.compareTo(str2);
	}
}
