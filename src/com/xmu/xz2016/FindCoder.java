package com.xmu.xz2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FindCoder {

	public static void main(String[] args) {
		FindCoder fc = new FindCoder();
		String[] A = new String[] {"i am a coder","Coder Coder","Code","Coders"};
		System.out.println(Arrays.toString(fc.findCoder(A, A.length)));

	}
	public String[] findCoder(String[] A, int n) {
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		char[][] dic = new char[][] {{'c','C'},{'o','O'},{'d','D'},{'e','E'},{'r','R'}};
		for(String str : A) {
			char[] chars = str.toCharArray();
			int ind = 0;
			int count = 0;
			while(ind<chars.length) {
				while(ind<chars.length && chars[ind]!=dic[0][0] && chars[ind]!=dic[0][1])
					ind++;
				if(ind>=chars.length)
					break;
				boolean flag = true;
				for(int i=0;i<5;i++) {
					if(ind<chars.length && (chars[ind]==dic[i][0] || chars[ind]==dic[i][1]))
						ind++;
					else {
						flag = false;
						break;
					}
				}
				if (flag)
					count++;
			}
			if(count>0)
				map.put(str, count);
		}
		ArrayList<Entry<String, Integer>> arrayList = new ArrayList(map.entrySet());
		Collections.sort(arrayList,new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue()-o1.getValue();
			}
		});
		String[] res = new String[arrayList.size()];
		for(int i=0;i<arrayList.size();i++)
			res[i] = arrayList.get(i).getKey();
		return res;
    }
}
