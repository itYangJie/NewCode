package com.xmu.xz2016;

import java.util.Scanner;

public class FortAttack {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int R = in.nextInt();
			int x1 = in.nextInt(),y1 = in.nextInt();
			int x2 = in.nextInt(),y2 = in.nextInt();
			int x3 = in.nextInt(),y3 = in.nextInt();
			int x0 = in.nextInt(),y0 = in.nextInt();
			
			double dis1 = computeDis(x1,y1,x0,y0);
			double dis2 = computeDis(x2,y2,x0,y0);
			double dis3 = computeDis(x3,y3,x0,y0);
			
			int res = 0;
			if(!(dis1>R))
				res++;
			if(!(dis2>R))
				res++;
			if(!(dis3>R))
				res++;
			System.out.println(res+"x");
		}

	}

	private static double computeDis(int x1, int y1, int x2, int y2) {
		int dx = x1-x2,dy = y1-y2;
		return Math.sqrt(dx*dx+dy*dy);
	}

}
