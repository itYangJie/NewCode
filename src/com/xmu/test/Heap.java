package com.xmu.test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class Heap {
	
	public static void main(String[] args) {
	
		Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		q.add(5);
		q.add(-2);
		q.add(10);
		q.add(7);
		System.out.println(q.remove());
		q.add(-9);
		q.add(10);
		while(!q.isEmpty())
			System.out.println(q.remove());
	}

}
