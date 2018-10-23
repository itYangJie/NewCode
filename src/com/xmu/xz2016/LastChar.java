package com.xmu.xz2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LastChar {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for(int i=0;i<t;i++) {
			System.out.println(solve(reader.readLine()));
		}

	}
	private static char solve(String s) {
		int len = s.length();
		int[] map = new int[255];
		for(int i=0;i<len;i++) {
			map[s.charAt(i)]++;
		}
		for(int i=0;i<len;i++) {
			if(map[s.charAt(i)]==1)
				return s.charAt(i);
		}
		return '0';
	}
}
