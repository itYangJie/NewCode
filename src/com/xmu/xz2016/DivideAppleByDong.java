package com.xmu.xz2016;

public class DivideAppleByDong {

	public static void main(String[] args) {
		System.out.println(getInitial(2));
	}
	public static int getInitial(int n) {
        int x = 0;
        for(int i=0;i<n;i++) {
        	x = 1+n*x/(n-1);
        }
        return x;
    }
}
