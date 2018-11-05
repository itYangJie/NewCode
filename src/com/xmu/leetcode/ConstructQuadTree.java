package com.xmu.leetcode;

public class ConstructQuadTree {
	public static void main(String[] args) {
		new ConstructQuadTree().construct(new int[][] {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},
		                                                {1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},
		                                                {1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},
		                                                {1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}});
	}
	class Node {
		public boolean val;
		public boolean isLeaf;
		public Node topLeft;
		public Node topRight;
		public Node bottomLeft;
		public Node bottomRight;

		public Node() {
		}

		public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
			val = _val;
			isLeaf = _isLeaf;
			topLeft = _topLeft;
			topRight = _topRight;
			bottomLeft = _bottomLeft;
			bottomRight = _bottomRight;
		}
	};

	public Node construct(int[][] grid) {
		int N = grid.length;
		return solve(grid, 0, 0, N - 1, N - 1);
	}

	private Node solve(int[][] grid, int x_top_left, int y_top_left, int x_bottom_right, int y_bottom_right) {
		if (x_top_left == x_bottom_right && y_top_left == y_bottom_right) {
			Node node = new Node();
			node.isLeaf = true;
			node.val = (grid[x_top_left][y_top_left] == 1);
			return node;
		}
		Node topLeft = solve(grid, x_top_left, y_top_left, (x_top_left + x_bottom_right) / 2,
				(y_top_left + y_bottom_right) / 2);
		Node topRight = solve(grid, x_top_left, 1 + (y_top_left + y_bottom_right) / 2,
				(x_top_left + x_bottom_right) / 2, y_bottom_right);
		Node bottomLeft = solve(grid, 1 + (x_top_left + x_bottom_right) / 2, y_top_left,
				x_bottom_right ,(y_top_left + y_bottom_right) / 2 );
		Node bottomRight = solve(grid, 1 + (x_top_left + x_bottom_right) / 2, 1 + (y_top_left + y_bottom_right) / 2,
				x_bottom_right, y_bottom_right);

		Node node = new Node();
		if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
			if (topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
				node.isLeaf = true;
				node.val = topLeft.val;
				return node;
			}
		}
		node.isLeaf = false;
		node.topLeft = topLeft;
		node.topRight = topRight;
		node.bottomLeft = bottomLeft;
		node.bottomRight = bottomRight;
		return node;
	}
}
