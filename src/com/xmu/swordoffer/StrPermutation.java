package com.xmu.swordoffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class StrPermutation {

	public static void main(String[] args) {
		
		new StrPermutation().Permutation("abc");
	}

	public ArrayList<String> Permutation(String str) {
		ArrayList<String> res = new ArrayList<>();
		if(str.length()<1)
			return res;
		char[] chars = str.toCharArray();
		TreeSet<String> set = new TreeSet<>();
		
		boolean isUsed[] = new boolean[chars.length];
		solve(chars,set,isUsed,"");
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext())
			res.add(iterator.next());
		return res;
	}

	private void solve(char[] chars, TreeSet<String> set, 
			boolean[] isUsed, String str) {
		if(str.length()==chars.length) {
			set.add(str);
			return;
		}
		for(int i=0;i<chars.length;i++) {
			if(!isUsed[i]) {
				isUsed[i] = true;
				solve(chars,set,isUsed,str+chars[i]);
				isUsed[i] = false;
			}
		}
	}
}
