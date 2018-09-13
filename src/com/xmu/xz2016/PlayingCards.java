package com.xmu.xz2016;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayingCards {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		String[] cards = str.split("-");
		int type0 = getCardsType(cards[0]);
		int type1 = getCardsType(cards[1]);
		
		if(type0==6 || type1==6) {
			System.out.println("joker JOKER");
			return;
		}
		if(type0==5 && type1!=5) {
			System.out.println(cards[0]);
			return;
		}
		if(type1==5 && type0!=5) {
			System.out.println(cards[1]);
			return;
		}
		if(type0!=type1) {
			System.out.println("ERROR");
			return;
		}
		Map<String, Integer> map = getMap();
		System.out.println(compare(cards[0],cards[1],map));
	}

	private static Map<String, Integer> getMap() {
		Map<String,Integer> map = new HashMap<>();
		map.put("3", 1);
		map.put("4", 2);
		map.put("5", 3);
		map.put("6", 4);
		map.put("7", 5);
		map.put("8", 6);
		map.put("9", 7);
		map.put("10", 8);
		map.put("J", 9);
		map.put("Q", 10);
		map.put("K", 11);
		map.put("A", 12);
		map.put("2", 13);
		map.put("joker", 14);
		map.put("JOKER", 15);
		return map;
	}

	private static String compare(String str1, String str2, Map<String, Integer> map) {
		String firstCard1 = str1.split(" ")[0];
		String firstCard2 = str2.split(" ")[0];
		if(map.get(firstCard1)>map.get(firstCard2))
			return str1;
		return str2;
	}

	private static int getCardsType(String str) {
		String[] cards = str.split(" ");
		if(cards.length==1)
			return 1;
		if(cards.length==2) {
			if(cards[0].equals("joker")||cards[0].equals("JOKER"))
				return 6;
			else
				return 2;
		}
		if(cards.length==5)
			return 3;
		if(cards.length==3)
			return 4;
		return 5;
	}

}
