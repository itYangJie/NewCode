package com.xmu.xz2016;

import java.util.Arrays;
import java.util.Scanner;

public class GiveOutBonus {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = in.nextInt();
			int[] scores = new int[N];
			for (int i = 0; i < N; i++)
				scores[i] = in.nextInt();
			int[] b = new int[N];
			Arrays.fill(b, 1);
			for (int i = 1; i < N; i++) {
				if (scores[i] > scores[i - 1])
					b[i] = b[i - 1] + 1;
			}
			for (int i = N - 2; i >= 0; i--) {
				if (scores[i] > scores[i + 1] && b[i] < b[i + 1] + 1)
					b[i] = b[i + 1] + 1;
			}
			long sum = 0;
			for (int i = 0; i < N; i++)
				sum += b[i];
			System.out.println(sum);
		}
	}
}
