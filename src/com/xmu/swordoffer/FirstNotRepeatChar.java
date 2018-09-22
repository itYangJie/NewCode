package com.xmu.swordoffer;



public class FirstNotRepeatChar {
	public int FirstNotRepeatingChar(String str) {
		
		int count[] = new int[255];
		for(char c:str.toCharArray()) {
			count[c]++;
		}
		for(int i=0;i<str.length();i++) {
			if(count[str.charAt(i)]==1)
				return i;
		}
		return -1;
    }
}
