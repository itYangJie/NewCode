package com.xmu.xz2017;

import java.util.Scanner;

public class DaffodilNum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int m = in.nextInt(),n = in.nextInt();
			boolean flag = false;
			StringBuffer sb = new StringBuffer();
			for(int num=m;num<=n;num++) {
				int ele1 = (int)Math.pow(num/100,3);
				int ele2 = (int)Math.pow((num/10)%10,3);
				int ele3 = (int)Math.pow(num%10,3);
				if(num==(ele1+ele2+ele3)) {
					flag=true;
					sb.append(num+" ");
				}
			}
			if(flag)
				System.out.println(sb.toString().trim());
			else
				System.out.println("no");
		}
		
	}

}
