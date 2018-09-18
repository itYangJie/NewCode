package com.xmu.xz2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KeywordDetect {

	public static void main(String[] args) {
		KeywordDetect kd = new KeywordDetect();
		System.out.println(Arrays.toString(kd.containKeyword(new String[] {"nowcoder","hello","now"}, 3,
				new String[] {"coder","now"}, 2)));
	}
	public int[] containKeyword(String[] A, int n, String[] keys, int m) {
		ArrayList<Integer> res = new ArrayList<>();
		Map<String,int[]> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			String s = A[i];
			for(int j=0;j<m;j++) {
				String pattern = keys[j];
				int next[];
				if(map.containsKey(pattern))
					next = map.get(pattern);
				else {
					next = getNext(pattern);
					map.put(pattern, next);
				}
				if(kmp(s,pattern,next)!=-1) {
					res.add(i);
					break;
				}
			}
		}
		if(res.size()==0)
			return new int[] {-1};
		int ret[] = new int[res.size()];
		for(int i=0;i<res.size();i++)
			ret[i] = res.get(i);
		return ret;
	}
	private int[] getNext(String pattern) {
		int pLen=pattern.length();
		int[] next = new int[pLen];
		
		next[0] = -1;
		int j=0,k=-1;
		
		while(j<pLen-1) {
			if(k==-1 || pattern.charAt(j)==pattern.charAt(k)) 
				next[++j] = ++k;
			else
				k = next[k];
		}
		return next;
	}
	public int kmp(String s,String pattern,int[] next) {
		int i=0,j=0,sLen=s.length(),pLen=pattern.length();
		
		while(i<sLen && j<pLen) {
			if(s.charAt(i)==pattern.charAt(j)) {
				i++;j++;
			}else {
				if(next[j]==-1) {
					j=0;i++;
				}else
					j = next[j];
			}
			if(j==pLen) {
				return i-j;
			}
		}
		return -1;
	}
}
