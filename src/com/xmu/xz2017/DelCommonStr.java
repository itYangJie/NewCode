package com.xmu.xz2017;

import java.util.Scanner;

public class DelCommonStr {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String regex = "["+s2+"]";
            
            s1 = s1.replaceAll(regex, "");
            System.out.println(s1);
        }
	}
}
