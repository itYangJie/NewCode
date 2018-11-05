package com.xmu.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsString {
	public static void main(String[] args) {
		new ReverseVowelsString().reverseVowels("hello");
	}
	public String reverseVowels(String s) {
		char[] chars = s.toCharArray();
		int left = 0,right = chars.length-1;
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		while(left<right) {
			while(left<right && !set.contains(chars[left]))
				left++;
			while(left<right && !set.contains(chars[right]))
				right--;
			if(left<right) {
				char temp = chars[right];
				chars[right] = chars[left];
				chars[left] = temp;
				left++;
				right--;
			}
		}
		return new String(chars);
	}
}
