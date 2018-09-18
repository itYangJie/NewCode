package com.xmu.xz2016;

import java.util.HashSet;
import java.util.Scanner;

public class CharSet {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String str = in.nextLine();
			StringBuffer sb = new StringBuffer();
			HashSet<Character> set = new HashSet<>();
			for(char c:str.toCharArray()) {
				if(set.contains(c))
					continue;
				sb.append(c);
				set.add(c);
			}
			System.out.println(sb.toString());
		}
	}

}
