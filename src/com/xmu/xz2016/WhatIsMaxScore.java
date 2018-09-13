package com.xmu.xz2016;

import java.util.Scanner;


public class WhatIsMaxScore {
	
	static class Node{
		int left,right,val;
		public Node(int left, int right, int val) {
			super();
			this.left = left;
			this.right = right;
			this.val = val;
		}
	}
	private static Node[] nodes;
	
	public static void main(String[] args) throws Exception {
        int M=0 ,N=0;
        int i;
        int A = 0,B = 0;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            N = in.nextInt();
            M = in.nextInt();  
     
            int[] score = new int[N];
            for(i=0; i<N; i++){
                score[i] = in.nextInt();
            }
            
    		int len = score.length;
    		nodes = new Node[4*len];
    		build(score,0,score.length-1,0);
    		
            String c = null;
            for(i=0; i< M; i++){
                c  = in.next();
                A = in.nextInt();
                B = in.nextInt();  
                process(c,A,B);
            }
        }
             
    }
	public static void build(int[] nums, int left, int right, int parent) {
		if(left==right) {
			nodes[parent] = new Node(left, right, nums[left]);
			return;
		}
		
		int mid = (right+left)/2;
		
		build(nums,left,mid,2*parent+1);
		build(nums,mid+1,right,2*parent+2);
		nodes[parent] = new Node(left, right, 
				Math.max(nodes[2*parent+1].val, nodes[2*parent+2].val));
	}
	public static void update(int index,int val) {
		if(nodes==null || index<nodes[0].left ||index>nodes[0].right)
			return;
		updateHelp(nodes[0].left,nodes[0].right,0,index,val);
	}
	private static void updateHelp(int left, int right, int parent, int index, int val) {
		if(left==right) {
			nodes[parent].val = val;
			return;
		}
		int mid = (left+right)/2;
		if(index<=mid) 
			updateHelp(left, mid, 2*parent+1, index, val);
		else
			updateHelp(mid+1, right, 2*parent+2, index, val);
		nodes[parent].val = Math.max(nodes[2*parent+1].val, nodes[2*parent+2].val);
	}
	public static int query(int l,int r) throws Exception {
		if(nodes==null || l>r || r<nodes[0].left || l>nodes[0].right)
			throw new Exception("Interval is not legitimate");
		if(l<0)
			l = 0;
		if(r>nodes[0].right)
			r = nodes[0].right;
		return queryHelp(nodes[0].left,nodes[0].right,0,l,r);
	}
	private static int queryHelp(int left, int right, int parent, int l, int r) {
		if(l==left && r==right)
			return nodes[parent].val;
		int mid = (left+right)/2;
		if(r<=mid)
			return queryHelp(left, mid, 2*parent+1, l, r);
		if(l>mid)
			return queryHelp(mid+1, right, 2*parent+2, l, r);
		return Math.max(queryHelp(left, mid, 2*parent+1, l, mid),
				queryHelp(mid+1, right, 2*parent+2, mid+1, r));

	}
    private static void process(String c, int a, int b) throws Exception {
         
        if(c.equals("Q")){
            System.out.println(query(Math.min(a, b)-1, Math.max(a, b)-1));
        }else if(c.equals("U")){
            update(a-1, b);
        }
    }

}
