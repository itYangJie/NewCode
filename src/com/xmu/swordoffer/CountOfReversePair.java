package com.xmu.swordoffer;

public class CountOfReversePair {

	public static void main(String[] args) {
		
		System.out.println(new CountOfReversePair().
				InversePairs(new int[] {1,2,3,4,5,6,7,0}));
	}
	private int res = 0;
	public int InversePairs(int[] array) {
		int n = array.length;
		if(n<=1)
			return 0;
		mergeSort(array, 0, n-1);
		return res;
	}
	private  void mergeSort(int[] nums,int left,int right) {
		if(left>=right)
			return;
		int mid = (right+left)/2;
		mergeSort(nums, left, mid);
		mergeSort(nums, mid+1, right);
		int[] temp = new int[right-left+1];
		
		int ind1 = left,ind2 = mid+1,ind=0;
		while(ind1<=mid && ind2<=right) {
			if(nums[ind1]<=nums[ind2]) {
				temp[ind++] = nums[ind1++];
			}
			else {
				res = (res+(mid-ind1+1)%1000000007)%1000000007;
				temp[ind++] = nums[ind2++];
			}
		}
		while(ind1<=mid) {
			temp[ind++] = nums[ind1++];
		}
		while(ind2<=right) {
			temp[ind++] = nums[ind2++];
		}
		for(int i=left;i<=right;i++)
			nums[i] = temp[i-left];
	}
}
