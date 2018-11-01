package com.xmu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IntersectionTwoArrays {
	public int[] intersect2(int[] nums1, int[] nums2) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int num:nums1) {
			map.put(num, 1+map.getOrDefault(num, 0));
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int num:nums2) {
			if(map.containsKey(num) && map.get(num)>=1) {
				list.add(num);
				map.put(num,map.get(num)-1);
			}
		}
		int[] res = new int[list.size()];
		for(int i=list.size()-1;i>=0;i--)
			res[i] = list.get(i);
		return res;
	}
	 public int[] intersection1(int[] nums1, int[] nums2) {
	        Set<Integer> set = new HashSet<>();
	        for(int num:nums1) {
	        	set.add(num);
	        }
	        Set<Integer> list = new HashSet<Integer>();
			for(int num:nums2) {
				if(set.contains(num))
					list.add(num);
			}
			int[] res = new int[list.size()];
			Iterator<Integer> iter = list.iterator();
			for(int i=list.size();i>=0;i--)
				res[i] = iter.next();
			return res;
	   }
}
