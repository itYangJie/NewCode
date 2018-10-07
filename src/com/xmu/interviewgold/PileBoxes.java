package com.xmu.interviewgold;

import java.util.Arrays;
import java.util.Comparator;

public class PileBoxes {
	public int getHeight(int[] ws, int[] ls, int[] hs, int n) {
		MyBox[] boxs = new MyBox[n];
		for (int i = 0; i < n; i++) {
			boxs[i] = new MyBox(ws[i],ls[i],hs[i]);
		}
		Arrays.sort(boxs, new Comparator<MyBox>() {
			@Override
			public int compare(MyBox o1, MyBox o2) {
				if(o1.w==o2.w)
					return o1.l-o2.l;
				return o2.w-o1.w;
		}});
		
		int[] dp = new int[n];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			dp[i] = boxs[i].h;
			for (int j = 0; j < i; j++) {
				if (boxs[j].l > boxs[i].l) {
					dp[i] = Math.max(dp[i], dp[j] + boxs[i].h);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	class MyBox {
		int w;
		int l;
		int h;

		public MyBox(int w, int l, int h) {
			this.w = w;
			this.l = l;
			this.h = h;
		}

	}
}
