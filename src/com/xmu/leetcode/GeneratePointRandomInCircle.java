package com.xmu.leetcode;

import java.util.Random;

public class GeneratePointRandomInCircle {
	private double r, x, y;

	public GeneratePointRandomInCircle(double radius, double x_center, double y_center) {
		this.r = radius;
		this.x = x_center;
		this.y = y_center;
	}

	public double[] randPoint() {
    	
    	double ca = (int) (Math.random() * 360);

    	double cr = Math.sqrt(Math.random()) * r;

    	return new double[]{x + cr * Math.cos(ca),y + cr* Math.sin(ca)};

    	
    }
}
