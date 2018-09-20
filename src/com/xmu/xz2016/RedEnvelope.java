package com.xmu.xz2016;

public class RedEnvelope {

	public static void main(String[] args) {

	}
	public int getValue(int[] gifts, int n) {
		if(n==1)
			return gifts[0];
		int temp = 0,count = 0;
		for(int i=0;i<n;i++) {
			if(count==0) {
				count++;
				temp = gifts[i];
			}else {
				if(temp==gifts[i])
					count++;
				else
					count--;
			}
		}
		int size = 0;
		for(int i=0;i<n;i++)
			if(gifts[i]==temp)
				size++;
		return (size>n/2?temp:0);
    }
}
