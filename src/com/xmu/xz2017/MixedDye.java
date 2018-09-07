package com.xmu.xz2017;

import java.util.Arrays;
import java.util.Scanner;

public class MixedDye {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] x = new int[n];
		for(int i=0;i<n;i++)
			x[i] = in.nextInt();
		for(int i=n-1;i>0;i--) {
			Arrays.sort(x);
			for(int j=i-1;j>=0;j--) {
				if((x[j]^x[i])<x[j])
					x[j] = x[j]^x[i];
			}
		}
		int count = 0;
		for(int i=n-1;i>=0;i--)
			if(x[i]!=0)
				count++;
		System.out.println(count);
	}
	/*private static int getHighestBit(int number){
        int tmp = 1;
        for(int i=31;i>=0;i--){
        	tmp = number>>i;
			if((tmp&1)==1)
				return i+1;
        }
        return 0;
    }*/

}
