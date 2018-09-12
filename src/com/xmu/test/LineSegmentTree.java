package com.xmu.test;

public class LineSegmentTree {
	
	class Node{
		int left,right,val;
		public Node(int left, int right, int val) {
			super();
			this.left = left;
			this.right = right;
			this.val = val;
		}
	}
	private Node[] nodes;
	public LineSegmentTree(int[] nums) {
		if (nums==null || nums.length==0)
			return;
		int len = nums.length;
		nodes = new Node[4*len];
		build(nums,0,nums.length-1,0);
	}
	public void build(int[] nums, int left, int right, int parent) {
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
	public void update(int index,int val) {
		if(nodes==null || index<nodes[0].left ||index>nodes[0].right)
			return;
		updateHelp(nodes[0].left,nodes[0].right,0,index,val);
	}
	private void updateHelp(int left, int right, int parent, int index, int val) {
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
	public int query(int l,int r) throws Exception {
		if(nodes==null || l>r || r<nodes[0].left || l>nodes[0].right)
			throw new Exception("Interval is not legitimate");
		if(l<0)
			l = 0;
		if(r>nodes[0].right)
			r = nodes[0].right;
		return queryHelp(nodes[0].left,nodes[0].right,0,l,r);
	}
	private int queryHelp(int left, int right, int parent, int l, int r) {
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
	public static void main(String[] args) throws Exception {
		int[] nums = new int[] {0,1,-5,6,2,10,-9,20,-5,-9,20,100,-90};
		LineSegmentTree tree = new LineSegmentTree(nums);
		System.out.println(tree.query(-5, 0));
		System.out.println(tree.query(-6, 3));
		System.out.println(tree.query(12, 15));
		System.out.println(tree.query(10, 16));
		System.out.println(tree.query(5, 8));
		System.out.println(tree.query(4, 10));
		System.out.println(tree.query(5, 5));
		System.out.println(tree.query(1, 3));
		tree.update(2, 10);
		System.out.println(tree.query(1, 3));
	}

}
