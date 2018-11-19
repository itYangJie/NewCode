package com.xmu.leetcode;

public class StudentAttend {
	public static void main(String[] args) {
		checkRecord("PPALLP");
		System.out.println(Long.MAX_VALUE);
	}
	public static boolean checkRecord(String s) {

		int ind = 0;
		int len = s.length();

		int countA = 0;
		int continueL = 0;
		while (ind < len) {
			char c = s.charAt(ind);
			if (c == 'A') {
				continueL = 0;
				countA++;
				if (countA > 1)
					return false;
			} else if (c == 'p') {
				continueL = 0;
			} else {
				continueL++;
				if (continueL > 2)
					return false;
			}
			ind++;
		}
		return true;
	}
}
