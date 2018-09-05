package com.xmu.xz2017;

import java.util.Scanner;

public class IDCardGroup {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String id = in.nextLine();
			id = id.replaceAll(" ","");
			int length = id.length();
			if(length<=6)
				System.out.println(id);
			else if(length<=14)
				System.out.println(id.substring(0, 6)+" "+id.substring(6));
			else
				System.out.println(id.substring(0, 6)+" "+id.substring(6,14)+" "+id.substring(14));
		}
	}

}
