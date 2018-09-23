package com.xmu.xz2016;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Decrypt {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String str = in.nextLine();
			ArrayList<String> res = Permutation2(str);
			for(String s:res)
				System.out.println(s);
		}
	}
	public static ArrayList<String> Permutation(String str) {
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

	private static void solve(char[] chars, TreeSet<String> set, 
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
	
	public static ArrayList<String> Permutation2(String str) {
		ArrayList<String> res = new ArrayList<>();
		if(str.length()<1)
			return res;
		char[] chars = str.toCharArray();
		TreeSet<String> set = new TreeSet<>();
		
		solve2(chars,set,0);
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext())
			res.add(iterator.next());
		return res;
	}
	private static void solve2(char[] chars, TreeSet<String> set, int step) {
		
		if(step==chars.length-1) {
			set.add(new String(chars));
			return;
		}
		for(int i=step;i<chars.length;i++) {
			swap(chars,step,i);
			solve2(chars,set,step+1);
			swap(chars,step,i);
		}
	}
	private static void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}
}
