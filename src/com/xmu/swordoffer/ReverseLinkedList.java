package com.xmu.swordoffer;


public class ReverseLinkedList {
	public ListNode ReverseList(ListNode head) {
		if(head==null || head.next==null)
			return head;
		ListNode node1 = head,node2 = head.next,node3 = head.next.next;
		boolean flag = true;
		while(true) {
			if(flag) {
				node1.next = null;
				flag = false;
			}
			node2.next = node1;
			if(node3==null)
				break;
			node1 = node2;
			node2 = node3;
			node3 = node3.next;
			
		}
		return node2;
	}

	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
