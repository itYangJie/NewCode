package com.xmu.xz2016;

import java.util.ArrayList;
import java.util.Scanner;

public class NumericKeypad {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] map = new String[] {"0", "0123456789", "0235689", "369",
				"0456789", "05689", "69", "0789", "089", "9"};
		in.nextLine();
		
		for(int i=0;i<n;i++) {
			String num = in.nextLine();
			char[] chars = num.toCharArray();
			ArrayList<Character> list = new ArrayList<>();
			
			solve(chars,chars.length,0,1,map,list);
			StringBuffer sb = new StringBuffer();
			for(Character c:list)
				sb.append(c);
			System.out.println(sb.toString());
		}
		
	}

	private static boolean solve(char[] chars, int len, int ind, 
			int preNum, String[] map, ArrayList<Character> list) {
		if(ind>=len)
			return true;
		for(int i=map[preNum].length()-1;i>=0;i--) {
			if(map[preNum].charAt(i)>chars[ind])
				continue;
			if(map[preNum].charAt(i)<chars[ind]) {
				char cur = map[preNum].charAt(i);
				list.add(cur);
				char temp = map[cur-'0'].charAt(map[cur-'0'].length()-1);
				for(int j=ind+1;j<len;j++)
					list.add(temp);
				return true;
			}
			list.add(map[preNum].charAt(i));
			if(solve(chars,len,ind+1,map[preNum].charAt(i)-'0',map,list))
				return true;
			list.remove(list.size()-1);
		}
		
		return false;
	}

}
