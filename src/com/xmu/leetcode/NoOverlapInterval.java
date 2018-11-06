package com.xmu.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NoOverlapInterval {
	public int eraseOverlapIntervals(Interval[] intervals) {
		
		int n = intervals.length;
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				
				return o1.end-o2.end;
			}
		});
		int count = 1;
		int end = intervals[0].end;
		for(int i=1;i<intervals.length;i++) {
			Interval cur = intervals[i];
			if(cur.start>=end) {
				count++;
				end = cur.end;
			}
		}
		return n-count;
	}

	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}
