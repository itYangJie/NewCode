package com.xmu.xz2017;

import java.util.Scanner;

public class KeepMaxNum {

	public static void main(String[] args) {
		//5652
		Scanner in = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
        sb.append(in.next());
        int cnt = in.nextInt();
        for(int i=0;i<cnt;i++) {
            int j = 0;
            while(j + 1< sb.length() && sb.charAt(j) >= sb.charAt(j+1)) {
                j++;
            }
            sb.deleteCharAt(j);
        }
        System.out.println(sb.toString());
	}

}
