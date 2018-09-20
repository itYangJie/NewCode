package com.xmu.swordoffer;

public class MinNumOfRotatingArray {
	
	public static void main(String[] args) {
		System.out.println(minNumberInRotateArray(new int[] {4,4,4}));
	}
	public static int minNumberInRotateArray(int [] array) {
	    if(array.length==0)
	    	return 0;
	    if(array.length==1)
	    	return array[0];
	    int left=0,right = array.length-1;
	    if(array[right]>array[left])
	    	return array[left];
	    while(left<right-1) {
	    	int mid = (left+right)/2;
	    	if(array[mid]>array[left])
	    		left = mid+1;
	    	else
	    		right=mid;
	    }
	    return Math.min(array[left],array[right]);
    }
}
