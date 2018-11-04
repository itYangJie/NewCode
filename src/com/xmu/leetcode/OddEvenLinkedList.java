package com.xmu.leetcode;

import com.xmu.swordoffer.ListNode;

public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		
		ListNode fontOdd = new ListNode(-1);
		ListNode fontEven = new ListNode(-1);
		
		ListNode cur = head,curOdd = fontOdd,curEven = fontEven;
		
		int ind = 1;
		while(cur!=null) {
			if(ind%2==1) {
				curOdd.next = cur;
				curOdd = curOdd.next;
			}else {
				curEven.next = cur;
				curEven = curEven.next;
			}
			cur = cur.next;
			ind++;
		}
		curOdd.next = fontEven.next;
		curEven.next = null;
		return fontOdd.next;
	}
}
