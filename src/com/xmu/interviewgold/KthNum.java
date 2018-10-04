package com.xmu.interviewgold;

public class KthNum {

	public static void main(String[] args) {
		findKth(16);
	}

	public static int findKth(int k) {
		int dp[] = new int[k+1];
		dp[0] = 1;
		
		int threeInd = 0,fiveInd=0,sevenInd = 0;
		for(int i=1;i<=k;i++) {
			dp[i] = Math.min(dp[threeInd]*3,Math.min(dp[fiveInd]*5, 
					dp[sevenInd]*7));
			if(dp[i]==dp[threeInd]*3)
				threeInd++;
			if(dp[i]==dp[fiveInd]*5)
				fiveInd++;
			if(dp[i]==dp[sevenInd]*7)
				sevenInd++;
		}
		return dp[k];
	}
}
