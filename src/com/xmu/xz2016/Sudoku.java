package com.xmu.xz2016;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int[][] nums = new int[9][9];
			for(int i=0;i<9;i++)
				for(int j=0;j<9;j++)
					nums[i][j] = in.nextInt();
		}

	}

}
