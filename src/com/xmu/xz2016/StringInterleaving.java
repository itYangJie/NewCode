package com.xmu.xz2016;

public class StringInterleaving {

	public static void main(String[] args) {
		System.out.println(new StringInterleaving().chkMixture("ABC",3,"12C",3,"A12BCC",6));

	}

	public boolean chkMixture(String A, int n, String B, int m, 
			String C, int v) {
		if(n + m != v) return false;
		
		return solve(A,0,B,0,C,0);
	}

	private boolean solve(String a, int indA, String b, int indB, 
			String c, int indC) {
		
		while(indA<a.length()&&indB<b.length()&&indC<c.length()) {
			char charA = a.charAt(indA);
			char charB = b.charAt(indB);
			char charC = c.charAt(indC);
			if(charC!=charA && charC!=charB)
				return false;
			if(charA==charB) {
				return solve(a,indA,b,indB+1,c,indC+1) || solve(a,indA+1,b,indB,c,indC+1);
			}else {
				if(charA==charC)
					indA++;
				else
					indB++;
				indC++;
			}
		}
		if(indA<a.length()) {
			while(indA<a.length() && indC<c.length() && a.charAt(indA)==c.charAt(indC)) {
				indA++;
				indC++;
			}
			if(indA==a.length() && indC==c.length())
				return true;
			else
				return false;
		}else {
			while(indB<b.length() && indC<c.length() && b.charAt(indB)==c.charAt(indC)) {
				indB++;
				indC++;
			}
			if(indB==b.length() && indC==c.length())
				return true;
			else
				return false;
		}
	}
}
