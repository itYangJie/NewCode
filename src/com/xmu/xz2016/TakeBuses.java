package com.xmu.xz2016;

public class TakeBuses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int chooseLine(int[] stops, int[] period, int[] interval, 
			 int n, int s) {
		 int minTime = Integer.MAX_VALUE;
		 for(int i=0;i<n;i++) {
			 int waitTime = 0;
			 if(s%interval[i]!=0)
				 waitTime = interval[i]-(s%interval[i]);
			 minTime = Math.min(waitTime+5*(1+stops[i])+stops[i]*period[i],minTime);
		 }
		 return s+minTime;
	 }
}
