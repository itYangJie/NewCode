package com.xmu.test;

import java.util.Scanner;

public class Game {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			long x = in.nextLong();
			long y = in.nextLong();
			// N(1+N)=2*(x+y)
			long N = (long) ((Math.sqrt(1+8*(x+y))-1)/2);
			if(N*(1+N)!=2*(x+y)) {
				System.out.println(-1);
				return;
			}
			if(x<=N) {
				System.out.println(1);
				return;
			}
			long res = 0;
			for(long i=N;i>=1;i--) {
				res++;
				if(x<=i)
					break;
				x = x-i;
			}
			System.out.println(res);
		}
	}

	/*private static int dfs(long n, long x) {
		if(x<=n)
			return 1;
		return 1+dfs(n-1,x-n);
	}*/
}
