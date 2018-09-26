package com.xmu.swordoffer;

public class DeleteDuplicationNode {
	
	public ListNode deleteDuplication(ListNode pHead) {
		if(pHead==null || pHead.next==null)
			return pHead;
		ListNode font = new ListNode(Integer.MAX_VALUE);
		font.next = pHead;
		
		ListNode pre = font,cur = pHead,next = pHead.next;
		while(next!=null) {
			if(cur.val!=next.val) {
				pre = cur;
				cur = next;
				next = next.next;
			}else {
				while(next.next!=null && next.next.val==next.val)
					next = next.next;
				pre.next = next.next;
				cur = next.next;
				if(cur!=null)
					next = cur.next;
				else
					next = null;
			}
		}
		return font.next;
	}
}
