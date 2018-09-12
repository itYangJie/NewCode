package com.xmu.test;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> {
	
	private int size;
	private List<T> datas;
	public Heap() {
		this.size = 0;
		this.datas = new ArrayList<>();
	}
	public Heap(T[] array) {
		this.size = array.length;
		build(array);
		this.datas = new ArrayList<>();
		for(int i=0;i<array.length;i++)
			datas.add(array[i]);
	}
	private void build(T[] array) {
		for(int i=(array.length-1)/2;i>=0;i--)
			adjust(array,i);
	}
	private void adjust(T[] array, int parent) {
		int left = 2*parent+1,right = 2*parent+2;
		int swapInd = parent;
		if(left<size && array[swapInd].compareTo(array[left])>0)
			swapInd = left;
		if(right<size && array[swapInd].compareTo(array[right])>0)
			swapInd = right;
		if(swapInd==parent)
			return;
		T temp = array[swapInd];
		array[swapInd] = array[parent];
		array[parent] = temp;
		adjust(array, swapInd);
	}
	public void add(T data) {
		datas.add(data);
		size++;
		int cur = size-1,parent;
		while(cur!=0) {
			parent = (cur-1)/2;
			if(datas.get(cur).compareTo(datas.get(parent))<0) {
				T temp = datas.get(parent);
				datas.set(parent, datas.get(cur));
				datas.set(cur, temp);
				cur = parent;
			}else
				break;
		}
	}
	public T remove() {
		if(size==0)
			return null;
		T r = datas.get(0);
		datas.set(0, datas.get(size-1));
		datas.remove(size-1);
		size--;
		updateRemove(0);
		return r;
	}
	
	private void updateRemove(int parent) {
		if(parent>=size || 2*parent+1>=size)
			return;
		int left = 2*parent+1,right = 2*parent+2;
		int swapInd = parent;
		if(left<size && datas.get(swapInd).compareTo( datas.get(left))>0)
			swapInd = left;
		if(right<size &&  datas.get(swapInd).compareTo( datas.get(right))>0)
			swapInd = right;
		if(swapInd==parent)
			return;
		T temp =  datas.get(swapInd);
		datas.set(swapInd, datas.get(parent));
		datas.set(parent, temp);
		updateRemove(swapInd);
	}
	public boolean isEmpty() {
		return size==0;
	}
	public static void main(String[] args) {
	
		/*Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});*/
		Heap<Integer> q = new Heap<>();
		q.add(5);
		q.add(-2);
		q.add(10);
		q.add(7);
		System.out.println(q.remove());
		q.add(-9);
		q.add(10);
		System.out.println("---------------------");
		while(!q.isEmpty())
			System.out.println(q.remove());
		System.out.println("---------------------");
		q = new Heap<>(new Integer[]{-1,3,2,1,54,-3,54,-2});
		while(!q.isEmpty())
			System.out.println(q.remove());
		
	}
	
}
