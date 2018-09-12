package com.xmu.xz2016;

public class KnowBinary {

	public static void main(String[] args) {
		System.out.println(countBitDiff(1999, 2299));
	}
    public static int countBitDiff(int m, int n) {
    	int count = 0;
    	for(int i=0;i<=31;i++) 
    		if(((m>>i)&1)!=((n>>i)&1))
    			count++;
    	return count;
    }
}
