package com.xmu.xz2017;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;


public class SeqSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			double n = in.nextDouble(),m = in.nextInt();
			double sum = 0;
			for(int i=0;i<m;i++) {
				sum += n;
				n = Math.sqrt(n);
			}
			System.out.println(String.format("%.2f", sum));
		}
	}

}
