package com.xmu.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.xmu.swordoffer.ListNode;

public class MergeKSortedLists {
	class HeapObj{
		int val;
		int ind;
		HeapObj(int val,int ind){
			this.val = val;
			this.ind = ind;
		}
	}
	public ListNode mergeKLists(ListNode[] lists) {
		int k = lists.length;
		ListNode[] curs = new ListNode[k];
		
		ListNode font = new ListNode(-1);
		ListNode cur = font;
		
		PriorityQueue<HeapObj> heap = new PriorityQueue<>(new Comparator<HeapObj>() {
			@Override
			public int compare(HeapObj o1, HeapObj o2) {
				return o1.val-o2.val;
			}
		});
		for(int i=0;i<k;i++) {
			curs[i] = lists[i];
			if(curs[i]!=null) {
				heap.add(new HeapObj(curs[i].val, i));
			}
		}
		while(!heap.isEmpty()) {
			HeapObj re = heap.remove();
			
			cur.next = curs[re.ind];
			cur = cur.next;
			
			if(curs[re.ind].next!=null) {
				curs[re.ind] = curs[re.ind].next;
				heap.add(new HeapObj(curs[re.ind].val, re.ind));
			}
		}
		return font.next;
	}
}
