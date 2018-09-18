package com.xmu.xz2016;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LegalExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public boolean chkLegal(String A) {
		 Stack<Character> stack = new Stack<>();
		 /*Map<Character, Character> map = new HashMap<>();
		 map.put('}', '{');
		 map.put(')', '(');
		 map.put(']', '[');*/
		 for(char c:A.toCharArray()) {
			 if(c=='{' || c=='(' || c=='[') {
				 stack.push(c);
				 continue;
			 }
			 if(c=='}' || c==')' || c==']') {
				 if(stack.isEmpty())
					 return false;
				 stack.pop();
			 }
		 }
		 return true;
	 }
}
