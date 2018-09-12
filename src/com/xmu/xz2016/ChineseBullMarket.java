package com.xmu.xz2016;

public class ChineseBullMarket {

	public static void main(String[] args) {
		System.out.println(calculateMax(new int[] {3,8,5,1,7,8}));

	}
	/**
     * 计算你能获得的最大收益
     * 
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
	//3,8,5,1,7,8
    public static int calculateMax(int[] prices) {
    	int[] left = new int[prices.length];
    	int[] right = new int[prices.length];
    	left[0] = 0;
    	int min = prices[0];
    	for(int i=1;i<prices.length;i++) {
    		left[i] = Math.max(left[i-1], prices[i]-min);
    		min = Math.min(min, prices[i]);
    	}
    	
    	right[prices.length-1]=0;
    	int max = prices[prices.length-1];
    	for(int i=prices.length-2;i>=0;i--) {
    		right[i] = Math.max(right[i+1], max-prices[i]);
    		max = Math.max(max, prices[i]);
    	}
    	int res = Integer.MIN_VALUE;
    	for(int i=0;i<prices.length-2;i++)
    		res = Math.max(res, left[i]+right[i+1]);
    	res = Math.max(res, left[prices.length-1]);
    	return res;
    }
}
