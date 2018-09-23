package com.xmu.xz2016;

import java.util.ArrayList;
import java.util.Scanner;

public class Foggy {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			in.nextLine();
			String str = in.nextLine();
			// 114121581339614271510
			boolean[] isVisited = new boolean[n+1];
			ArrayList<Integer> res = new ArrayList<>();
			dfs(0,isVisited,str,res,n);
		}

	}

	private static void dfs(int ind, boolean[] isVisited,
			String str, ArrayList<Integer> res, int n) {
		if(ind==str.length()) {
			/*for(int i=1;i<=n;i++)
				if(!isVisited[i])
					return;*/
			for(int cur:res)
				System.out.print(cur+" ");
            System.out.println();
			return;
		}
		
		// ind;ind,ind+1
		for (int i = 1; i <= 2; i++) {
			if (ind + i <= str.length()) {
				int num = Integer.parseInt(str.substring(ind, ind + i));
				if (num>=1 && num <= n && !isVisited[num]) {
					isVisited[num] = true;
					res.add(num);
					dfs(ind+i,isVisited,str,res,n);
					isVisited[num] = false;
					res.remove(res.size() - 1);
				}
			}
		}
	}
}
