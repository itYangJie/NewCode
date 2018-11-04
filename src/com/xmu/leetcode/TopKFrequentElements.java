package com.xmu.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TopKFrequentElements {
	public static void main(String[] args) {
		new TopKFrequentElements().topKFrequent(new int[] {4,1,-1,2,-1,2,3}, 2);
	}
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		
		HashMap<Integer,Integer> map = new HashMap();
		for(int num:nums) {
			map.put(num, 1+map.getOrDefault(num, 0));
		}
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		ArrayList<Entry<Integer, Integer>> list = new ArrayList<>(entrySet);
		Collections.sort(list,new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue()-o1.getValue();
			}
		});
		for(int i=0;i<k;i++)
			res.add(list.get(i).getKey());
		return res;
	}
}
