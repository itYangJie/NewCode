package com.xmu.interviewgold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StrPermutation {

	public static void main(String[] args) {
		System.out.println(new StrPermutation().getPermutation("ABC"));

	}
	public ArrayList<String> getPermutation(String A) {
		ArrayList<String> res = new ArrayList<>();
		char[] chars = A.toCharArray();
		solve(res,chars,0,chars.length);
		Collections.sort(res,new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
			}
		});
		return res;
    }
	private void solve(ArrayList<String> res, char[] chars, int step, int len) {
		if(step==len) {
			res.add(new String(chars));
		}
		for(int i=step;i<len;i++) {
			swap(chars,i,step);
			solve(res,chars,step+1,len);
			swap(chars,i,step);
		}
	}
	private void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}
}
