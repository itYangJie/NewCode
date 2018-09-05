package com.xmu.xz2017;

import java.util.Arrays;
import java.util.Scanner;

public class TouTiaoCampus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] d = new int[n];
		for(int i=0;i<n;i++)
			d[i] = in.nextInt();
		
		Arrays.sort(d);
		
		int aIndex = 0,bIndex=1,cIndex=2;
		int count = 0;
		while(aIndex<n) {
			if(bIndex>=n) {
				count = count+2;
				break;
			}
			if(cIndex>=n) {
				if(d[bIndex]-d[aIndex]<=20) 
					count = count+1;
				else 
					count = count+4;
				break;
			}
			if(d[bIndex]-d[aIndex]<=10 && d[cIndex]-d[bIndex]<=10) {
				aIndex = cIndex+1;
				bIndex = cIndex+2;
				cIndex = cIndex+3;
			}else if(d[bIndex]-d[aIndex]<=20) {
				count = count+1;
				aIndex = cIndex;
				bIndex = cIndex+1;
				cIndex = cIndex+2;
			}else {
				count = count+2;
				aIndex = bIndex;
				cIndex = bIndex+2;
				bIndex = bIndex+1;
			}
				
		}
		System.out.println(count);
	}

}
