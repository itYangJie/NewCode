package com.xmu.xz2016;

import java.util.Scanner;

public class MovingRoundTable {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int r = in.nextInt();
			int x = in.nextInt(),y = in.nextInt();
			int x1 = in.nextInt(),y1 = in.nextInt();
			double distance = Math.sqrt(Math.pow(x-x1,2)+Math.pow(y-y1,2));
			int count = (int) (distance/2/r);
			if(2*r*count<distance)
				count++;
			System.out.println(count);
		}
	}

}
