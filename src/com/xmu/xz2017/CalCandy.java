package com.xmu.xz2017;

import java.util.Scanner;

public class CalCandy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int a_sub_b = in.nextInt();
		int b_sub_c = in.nextInt();
		int a_add_b = in.nextInt();
		int b_add_c = in.nextInt();
		if((a_sub_b+a_add_b)%2!=0 || (b_sub_c+b_add_c)%2!=0 || (b_add_c-b_sub_c)%2!=0) {
			System.out.println("No");
			return;
		}
		int A = (a_sub_b+a_add_b)/2;
		int B = (b_sub_c+b_add_c)/2;
		int C = (b_add_c-b_sub_c)/2;
		if(A-B==a_sub_b && B-C==b_sub_c && A+B==a_add_b && B+C==b_add_c) {
			System.out.println(A+" "+B+" "+C);
		}else {
			System.out.println("No");
		}
	}

}
