package com.xmu.swordoffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MediaNumInDataFlow {

	private int count = 0;
	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	});
	public void Insert(Integer num) {
		if(count%2==0) {
			//插入最大堆
			minHeap.add(num);
			maxHeap.add(minHeap.poll());
		}else {
			//插入最小堆
			maxHeap.add(num);
			minHeap.add(maxHeap.poll());
		}
		count++;
	}

	public Double GetMedian() {
		if(count%2==0) {
			return 0.5*(minHeap.peek()+maxHeap.peek());
		}else {
			return 1.0*maxHeap.peek();
		}
	}
}
