package com.xmu.xz2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MinK {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=0;
		List<Integer> list = new ArrayList<>();
		while(in.hasNext()) {
			list.add(in.nextInt());
			n++;
		}
		int k = list.remove(n-1);
		n--;
		
		Collections.sort(list);
		for(int i=0;i<k-1;i++)
			System.out.print(list.get(i)+" ");
		System.out.print(list.get(k-1));
	}

}
