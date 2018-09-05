package com.xmu.xz2017;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StatisticalChar {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		str = str.replaceAll(" ", "");
		Map<Character,Integer> map = new HashMap<>();
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if((c>='a'&&c<='z')||(c>='A'&&c<='Z')) {
				if(map.containsKey(c)) {
					if(map.get(c)==2) {
						System.out.println(c);
						return;
					}else {
						map.put(c, 2);
					}
				}else
				map.put(c, 1);
			}
		}
	}
}
