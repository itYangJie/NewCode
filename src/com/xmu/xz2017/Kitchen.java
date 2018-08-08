package com.xmu.xz2017;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Kitchen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Set<String> set = new HashSet<String>();
		while(in.hasNext()) {
			String line = in.nextLine();
			String[] sources = line.split(" ");
			for (String s : sources) {
				set.add(s);
			}
		}
		System.out.println(set.size());
	}

}
