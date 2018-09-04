package com.xmu.xz2017;

import java.util.Scanner;

public class HotelPrice {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] prices = new int[100000+1];
		int minStart = Integer.MAX_VALUE,maxEnd = Integer.MIN_VALUE;
		while(in.hasNext()) {
			int start = in.nextInt(),end = in.nextInt(),price = in.nextInt();
			for(int i=start;i<=end;i++)
				prices[i] = price;
			minStart = Math.min(minStart, start);
			maxEnd = Math.max(maxEnd, end);
		}
		int start = minStart,end = minStart+1;
		
		while(start<=maxEnd) {
			while(prices[end]==prices[start])
				end++;
			if(end-1==maxEnd)
				System.out.print("["+start+", "+(end-1)+", "+prices[start]+"]");
			else
				System.out.print("["+start+", "+(end-1)+", "+prices[start]+"]"+",");;
			start = end;
			while(start<=maxEnd && prices[start]==0)
				start++;
			end = start+1;
		}
	}
	
}
