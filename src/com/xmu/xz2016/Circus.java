package com.xmu.xz2016;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Circus {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int m = in.nextInt();
			Member[] members = new Member[m];
			for (int i = 0; i < m; i++) {
				in.nextInt();
				members[i] = new Member(in.nextInt(), in.nextInt());
			}
			Arrays.sort(members, new Comparator<Member>() {
				@Override
				public int compare(Member o1, Member o2) {
					int less = o1.weight - o2.weight;
					return less != 0 ? less : o2.height - o1.height;
				}
			});

			int[] dp = new int[m];
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < m; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if (members[j].height <= members[i].height) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
				max = Math.max(max, dp[i]);
			}
			System.out.println(max);
		}

	}

	static class Member {
		int weight;
		int height;

		public Member(int weight, int height) {
			super();
			this.weight = weight;
			this.height = height;
		}
	}
}
