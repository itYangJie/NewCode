package com.xmu.xz2017;

import java.util.Scanner;

public class SaveXiaoYI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] xi = new int[n];
		int[] yi = new int[n];
		for(int i=0;i<n;i++) {
			xi[i] = in.nextInt();
		}
		for(int i=0;i<n;i++) {
			yi[i] = in.nextInt();
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			int huffmanDistance = Math.abs(xi[i]-1)+Math.abs(yi[i]-1);
			if(huffmanDistance<min)
				min = huffmanDistance;
		}
		System.out.println(min);
	}

}
