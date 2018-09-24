package com.xmu.swordoffer;

import java.awt.List;

public class MergeTwoLinkedList {
	
	public ListNode Merge(ListNode list1, ListNode list2) {
		if(list1==null)
			return list2;
		if(list2==null)
			return list1;
		ListNode font = new ListNode(0);
		ListNode cur = font;
		while(list1!=null && list2!=null) {
			if(list1.val<list2.val) {
				cur.next = list1;
				list1 = list1.next;
			}else {
				cur.next = list2;
				list2 = list2.next;
			}
			cur = cur.next;
		}
		if(list1==null)
			cur.next = list2;
		if(list2==null)
			cur.next = list1;
		return font.next;
	}

}
