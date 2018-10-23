package com.xmu.xz2016;

import java.util.ArrayList;

public class ExpressionCompositionScheme {

	public static void main(String[] args) {
		System.out.println(countWays2("1^0|0|1", 7, 0));

	}

	public static int countWays(String exp, int len, int ret) {
		if (len == 1) {
			if (exp.charAt(0) - '0' == ret)
				return 1;
			else
				return 0;
		}
		int res = 0;
		for (int i = 0; i < len; i++) {
			char c = exp.charAt(i);
			if (c == '^') {
				String exp1 = exp.substring(0, i);
				String exp2 = exp.substring(i + 1);
				if (ret == 0) {
					res = res + (countWays(exp1, i, 0) * countWays(exp2, len - i - 1, 0)) % 10007;
					res = res + (countWays(exp1, i, 1) * countWays(exp2, len - i - 1, 1)) % 10007;
				} else {
					res = res + (countWays(exp1, i, 0) * countWays(exp2, len - i - 1, 1)) % 10007;
					res = res + (countWays(exp1, i, 1) * countWays(exp2, len - i - 1, 0)) % 10007;
				}
			} else if (c == '|') {
				String exp1 = exp.substring(0, i);
				String exp2 = exp.substring(i + 1);
				if (ret == 0) {
					res = res + (countWays(exp1, i, 0) * countWays(exp2, len - i - 1, 0)) % 10007;
				} else {
					int exp1_1 = countWays(exp1, i, 1);
					int exp1_0 = countWays(exp1, i, 0);
					int exp2_1 = countWays(exp2, len - i - 1, 1);
					int exp2_0 = countWays(exp2, len - i - 1, 0);
					res = res + (exp1_1 * exp2_1) % 10007;
					res = res + (exp1_1 * exp2_0) % 10007;
					res = res + (exp1_0 * exp2_1) % 10007;
				}
			} else if (c == '&') {
				String exp1 = exp.substring(0, i);
				String exp2 = exp.substring(i + 1);
				if (ret == 1) {
					res = res + (countWays(exp1, i, 1) * countWays(exp2, len - i - 1, 1)) % 10007;
				} else {
					int exp1_1 = countWays(exp1, i, 1);
					int exp1_0 = countWays(exp1, i, 0);
					int exp2_1 = countWays(exp2, len - i - 1, 1);
					int exp2_0 = countWays(exp2, len - i - 1, 0);
					res = res + (exp1_0 * exp2_0) % 10007;
					res = res + (exp1_1 * exp2_0) % 10007;
					res = res + (exp1_0 * exp2_1) % 10007;
				}
			}
		}
		return res;
	}

	// "1^0|0|1"
	public static int countWays2(String exp, int len, int ret) {
		ArrayList<Integer> numList = new ArrayList<>();
		ArrayList<Character> caclSymbols = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			char c = exp.charAt(i);
			if (c == '&' || c == '|' || c == '^')
				caclSymbols.add(c);
			else
				numList.add(c - '0');
		}
		Integer[] nums = numList.toArray(new Integer[] {});
		int n = nums.length;
		int[][][] dp = new int[n][n][2];
		for (int i = 0; i < n; i++) {
			dp[i][i][nums[i]] = 1;
		}
		for (int l = 2; l <= n; l++) { 
			for (int i = 0; i < n+1-l; i++) {
				int j = i + l-1;
				for (int k = i; k < j; k++) {
					help(dp, i, j, k, caclSymbols.get(k));
				}
			}
		}
		return dp[0][n - 1][ret];
	}

	private static void help(int[][][] dp, int i, int j, int k, Character symbols) {
		if (symbols == '&') {
			dp[i][j][0] = (dp[i][j][0] + (dp[i][k][0] * dp[k + 1][j][0]) % 10007
					+ (dp[i][k][0] * dp[k + 1][j][1]) % 10007 + (dp[i][k][1] * dp[k + 1][j][0]) % 10007) % 10007;
			dp[i][j][1] = (dp[i][j][1] + (dp[i][k][1] * dp[k + 1][j][1]) % 10007) % 10007;
		} else if (symbols == '|') {
			dp[i][j][0] = (dp[i][j][0] + (dp[i][k][0] * dp[k + 1][j][0]) % 10007) % 10007;
			dp[i][j][1] = (dp[i][j][1] + (dp[i][k][1] * dp[k + 1][j][1]) % 10007
					+ (dp[i][k][0] * dp[k + 1][j][1]) % 10007 + (dp[i][k][1] * dp[k + 1][j][0]) % 10007) % 10007;
		} else {
			dp[i][j][1] = (dp[i][j][1] + (dp[i][k][0] * dp[k + 1][j][1]) % 10007
					+ (dp[i][k][1] * dp[k + 1][j][0]) % 10007) % 10007;
			dp[i][j][0] = (dp[i][j][0] + (dp[i][k][0] * dp[k + 1][j][0]) % 10007
					+ (dp[i][k][1] * dp[k + 1][j][1]) % 10007) % 10007;
		}
	}

}
