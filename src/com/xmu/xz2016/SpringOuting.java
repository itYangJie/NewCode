package com.xmu.xz2016;

import java.util.Scanner;

public class SpringOuting {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {

			int n = in.nextInt();
			int k = in.nextInt();
			int[][] votes = new int[n][k + 1];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= k; j++) {
					votes[i][in.nextInt()] = j;
				}
			}

			int selected = getPlace(votes, n, k);
			System.out.println(selected == 0 ? "otaku" : selected);
		}

	}

	public static int getPlace(int[][] votes, int n, int k) {
		int selected = 0, count = 0;
		for (int i = k; i > 0; i--) {
			count = 0;
			for (int j = 0; j < n; j++) {
				if (votes[j][i] < votes[j][selected]) {
					count++;
				}
			}
			if (count > n / 2) {
				selected = i;
			}
		}
		return selected;
	}
}
