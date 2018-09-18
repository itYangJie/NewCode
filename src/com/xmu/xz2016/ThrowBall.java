package com.xmu.xz2016;


public class ThrowBall {
	public static void main(String[] args) {
		ThrowBall t = new ThrowBall();
		System.out.println(t.calcDistance(100, 90, 80, 70));
	}
	public int calcDistance(int A, int B, int C, int D) {
		return 3*(A+B+C+D);
    }
	
}
