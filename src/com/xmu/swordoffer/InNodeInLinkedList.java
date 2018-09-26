package com.xmu.swordoffer;

public class InNodeInLinkedList {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if(pHead==null)
			return null;
		ListNode fast = pHead;
		ListNode slow = pHead;
		while(fast!=null) {
			slow = slow.next;
			if(fast.next!=null)
				fast = fast.next.next;
			else
				fast=null;
			if(slow==fast)
				break;
		}
		if(fast==null)
			return null;
		slow = pHead;
		while(slow!=fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
