package com.xmu.leetcode;

import java.util.Stack;

public class EvalReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		int len = tokens.length;
		for(int i=0;i<len;i++) {
			String s = tokens[i];
			if("+".equals(s)) {
				int num2 = stack.pop();
				int num1 = stack.pop();
				stack.push(num1+num2);
			}else if("-".equals(s)) {
				int num2 = stack.pop();
				int num1 = stack.pop();
				stack.push(num1-num2);
			}else if("*".equals(s)) {
				int num2 = stack.pop();
				int num1 = stack.pop();
				stack.push(num1*num2);
			}else if("/".equals(s)) {
				int num2 = stack.pop();
				int num1 = stack.pop();
				stack.push(num1/num2);
			}else {
				stack.push(Integer.parseInt(s));
			}
		}
		return stack.pop();
	}
}
