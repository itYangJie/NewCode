package com.xmu.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SouGou2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		BigInteger zero = new BigInteger("0");
		for (int i = 0; i < count; i++) {
			int M = in.nextInt();
			int N = in.nextInt();
			ArrayList<BigInteger> list = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				String hex = in.next();
				BigInteger x = new BigInteger(hex,16);
				if(!x.equals(zero))
					list.add(x);
			}
			BigInteger[] arr = list.toArray(new BigInteger[] {});
			int n = arr.length;
			for (int k = n - 1; k > 0; k--) {
				Arrays.sort(arr);
				for (int m = k - 1; m >= 0; m--) {
					BigInteger temp = arr[m].xor(arr[k]);
					if(temp.compareTo(arr[m])<0)
						arr[m] = temp;
				}
			}
			int temp = 0;
			for (int k = n - 1; k >= 0; k--)
				if (!arr[k].equals(zero))
					temp++;
			if(temp==n)
				System.out.println("no");
			else
				System.out.println("yes");
		}

	}

	

}
