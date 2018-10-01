package com.xmu.xz2016;

import java.util.Stack;

public class MonoSum {

	public static void main(String[] args) {

	}
	
	int res = 0;
	public int calcMonoSum(int[] A, int n) {
        // write code here
        if(n==1)
            return 0;
        mergeSort(A,0,n-1);
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
				res = res+nums[ind1]*(right-ind2+1);
				temp[ind++] = nums[ind1++];
			}
			else
				temp[ind++] = nums[ind2++];
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
