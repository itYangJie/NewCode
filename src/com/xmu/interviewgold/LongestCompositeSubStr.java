package com.xmu.interviewgold;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCompositeSubStr {

	public static void main(String[] args) {
		
		System.out.println(new LongestCompositeSubStr().
				getLongest(new String[] {"a","b","c","ab","bc","abc"}, 6));
	}

	public int getLongest(String[] strs, int n) {
		Arrays.sort(strs,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length()-o1.length();
			}
		});
		
		for(int i=0;i<n;i++) {
			String str = strs[i];
			if(solve(str,strs,i+1,n))
				return str.length();
		}
		return 0;
	}

	private boolean solve(String need, String[] strs, int ind,int n) {
		for(int i=ind;i<n;i++) {
			if(need.startsWith(strs[i])  && (need.length()==strs[i].length() ||
						solve(need.substring(strs[i].length()),strs,ind,n)))
					return true;
		}
		return false;
	}
}
