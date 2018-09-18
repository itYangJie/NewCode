package com.xmu.xz2016;

import java.util.Scanner;

public class CropGrid {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int minX=Integer.MAX_VALUE,minY=Integer.MAX_VALUE,
				maxX=Integer.MIN_VALUE,maxY=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			int x=in.nextInt(),y=in.nextInt();
			minX = Math.min(minX, x);
			maxX = Math.max(maxX, x);
			minY = Math.min(minY, y);
			maxY = Math.max(maxY, y);
		}
		int l = Math.max(maxX-minX, maxY-minY);
		System.out.println(l*l);
	}

}
