package com.xmu.xz2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumberOfOccurBeyondN {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		while(in.hasNext())
			list.add(in.nextInt());
		int n = list.size();
		Collections.sort(list);
		System.out.println(list.get(n/2-1));
	}
}
