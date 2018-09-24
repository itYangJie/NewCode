package com.xmu.xz2016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ZhaJinhua {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 2; i <= 10; i++)
			map.put(i + "", i);
		map.put("J", 11);
		map.put("Q", 12);
		map.put("K", 13);
		map.put("A", 14);
		while (in.hasNext()) {
			String s1 = in.next();
			String s2 = in.next();
			solve(s1, s2, map);
		}

	}

	private static void solve(String s1, String s2,HashMap<String, Integer> map) {
		List<Integer> cards1 = new ArrayList<>();
		List<Integer> cards2 = new ArrayList<>();

		boolean flag = analysis(map, s1, cards1);
		if (!flag || cards1.size() != 3) {
			System.out.println(-2);
			return;
		}
		flag = analysis(map, s2, cards2);
		if (!flag || cards2.size() != 3) {
			System.out.println(-2);
			return;
		}
		Collections.sort(cards1);
		Collections.sort(cards2);
		int type1 = decideType(cards1);
		int type2 = decideType(cards2);

		if (type1 > type2) {
			System.out.println(1);
		} else if (type1 < type2) {
			System.out.println(-1);
		} else {
			// 牌型一样，则比大小
			System.out.println(compare(cards1, cards2, type1));
		}
	}

	private static int compare(List<Integer> cards1, List<Integer> cards2, int type) {
		if (type == 2 && cards1.get(1) == cards2.get(1)) {
			int num1, num2 = 0;
			if (cards1.get(1) == cards1.get(0))
				num1 = cards1.get(2);
			else
				num1 = cards1.get(0);
			if (cards2.get(1) == cards2.get(0))
				num2 = cards2.get(2);
			else
				num2 = cards2.get(0);
			return num1 > num2 ? 1 : (num1 < num2 ? -1 : 0);
		}
		if (type != 1) {
			int num1 = cards1.get(1);
			int num2 = cards2.get(1);
			return num1 > num2 ? 1 : (num1 < num2 ? -1 : 0);
		}
		for (int i = 2; i >= 0; i--) {
			int num1 = cards1.get(i);
			int num2 = cards2.get(i);
			if (num1 > num2)
				return 1;
			if (num1 < num2)
				return -1;
		}
		return 0;
	}

	private static int decideType(List<Integer> cards) {
		int num1 = cards.get(0), num2 = cards.get(1), num3 = cards.get(2);
		if (num1 == num2 && num2 == num3)
			return 4;
		if (num2 - num1 == 1 && num3 - num2 == 1)
			return 3;
		if (num1 == num2 || num2 == num3)
			return 2;
		return 1;
	}

	private static boolean analysis(HashMap<String, Integer> map, String s, List<Integer> cards) {
		int ind = 0;
		boolean flag = true;
		while (ind < s.length()) {
			if (s.charAt(ind) == '1') {
				if (ind + 1 < s.length() && s.charAt(ind + 1) == '0') {
					cards.add(10);
					ind = ind + 2;
				} else {
					flag = false;
					break;
				}
			} else {
				if (!map.containsKey(s.substring(ind, ind + 1))) {
					flag = false;
					break;
				} else {
					cards.add(map.get(s.substring(ind, ind + 1)));
					ind++;
				}
			}
		}
		return flag;
	}

}
