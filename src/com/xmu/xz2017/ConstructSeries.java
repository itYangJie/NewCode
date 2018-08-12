package com.xmu.xz2017;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;


public class ConstructSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int k=0;k<T;k++) {
			int n = in.nextInt();
			Deque<Integer> q = new ArrayDeque<Integer>();
			for(int j=n;j>=1;j--) {
				q.addFirst(j);
				int temp = q.removeLast();
				q.addFirst(temp);
			}
			int size = q.size();
			for(int i=0;i<size-1;i++)
				System.out.print(q.pop()+" ");
			System.out.print(q.pop());
			System.out.println();
		}
	}

}
