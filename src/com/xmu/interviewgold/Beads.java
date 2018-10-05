package com.xmu.interviewgold;

import java.util.HashMap;

public class Beads {
	public int[] calcResult(String A, String guess) {
		// write code here
		int[] res = new int[2];
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		map1.put('R', 0);
		map1.put('Y', 0);
		map1.put('G', 0);
		map1.put('B', 0);
		map2.put('R', 0);
		map2.put('Y', 0);
		map2.put('G', 0);
		map2.put('B', 0);

		for (int i = 0; i < 4; i++) {
			map1.put(A.charAt(i), 1 + map1.get(A.charAt(i)));
			map2.put(guess.charAt(i), 1 + map2.get(guess.charAt(i)));
			if (A.charAt(i) == guess.charAt(i))
				res[0]++;
		}
		res[1] = res[1] + Math.min(map1.get('R'), map2.get('R'));
		res[1] = res[1] + Math.min(map1.get('Y'), map2.get('Y'));
		res[1] = res[1] + Math.min(map1.get('G'), map2.get('G'));
		res[1] = res[1] + Math.min(map1.get('B'), map2.get('B'));
		res[1] = res[1] - res[0];

		return res;
	}
}
