package com.xmu.swordoffer;

public class FirstCommonNode {
	
	public ListNode FindFirstCommonNode(ListNode pHead1, 
			ListNode pHead2) {
		if(pHead1==null || pHead2==null)
			return null;
		if(pHead1==pHead2)
			return pHead1;
		int num1 = getNum(pHead1);
		int num2 = getNum(pHead2);
		if(num2>num1) {
			for(int i=0;i<num2-num1;i++)
				pHead2 = pHead2.next;
		}else if(num2<num1) {
			for(int i=0;i<num1-num2;i++)
				pHead1 = pHead1.next;
		}
		while(pHead1!=pHead2) {
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		return pHead1;
	}

	private int getNum(ListNode pHead) {
		ListNode cur = pHead;
		int count = 0;
		while(cur!=null) {
			cur = cur.next;
			count++;
		}
		return count;
	}
}
