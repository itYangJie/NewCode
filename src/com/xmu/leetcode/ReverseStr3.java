package com.xmu.leetcode;

public class ReverseStr3 {
	public static void main(String[] args) {
		new ReverseStr3().reverseWords("Let's take LeetCode contest");
	}
	public String reverseWords(String s) {
		StringBuffer sb = new StringBuffer(s);
		s = sb.reverse().toString();

		String[] splits = s.split(" ");
		int len = splits.length;
		for (int i = 0; i < len/2; i++) {
			// i <-> len-1-i
			String temp = splits[i];
			splits[i] = splits[len - 1 - i];
			splits[len - 1 - i] = temp;
		}
		sb = new StringBuffer();
		for (int i = 0; i < len; i++)
			sb.append(splits[i] + " ");
		return sb.toString().trim();
	}
}
