package com.xmu.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsSmallestSums {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

		List<int[]> res = new ArrayList();
		int ind1 = 0;
		int ind2 = 0;

		int len1 = nums1.length, len2 = nums2.length;
		PriorityQueue<int[]> queue = new PriorityQueue(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0]+o2[1]-(o1[0]+o1[1]);
			}
		});
		for(int i=0;i<len1;i++)
			for(int j=0;j<len2;j++) {
				if(queue.size()<k) {
					queue.add(new int[] {nums1[i],nums2[j]});
				}else {
					int[] peek = queue.peek();
					if(peek[0]+peek[1]>nums1[i]+nums2[j]) {
						queue.remove();
						queue.add(new int[] {nums1[i],nums2[j]});
					}
				}
			}
		while(!queue.isEmpty())
			res.add(queue.remove());
		return res;
	}
}
