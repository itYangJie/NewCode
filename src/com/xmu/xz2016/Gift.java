package com.xmu.xz2016;

import java.util.Scanner;

public class Gift {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			int n = s.nextInt(); // 人数
			int m = s.nextInt(); // 礼物种类数
			int[] gift = new int[m]; // 每类礼物个数
			for (int i = 0; i < m; i++)
				gift[i] = s.nextInt();

			double[][] P = new double[n][m]; // 每个人选择每种礼物概率
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++)
					P[i][j] = s.nextDouble();
			}
			
			double remainNum = 0.0;
			for(int j=0;j<m;j++) {
				if(gift[j]==0)
					continue;
				double[] remain = new double[gift[j]+1];
				remain[gift[j]] = 1.0;
				for(int i=0;i<n;i++) {
					remain[0] = remain[1]*P[i][j]+remain[0];
					for(int k=1;k<gift[j];k++) {
						remain[k] = remain[k]*(1-P[i][j])+
							remain[k+1]*P[i][j];
					}
					remain[gift[j]] = remain[gift[j]]*(1-P[i][j]);
				}
				for(int i=1;i<=gift[j];i++)
					remainNum = remainNum+i*remain[i];
			}
			System.out.printf("%.1f\n",(double) (Math.round((n - remainNum)*10)/10.0));
		}
	}
}
