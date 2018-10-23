package com.xmu.xz2016;

import java.util.Scanner;

public class SelectMayor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0;i<T;i++) {
			int n = in.nextInt();
			int m = in.nextInt();
			
			int[] inDegree = new int[n+1];
			int[] outDegree = new int[n+1];
			for(int j=0;j<m;j++) {
				int Ai = in.nextInt();
				int Bi = in.nextInt();
				if(Ai!=Bi) {
					inDegree[Bi]++;
					outDegree[Ai]++;
				}
			}
			int count = 0;
			StringBuffer sb = new StringBuffer();
			for(int j=1;j<=n;j++) {
				if(inDegree[j]==n-1 && outDegree[j]==0) {
					sb.append(j+" ");
					count++;
				}
			}
			System.out.println(count);
			System.out.println(sb.toString().trim());
		}

	}

}
