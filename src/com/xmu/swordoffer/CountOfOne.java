package com.xmu.swordoffer;

public class CountOfOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 1, 10-19,21,31,41,51,61,71,81,91,
	 * 100-199£¬201,210-219,221,231,241,251,261,271,281,291, 301...991 1000-1999,
	 * 
	 */
	public int NumberOf1Between1AndN_Solution(int n) {
		if (n < 10)
			return n >= 1 ? 1 : 0;
		int times = (int) (Math.pow(10, String.valueOf(n).length() - 1));
		int a = n / times;
		int b = n % times;
		if (a == 1) {
			return NumberOf1Between1AndN_Solution(times-1)+1+b+NumberOf1Between1AndN_Solution(b);
		} else {
			return NumberOf1Between1AndN_Solution(times-1)*a+times+NumberOf1Between1AndN_Solution(b);
		}

	}
}
