package com.xmu.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ABStr {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()) {
			int k = in.nextInt();
			String A = in.next();
			String B = in.next();
			
			long res = 0;
			HashSet<String> set = new HashSet<>();
			for(int ind=0;ind<=A.length()-k;ind++) {
				String sub = A.substring(ind, ind+k);
				if(set.contains(sub))
					continue;
				Pattern p = Pattern.compile(sub,2);
				Matcher m = p.matcher(B);
				while(m.find()){
					res ++;
				}
				set.add(sub);
			}
			System.out.println(res);
		}
	}

}
