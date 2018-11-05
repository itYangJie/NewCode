package com.xmu.leetcode;

public class RemoveKBit {
	public static void main(String[] args) {
		System.out.println(
				new RemoveKBit().removeKdigits("1432219", 3));
	}
	public String removeKdigits(String num, int k) {
		
		int len = num.length();
		
		int rest = len-k;
		
		if(rest==0)
			return "0";
		if(rest==len)
			return num;
		StringBuffer sb = new StringBuffer();
		// 1 4 3 2 || 2 1 9  r=4
		int start = 0;
		boolean zeroFlag = true;
		for(int i=0;i<rest;i++) {
			int tempInd = start;
			int minInd = start;
			for(;tempInd<len-(rest-1)+i;tempInd++)
				if(num.charAt(tempInd)<num.charAt(minInd))
					minInd = tempInd;
			char c = num.charAt(minInd);
			if(c!='0' || !zeroFlag) {
				sb.append(c);
				zeroFlag = false;
			}
			start = minInd+1;
		}
		if("".equals(sb.toString()))
			return "0";
		return sb.toString();
		/*int dp[] = new int[rest];
		
		dp[rest-1] = rest-1;
		for(int i=rest-2;i>=0;i--) {
			if(num.charAt(i)<=num.charAt(dp[i+1]))
				dp[i] = i;
			else
				dp[i] = dp[i+1];
		}
		
		int dp2[] = new int[len-rest];
		dp2[len-rest-1] = len-1;
		for(int i=len-rest-2;i>=0;i--) {
			if(num.charAt(i+rest)<=num.charAt(dp2[i+1]))
				dp2[i] = i+rest;
			else
				dp2[i] = dp2[i+1];
		}
		// 1 4 3 2 || 2 1 9  r=4
		
		StringBuffer sb = new StringBuffer();
		
		int leftS = 0,rightS = -1;
		for(int i=0;i<k;i++) {
			if(rightS==-1) {
				sb.append(num.charAt(dp[leftS]));
				leftS = dp[leftS]+1;
				rightS++;
				continue;
			}
			if(leftS==rest) {
				sb.append()
			}
			num.charAt(dp[leftS])<=num.charAt(dp2[rightS])
		}
		return sb.toString();*/
	}
}
