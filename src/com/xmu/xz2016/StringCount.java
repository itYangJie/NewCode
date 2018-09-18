package com.xmu.xz2016;

import java.util.Scanner;


public class StringCount {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String s = scan.nextLine();
        String[] array = s.split(" ");
     
        long count = solve(array);
        System.out.println(count);
    }

	private static long solve(String[] array) {
		String s1 = array[0],s2 = array[1];
		
		int min = Integer.parseInt(array[2]);
		int max = Integer.parseInt(array[3]);
		
		for(int i=0;i<max-s1.length();i++)
			s1 = s1+"a";
		for(int i=0;i<max-s2.length();i++)
			s2 = s2+"a";
		long count = 0;
		for(int len=min;len<=max;len++) {
			for(int i=0;i<len;i++) {
				count = count+(long)((s2.charAt(i)-s1.charAt(i))*Math.pow(26, len-i-1));
			}
			count--;
			if(len>s1.length())
				count++;
			if(len<s2.length())
				count++;
		}
		return count%1000007;
	}

 
}
