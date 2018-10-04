package com.xmu.interviewgold;

public class SplitLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double[] getBipartition(Point[] A, Point[] B) {
		double Ax = A[0].x;
		double Ay = A[0].y;
		boolean flagX = false;
		boolean flagY = false;
		for(int i=1;i<A.length;i++) {
			if(!flagX && A[i].x!=A[0].x) {
				flagX = true;
				Ax = (Ax+A[i].x)/2.0;
			}
			if(!flagY && A[i].y!=A[0].y) {
				flagY = true;
				Ay = (Ay+A[i].y)/2.0;
			}
		}
		
		double Bx = B[0].x;
		double By = B[0].y;
		flagX = false;
		flagY = false;
		for(int i=1;i<B.length;i++) {
			if(!flagX && B[i].x!=B[0].x) {
				flagX = true;
				Bx = (Bx+B[i].x)/2.0;
			}
			if(!flagY && B[i].y!=B[0].y) {
				flagY = true;
				By = (By+B[i].y)/2.0;
			}
		}
		double res[] = new double[2];
		res[0] = 1.0*(By-Ay)/(Bx-Ax);
		res[1] = Ay-res[0]*Ax;
		return res;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
        this.x = 0;
        this.y = 0;
    }
}
