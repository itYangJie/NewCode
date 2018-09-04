package com.xmu.xz2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LostThreeNum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<=10000;i++)
			list.add(i);
		for(int i=0;i<9997;i++) {
			list.remove(new Integer(in.nextInt()));
		}
		System.out.println(Long.parseLong(""+list.get(0)+list.get(1)+list.get(2))%7);
	}

}
