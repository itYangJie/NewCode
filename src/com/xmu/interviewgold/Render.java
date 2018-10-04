package com.xmu.interviewgold;

import java.util.Arrays;

public class Render {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(renderPixel(new int[] { 0, 0, 0, 0, 0, 0 }, 14, 18)));
	}

	public static int[] renderPixel(int[] screen, int x, int y) {
		// write code here
		int startNumInd = x / 8;
		int endNumInd = y / 8;
		if (startNumInd == endNumInd) {
			for (int i = x%8; i <= y%8; i++)
				screen[startNumInd] = (screen[startNumInd] | (1 << i));
		} else {
			int startResBit = 8 - x % 8;
			int endResBit = 1 + y % 8;
			for (int i = startNumInd + 1; i < endNumInd; i++)
				screen[i] = 255;
			for (int i = 7; i >= 8 - startResBit; i--)
				screen[startNumInd] = (screen[startNumInd] | (1 << i));
			for (int i = 0; i < endResBit; i++)
				screen[endNumInd] = (screen[endNumInd] | (1 << i));
			
		}
		return screen;
	}
}
