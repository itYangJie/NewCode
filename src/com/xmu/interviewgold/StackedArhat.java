package com.xmu.interviewgold;

import java.util.Arrays;
import java.util.Comparator;


public class StackedArhat {
	 class Member {
		int weight;
		int height;

		public Member(int weight, int height) {
			super();
			this.weight = weight;
			this.height = height;
		}
	}
	public int getHeight(int[][] actors, int m) {
		
		Member[] members = new Member[m];
		for (int i = 0; i < m; i++) {
			members[i] = new Member(actors[i][1],actors[i][0]);
		}
		Arrays.sort(members, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				int less = o1.weight - o2.weight;
				return less != 0 ? less : o2.height - o1.height;
			}
		});

		int[] dp = new int[m];
		int max = 1;
		for (int i = 0; i < m; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (members[j].height < members[i].height) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
