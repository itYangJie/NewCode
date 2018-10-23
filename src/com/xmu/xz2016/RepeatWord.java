package com.xmu.xz2016;

import java.util.ArrayList;
import java.util.List;

public class RepeatWord {

	public static void main(String[] args) {

		System.out.println(new RepeatWord().getLongest(8, "babababa"));
	}

	public long getLongest(int n, String s) {
		if (n == 0 || n == 1) {
			return 0;
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<n;i++) {
			if(s.charAt(i)==s.charAt(0))
				list.add(i);
		}
		
		int A[] = new int[n];
		for(int i = list.size()-1;i>=0;i--) {
			for(int j=list.get(i),k = 0;j<n;j++,k++) {
				if(s.charAt(j)==s.charAt(k)) {
					A[j] = (list.get(i)>A[j]?list.get(i):A[j]);
				}else
					break;
			}
		}
		long sum = 0;
		for(int num:A)
			sum += num;
		return sum;
	}
}
