package com.xmu.interviewgold;

import java.util.ArrayList;
import java.util.Stack;

public class TwoStackSort {
	
	public ArrayList<Integer> twoStacksSort(int[] numbers) {
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> help = new Stack<Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < numbers.length; i++) {
			s.push(numbers[i]);
		}
		while (!s.isEmpty()) {
			int ele = s.pop();
			while (!help.isEmpty() && ele < help.peek())
				s.push(help.pop());
			help.push(ele);
		}
		while (!help.isEmpty())
			res.add(help.pop());
		return res;
	}
}
