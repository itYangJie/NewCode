package com.xmu.swordoffer;

public class NumOfANumberInArray {

	public static void main(String[] args) {
		System.out.println(GetNumberOfK(new int[]{1,2,2,3,5}, 0));

	}
	public static int GetNumberOfK(int [] array , int k) {
		if(array.length==0)
			return 0;
	    int left = 0,right = array.length-1;
	    while(left<right) {
	    	int mid = (left+right)/2;
	    	if(array[mid]>=k)
	    		right = mid;
	    	else
	    		left = mid+1;
	    }
	    int startInd = left;
	    if(array[startInd]!=k)
	    	return 0;
	    
	    left = 0;
	    right = array.length-1;
	    while(left<right-1) {
	    	int mid = (left+right)/2;
	    	if(array[mid]>k)
	    		right = mid-1;
	    	else
	    		left = mid;
	    }
	    int endInd = right;
	    if(array[right]!=k)
	    	endInd = left;
	    
	    return endInd-startInd+1;
    }
}
