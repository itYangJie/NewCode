package com.xmu.swordoffer;

public class PostOrderTraversal {
	
	public boolean VerifySquenceOfBST(int[] sequence) {
		if(sequence.length==0)
			return false;
		if(sequence.length==1)
			return true;
		return solve(sequence,0,sequence.length-1);
	}

	private boolean solve(int[] sequence, int left, int right) {
		if(left>=right)
			return true;
		int root = sequence[right];
		int leftInd = left;
		while(leftInd<=right && sequence[leftInd]<root)
			leftInd++;
		leftInd--;
		
		int rightInd = leftInd+1;
		for(int i=rightInd;i<right;i++) {
			if(sequence[i]<=root)
				return false;
		}
		return solve(sequence,left,leftInd) && solve(sequence,rightInd,right-1);
		
	}
}
