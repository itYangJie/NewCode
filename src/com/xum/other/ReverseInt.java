package com.xum.other;

import java.util.Scanner;

public class ReverseInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int num = in.nextInt();
			String s = num+"";
			int flag = 1;
			if(s.charAt(0)=='-') {
				flag = -1;
				s = s.substring(1);
			}
			s = new StringBuffer(s).reverse().toString();
			int ind = 0;
			while(s.indexOf(ind)=='0')
				ind++;
			num = Integer.parseInt(s.substring(ind));
			System.out.println(flag*num);
			
		}
	}

}
