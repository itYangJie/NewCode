package com.xmu.leetcode;

public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		
		char[] chars = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		
		int nums[] = new int[26];
		boolean used[] = new boolean[26];
		for(char c:chars)
			nums[c-'a']++;
		
		int ind = 0;
		while(ind<s.length()) {
			char c = s.charAt(ind);
			if(used[c-'a'] || nums[c-'a']==0) {
				ind++;
				continue;
			}
				
			if(nums[c-'a']==1) {
				used[c-'a'] = true;
				nums[c-'a']--;
				sb.append(c);
			}else {
				int temp = ind+1;
				while(temp<s.length() && used[s.charAt(temp)])
					temp++;
				if(s.charAt(temp)>c) {
					sb.append(c);
					used[c-'a'] = true;
					nums[c-'a']--;
				}
			}
			ind++;
		}
		return sb.toString();
	}
}
