package com.xmu.xz2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SequenceReduction {
	
	private static int count = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(),k = in.nextInt();
		int[] A = new int[n];
		List<Integer> zeroIndex = new ArrayList<>();
		List<Integer> missNum = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			missNum.add(i);
		}
		for(int i=0;i<n;i++) {
			A[i] = in.nextInt();
			if(A[i]==0)
				zeroIndex.add(i);
			else
				missNum.remove(new Integer(A[i]));
		}
		int currentK = 0;
		for(int i=0;i<n-1;i++) {
			if(A[i]==0)
				continue;
			for(int j=i+1;j<n;j++)
				if(A[j]>A[i])
					currentK++;
		}
		List<Integer> current = new ArrayList<>();
		boolean[] isVisited = new boolean[missNum.size()];
		solve(A,isVisited,missNum,zeroIndex,k-currentK,current);
		System.out.println(count);
	}

	private static void solve(int[] A, boolean[] isVisited ,List<Integer> missNum,
			List<Integer> zeroIndex, int restK, List<Integer> current) {
		if(current.size()==missNum.size()) {
			int currentK = 0;
			for(int i=0;i<current.size()-1;i++) {
				for(int j=i+1;j<current.size();j++)
					if(current.get(j)>current.get(i))
						currentK++;
			}
			
			for(int i=0;i<current.size();i++) {
				int index = zeroIndex.get(i);
				for(int j=0;j<index;j++)
					if(A[j]!=0 && A[j]<current.get(i))
						currentK++;
				for(int j=index+1;j<A.length;j++)
					if(A[j]!=0 && A[j]>current.get(i))
						currentK++;
			}
			if(currentK==restK)
				count++;
			return;
		}
		for(int i=0;i<missNum.size();i++) {
			if(isVisited[i])
				continue;
			isVisited[i] = true;
			current.add(missNum.get(i));
			solve(A,isVisited,missNum,zeroIndex,restK,current);
			isVisited[i] = false;
			current.remove(current.size()-1);
		}
	}

}
