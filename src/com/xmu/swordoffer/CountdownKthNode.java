package com.xmu.swordoffer;

public class CountdownKthNode {
	
	public ListNode FindKthToTail(ListNode head,int k) {
		if(head==null || k==0)
			return null;
		ListNode slow = head,fast = head;
		for(int i=0;i<k-1;i++) {
			fast = fast.next;
			if(fast==null)
				return null;
		}
		while(fast.next!=null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
		
    }
}
