package com.xmu.interviewgold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ArgumentSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sortStrings(new String[] {"ab","ba","abc","cba"}, 4);
	}
	public static ArrayList<String> sortStrings(String[] str, int n) {
        
		Map<String,String> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			char[] chars = str[i].toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			if(map.containsKey(key)) {
				if(str[i].compareTo(map.get(key))<0)
					map.put(key, str[i]);
			}else {
				map.put(key, str[i]);
			}
		}
		ArrayList<String> res = new ArrayList(map.values());
		Collections.sort(res);
		return res;
    }
}
