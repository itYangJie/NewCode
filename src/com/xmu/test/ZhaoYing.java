package com.xmu.test;

import java.util.Scanner;

public class ZhaoYing {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int num = 1;
			StringBuffer sb = new StringBuffer();
			while(true) {
				int temp = trailingZeroes(num);
				if(temp==n) {
					sb.append(num+" ");
				}else if(temp>n) {
					break;
				}
				num++;
			}
			System.out.println(sb.toString().trim());
		}

	}

	public static int trailingZeroes(int n) {
		int count = 0;
		while (n != 0) {
			count += n / 5;
			n = n / 5;
		}
		return count;
	}

}
