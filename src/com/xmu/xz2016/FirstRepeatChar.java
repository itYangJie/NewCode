package com.xmu.xz2016;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FirstRepeatChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public char findFirstRepeat(String A, int n) {
		Set<Character> set = new HashSet<>();
		for(char c : A.toCharArray()) {
			if(set.contains(c))
				return c;
			set.add(c);
		}
		return 'n';
    }
}
