package com.xmu.swordoffer;

import java.util.ArrayList;
public class PrintLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// 0,1,2,3,4
	 public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		 ArrayList<Integer> res = new ArrayList<>();
		 if(listNode==null)
			 return res;
		 while(listNode!=null) {
			 res.add(listNode.val);
			 listNode = listNode.next;
		 }
		 int size = res.size();
		for(int i=0;i<res.size()/2;i++) {
			int temp = res.get(i);
			res.set(i, res.get(size-i-1));
			res.set(size-i-1, temp);
		}
		return res;
	        
	}
}

