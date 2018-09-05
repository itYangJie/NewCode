package com.xmu.xz2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(),m = in.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<n+m;i++)
			list.add(in.nextInt());
		
		HashSet<Integer> set = new HashSet();
		set.addAll(list);
		Integer[] data = set.toArray(new Integer[0]);
		Arrays.sort(data);
		
		int size = data.length;
		for(int i=0;i<size-1;i++)
			System.out.print(data[i]+" ");
		System.out.print(data[size-1]);
	}

}
