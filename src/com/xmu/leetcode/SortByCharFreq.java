package com.xmu.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SortByCharFreq {
	public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap();
        
        for(char c:s.toCharArray())
            map.put(c,1+map.getOrDefault(c,0));
        ArrayList<Entry<Character,Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list,new Comparator<Entry<Character,Integer>>() {
			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				return o2.getValue()-o1.getValue();
			}
		});
        StringBuffer sb = new StringBuffer();
        for(Entry<Character,Integer> entry:list) {
        	char c = entry.getKey();
        	int count = entry.getValue();
        	for(int i=0;i<count;i++)
        		sb.append(c);
        }
        return sb.toString();
    }
}
