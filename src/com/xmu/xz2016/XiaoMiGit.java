package com.xmu.xz2016;



public class XiaoMiGit {

	public static void main(String[] args) {
		String[] matrix = {"01011","10100","01000","10000","10000"};
		int indexA = 3,indexB = 4;
		System.out.println(getSplitNode(matrix, indexA, indexB));
	}
	
    /**
     * 返回git树上两点的最近分割点
     * 
     * @param matrix 接邻矩阵，表示git树，matrix[i][j] == '1' 当且仅当git树中第i个和第j个节点有连接，节点0为git树的跟节点
     * @param indexA 节点A的index
     * @param indexB 节点B的index
     * @return 整型
     */
    public static int getSplitNode(String[] matrix, int indexA, int indexB) {
    	
    	return solve(0,-1,matrix,indexA,indexB);
    }

	private static int solve(int root,int parent, String[] matrix, int indexA, int indexB) {
		if(indexA==root || indexB==root)
			return root;
		for(int i=0;i<matrix.length;i++) {
			if(i!=parent && matrix[root].charAt(i)=='1') {
				boolean canA = dfs(i,root,indexA,matrix);
				boolean canB = dfs(i,root,indexB,matrix);
				if(canA&&canB)
					return solve(i,root,matrix,indexA,indexB);
			}
		}
		return root;	
		
	}

	private static boolean dfs(int root, int parent, int find, String[] matrix) {
		if(find==root)
			return true;
		for(int i=0;i<matrix.length;i++) {
			if(i!=parent && matrix[root].charAt(i)=='1') {
				if(dfs(i,root,find,matrix))
					return true;
			}
		}
		return false;
	}

}
