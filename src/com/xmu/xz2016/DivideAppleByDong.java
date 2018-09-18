package com.xmu.xz2016;

public class DivideAppleByDong {

	public static void main(String[] args) {
		System.out.println(getInitial(3));
	}
	public static int getInitial(int n) {
        
		for(int i=n;;i++) {
			int total = i;
			boolean flag = true;
			for(int j=0;j<n;j++) {
				if((total-1)%n==0)
					total = (total-1)/n*(n-1);
				else {
					flag = false;
					break;
				}
			}
			if(flag)
				return i;
		}
    }
}
