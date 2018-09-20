package com.xmu.swordoffer;

import java.util.Stack;

public class StackIncludeMin {
	
	private Stack<Integer> eles = new Stack<>();
	private Stack<Integer> mins = new Stack<>();
	
	public void push(int node) {
		eles.push(node);
		if(mins.isEmpty())
			mins.push(node);
		else
			mins.push(Math.min(mins.peek(), node));
	}

	public void pop() {
		mins.pop();
		eles.pop();
	}

	public int top() {
		return eles.peek();
	}

	public int min() {
		return mins.peek();
	}
}
