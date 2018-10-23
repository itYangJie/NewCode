package com.xmu.xz2016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class CharEncoding {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String line = in.nextLine();
			System.out.println(solve(line));
		}

	}
	
	static class Node{
		Node left,right;
		int freq;
		char c;
		Node(int freq,char c){
			this.freq = freq;
			this.c = c;
		}
	}
	static class CMP implements Comparator<Node>{
		@Override
		public int compare(Node o1, Node o2) {
			return o1.freq-o2.freq;
		}
		
	}
	private static int solve(String str) {
		char[] chars = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=chars.length-1;i>=0;i--) {
			if(!map.containsKey(chars[i]))
				map.put(chars[i], 1);
			else
				map.put(chars[i], 1+map.get(chars[i]));
		}
		List<Node> nodes = new ArrayList<>();
		for(Entry<Character, Integer> entry:map.entrySet()) {
			nodes.add(new Node(entry.getValue(),entry.getKey()));
		}
		while(nodes.size()>1) {
			Collections.sort(nodes,new CMP());
			Node node1 = nodes.remove(0);
			Node node2 = nodes.remove(0);
			Node newNode = new Node(node1.freq+node2.freq,' ');
			newNode.left = node1;
			newNode.right = node2;
			nodes.add(newNode);
		}
		Node root = nodes.get(0);
		return help(root,0);
	}
	private static int help(Node root, int level) {
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return root.freq*level;
		return help(root.left,level+1)+help(root.right,level+1);
	}

}
