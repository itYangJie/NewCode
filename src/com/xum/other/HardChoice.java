package com.xum.other;

import java.util.Scanner;

public class HardChoice {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for(int i=0;i<n;i++)
			A[i] = in.nextInt();
		int count = 0;
		for(int i=0;i<n;i++) {
			int temp = A[i];
			while(temp%2==0) {
				count++;
				temp /= 2;
			}
		}
		System.out.println(count);
	}
}
