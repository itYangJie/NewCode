package com.xmu.xz2017;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneDividie {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		/*
		 * Z: 0
		 * E: 0,1,3,5,7,8,9
		 * R: 0,3,4
		 * O: 0,1,2,4
		 * N: 1,7,9
		 * T: 2,3,8
		 * W: 2
		 * H: 3,8
		 * F: 4,5
		 * U: 4
		 * I: 5,6,8,9
		 * V: 5,7
		 * S: 6,7
		 * X: 6
		 * G: 8
		 * 
		 * 0-8,1-9,2-0,3-1,4-2,5-3,6-4,7-5,8-6,9-7
		 * */
		char[] cs = {'Z','E','R','O','N','T','W','H','F','U','I','V','S',
				'X','G'};
		int[] indexs = {8,9,0,1,2,3,4,5,6,7};
		int T = in.nextInt();
		in.nextLine();
		for(int i=0;i<=T;i++) {
			String str = in.nextLine();
			int[] counts = new int[10];
			HashMap<Character,Integer> map = new HashMap<>();
			for (char c:cs) {
				map.put(c, 0);
			}
			for(char c:str.toCharArray()) {
				map.put(c,1+map.get(c));
			}
			counts[0] = map.get('Z');
			counts[2] = map.get('W');
			counts[4] = map.get('U');
			counts[6] = map.get('X');
			counts[8] = map.get('G');
			
			counts[3] = map.get('H')-counts[8];
			counts[7] = map.get('S')-counts[6];
			counts[5] = map.get('V')-counts[7];
			counts[9] = map.get('I')-counts[5]-counts[6]-counts[8];
			counts[1] = map.get('N')-counts[7]-2*counts[9];
			
			StringBuffer sb = new StringBuffer();
			for(int index:indexs) {
				if(counts[index]==0)
					continue;
				for(int j=counts[index];j>0;j--)
					sb.append((index+2)%10);
			}
			System.out.println(sb.toString());
		}
	}

}
