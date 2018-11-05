package com.xmu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReConstructQueue {
	
	public int[][] reconstructQueue(int[][] people) {

		 if (people == null || people.length == 0) {
	            return people;
	        }
	        Arrays.sort(people, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] p1, int[] p2) {
	                return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
	            }
	        });
	        List<int[]> temp = new ArrayList<int[]>();
	        for (int[] aPeople : people) {
	            if (people.length == aPeople[1]) {
	                temp.add(aPeople);
	            } else {
	                temp.add(aPeople[1], aPeople);
	            }
	        }
	        int ans[][] = new int[people.length][2];
	        for (int i = 0; i < temp.size(); i++) {
	            ans[i] = temp.get(i);
	        }
	        return ans;
	}
}
