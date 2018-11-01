package com.xmu.leetcode;

import java.util.Random;

import com.xmu.swordoffer.ListNode;

public class LinkedListRandomNode {
	
	private ListNode head = null;
	private Random r = null;
	public LinkedListRandomNode(ListNode head) {
		this.head = head;
		r = new Random();
	}

	/** Returns a random node's value. */
	public int getRandom() {
		
		ListNode cur = head;
		int res = cur.val;
		
		int total = 1;
		while(cur.next!=null) {
			cur = cur.next;
			total++;
			
			if(r.nextInt(total)+1==1)
				res = cur.val;
		}
		return res;
	}
}
