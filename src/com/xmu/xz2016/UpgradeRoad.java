package com.xmu.xz2016;

import java.util.Scanner;

public class UpgradeRoad {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int a = in.nextInt();
			
			int[] b = new int[n];
			for(int i=0;i<n;i++)
				b[i] = in.nextInt();
			
			for(int i=0;i<n;i++) {
				if(b[i]<=a) {
					a += b[i];
				}else
					a += gcd(b[i],a);
			}
			System.out.println(a);
		}
	}
	
	private static int gcd(int a, int b) {
		int r = a%b;
		while(r!=0) {
			a = b;
			b = r;
			r = a%b;
		}
		return b;
	}

}
