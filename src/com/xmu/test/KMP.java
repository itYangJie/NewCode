package com.xmu.test;

public class KMP {
	public int kmp_count(String s, String pattern) {
		int i = 0;
		int j = 0;
		int slen = s.length();
		int plen = pattern.length();
		int[] next = getNext(pattern);
		int count = 0;
		while (i < slen && j < plen) {
			if (s.charAt(i) == pattern.charAt(j)) {
				i++; j++;
			} else {
				if (next[j] == -1) {
					i++; j = 0;
				} else 
					j = next[j];
			}
			if (j == plen) {
				count++; 
				j=0;
			}
		}
		return count;
	}
	public int kmp_sub_count(String s, String pattern) {
		int i = 0;
		int j = 0;
		int slen = s.length();
		int plen = pattern.length();
		int[] next = getNext(pattern);
		int count = 0;
		while (i < slen && j < plen) {
			if (s.charAt(i) == pattern.charAt(j)) {
				i++; j++;
			} else {
				if (next[j] == -1) {
					i++; j = 0;
				} else 
					j = next[j];
			}
			if (j == plen) {
				count++; 
				if (next[j-1] == -1) {
					j = 0;
				} else {
					j = next[j-1];
					i--;
				}
			}
		}
		return count;
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
	public int kmp(String s,String pattern) {
		int[] next = getNext(pattern);
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
	public static void main(String[] args) {
		KMP k = new KMP();
		System.out.println(k.kmp("ccababab", "abab"));
	}

}
