package com.xmu.test;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		int[] nums1 = {1};
		heapSort(nums1);
		System.out.println(Arrays.toString(nums1));
		
		int[] nums2 = {-1,-10,5,3,1,6,1,-10,6,5,2,12,1};
		heapSort(nums2);
		System.out.println(Arrays.toString(nums2));
	}
	private static void bubbleSort(int[] nums) {
		if(nums.length<=1)
			return;
		int temp = 0;
		for(int i=0;i<nums.length-1;i++) {
			for(int j=0;j<nums.length-1-i;j++) {
				if(nums[j]>nums[j+1]) {
					temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
	}
	private static void selectSort(int[] nums) {
		if(nums.length<=1)
			return;
		for(int i=nums.length-1;i>0;i--) {
			int maxInd = 0;
			for(int j=0;j<=i;j++) {
				if(nums[j]>nums[maxInd])
					maxInd = j;
			}
			int temp = nums[maxInd];
			nums[maxInd] = nums[i];
			nums[i] = temp;
		}
	}
	private static void insertSort(int[] nums) {
		if(nums.length<=1)
			return;
		for(int i=1;i<nums.length;i++) {
			int j = i-1,mainEle = nums[i];
			while(j>=0 && nums[j]>mainEle) {
				nums[j+1] = nums[j];
				j--;
			}
			nums[j+1] = mainEle;	
		}
	}
	private static void quickSort(int[] nums,int left,int right) {
		if(left>=right)
			return;
		int ind = partration(nums,left,right);
		quickSort(nums, left, ind-1);
		quickSort(nums, ind+1, right);
		
	}
	private static int partration(int[] nums, int left, int right) {
		int mainEle = nums[left];
		while(left<right) {
			while(left<right && nums[right]>mainEle)
				right--;
			nums[left] = nums[right];
			while(left<right && nums[left]<=mainEle)
				left++;
			nums[right] = nums[left];
		}
		nums[right] = mainEle;
		return right;
	}
	private static void mergeSort(int[] nums,int left,int right) {
		if(left>=right)
			return;
		int mid = (right+left)/2;
		mergeSort(nums, left, mid);
		mergeSort(nums, mid+1, right);
		int[] temp = new int[right-left+1];
		
		int ind1 = left,ind2 = mid+1,ind=0;
		while(ind1<=mid && ind2<=right) {
			if(nums[ind1]<nums[ind2])
				temp[ind++] = nums[ind1++];
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
	private static void heapSort(int[] nums) {
		if(nums.length<=1)
			return;
		for(int i=(nums.length-1)/2;i>=0;i--)
			adjust(nums,i,nums.length);
		int size = nums.length;
		for(int i=nums.length-1;i>0;i--) {
			int temp = nums[i];
			nums[i] = nums[0];
			nums[0] = temp;
			adjust(nums,0,--size);
		}
	}
	private static void adjust(int[] nums, int parent,int size) {
		int left = 2*parent+1,right = 2*parent+2;
		int swapInd = parent;
		if(left<size && nums[swapInd]<nums[left])
			swapInd = left;
		if(right<size && nums[swapInd]<nums[right])
			swapInd = right;
		if(swapInd==parent)
			return;
		int temp = nums[swapInd];
		nums[swapInd] = nums[parent];
		nums[parent] = temp;
		adjust(nums, swapInd,size);
	}
}
