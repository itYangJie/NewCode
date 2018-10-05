package com.xmu.interviewgold;

public class DigitalPronunciation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private String[] belowTen = new String[] { "", "One", "Two", "Three", 
			"Four", "Five", "Six", "Seven", "Eight","Nine" };
	private String[] belowTwenty = new String[] { "Ten", "Eleven", "Twelve", 
			"Thirteen", "Fourteen", "Fifteen",
			"Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	private String[] belowHundred = new String[] { "", "Ten", "Twenty",
			"Thirty", "Forty", "Fifty", "Sixty", "Seventy",
			"Eighty", "Ninety" };

	public String toString(int x) {
		if (x == 0)
			return "Zero";
		return helper(x);
	}

	private String helper(int num) {
		String result = "";
		if (num < 10)
			result = belowTen[num];
		else if (num < 20)
			result = belowTwenty[num - 10];
		else if (num < 100)
			result = belowHundred[num / 10] + " " + helper(num % 10);
		else if (num < 1000)
			result = helper(num / 100) + " Hundred " + helper(num % 100);
		else if (num < 1000000)
			result = helper(num / 1000) + " Thousand" + 
					(num % 1000 > 0 ? "," : " ") + helper(num % 1000);
		else if (num < 1000000000)
			result = helper(num / 1000000) + " Million" + 
					(num % 1000000 > 0 ? "," : " ") + helper(num % 1000000);
		else
			result = helper(num / 1000000000) + " Billion " + 
					helper(num % 1000000000);
		return result.trim();
	}
}
