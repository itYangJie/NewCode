package com.xmu.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SubstringConcatAllWords {
	
	// s = "barfoothefoobarman",
	// words = ["foo","bar"]
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		if(s==null || s.length()==0 || words.length==0)
			return res;
		Map<String,Integer> map = new HashMap<>();
		for(String word:words) {
			map.put(word, map.getOrDefault(word, 0)+1);
		}
		
		int n = s.length();
		int n_word = words[0].length();
		int count_word = words.length;
		
		for(int i=n-n_word*count_word;i>=0;i--) {
			Map<String,Integer> seen = new HashMap<>();
			int j=0;
			for(;j<count_word;j++) {
				String cur = s.substring(i+j*n_word, i+(j+1)*n_word);
				if(!map.containsKey(cur))
					break;
				seen.put(cur, seen.getOrDefault(cur, 0)+1);
				if(seen.get(cur)>map.get(cur))
					break;
			}
			if(j==count_word) {
				res.add(i);
			}
		}
		return res;
	}
}
