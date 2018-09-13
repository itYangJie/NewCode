package com.xmu.xz2016;

public class BinarySearch {

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.getPos(new int[] {1,2,3,3,3,5,7,9},8,3));
	}
	//[1,3,5,7,9],5,3
   public int getPos(int[] A, int n, int val) {
	   if(val>A[n-1]||val<A[0])
		   return -1;
	   int left=0,right=n-1;
	   while(left<right) {
		   int mid = (left+right)/2;
		   if(A[mid]<val)
			   left = mid+1;
		   else
			   right = mid;
	   }
	   return A[left]==val?left:-1;
    }
}
