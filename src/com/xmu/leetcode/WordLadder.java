package com.xmu.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("hot");
		list.add("dot");
		list.add("dog");
		list.add("lot");
		list.add("log");
		list.add("cog");
		new WordLadder().findLadders("hit", "cog", list);
	}
	public int[] dijkstra(int[][] road, int s, int n) {
		int[] dist = new int[n];
		boolean[] isVisited = new boolean[n];
		for (int i = 0; i < n; i++) {
			dist[i] = road[s][i];
		}
		for (int i = 0; i < n; i++) {
			int minDist = Integer.MAX_VALUE;
			int v = -1;
			for (int j = 0; j < n; j++) {
				if (!isVisited[j] && dist[j] < minDist) {
					minDist = dist[j];
					v = j;
				}
			}
			if (v == -1)
				break;
			isVisited[v] = true;
			for (int j = 0; j < n; j++) {
				if (!isVisited[j] && road[v][j] < Integer.MAX_VALUE) {
					if (dist[v] + road[v][j] < dist[j])
						dist[j] = dist[v] + road[v][j];
				}
			}
		}
		return dist;
	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<>();

		wordList.add(0, beginWord);
		int n = wordList.size();
		int end = -1;
		for (int i = 0; i < n; i++) {
			if (endWord.equals(wordList.get(i))) {
				end = i;
				break;
			}
		}
		if (end == -1)
			return res;

		int[][] road = new int[n][n];
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (can(wordList.get(i), wordList.get(j))) {
					road[i][j] = 1;
					road[j][i] = 1;
				} else {
					road[i][j] = Integer.MAX_VALUE;
					road[j][i] = Integer.MAX_VALUE;
				}
			}
		}

		int[] dist = dijkstra(road, 0, n);
		if (dist[end] == Integer.MAX_VALUE)
			return res;
		return solve(dist, road, end, wordList);
	}

	private List<List<String>> solve(int[] dist, int[][] road, int end, List<String> wordList) {
		List<List<String>> res = new ArrayList<>();
		if (end == 0) {
			List<String> temp = new ArrayList<>();
			temp.add(wordList.get(0));
			res.add(temp);
		} else {
			for (int i = 0; i < dist.length; i++) {
				if (dist[i] == dist[end] - 1 && road[i][end] != Integer.MAX_VALUE) {
					List<List<String>> temp = solve(dist, road, i, wordList);
					for (int j = 0; j < temp.size(); j++) {
						temp.get(j).add(wordList.get(end));
						res.add(temp.get(j));
					}
				}
			}
		}
		return res;
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Queue<Word> queue = new LinkedList<>();
		queue.add(new Word(beginWord, 1));

		while (!queue.isEmpty()) {
			Word w = queue.remove();
			Iterator<String> iterator = wordList.iterator();
			while (iterator.hasNext()) {
				String cur = iterator.next();
				if (can(w.str, cur)) {
					if (endWord.equals(cur)) {
						return w.dis + 1;
					}
					queue.add(new Word(cur, w.dis + 1));
					iterator.remove();
				}
			}
		}
		return 0;
	}

	private boolean can(String str, String cur) {
		int len1 = str.length();
		int len2 = cur.length();
		if (len1 != len2)
			return false;
		int count = 0;
		for (int i = 0; i < len1; i++) {
			if (str.charAt(i) != cur.charAt(i))
				count++;
		}
		return count == 1;
	}

	class Word {
		String str;
		int dis;
		String last;

		public Word(String str, String last, int dis) {
			this.str = str;
			this.dis = dis;
			this.last = last;
		}

		public Word(String str, int dis) {
			this.str = str;
			this.dis = dis;
		}
	}
}
