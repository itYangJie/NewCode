package com.xmu.xz2017;

import java.util.Scanner;

public class LuckNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count = 0;
		for(int i=1;i<=n;i++) {
			int temp = i,sumTen = 0,sumTwo = 0;
			while(temp>=10) {
				sumTen = sumTen+temp%10;
				temp = temp/10;
			}
			sumTen = sumTen+temp;
			
			temp = i;
			while(temp>=2) {
				sumTwo = sumTwo+temp%2;
				temp = temp/2;
			}
			sumTwo = sumTwo+temp;
			
			if(sumTen==sumTwo)
				count++;
		}
		System.out.println(count);
	}

}
