package com.xmu.interviewgold;

public class WordClosestDistance {
	
	public int getDistance(String[] article, int n,
			String x, String y) {
		
		int min = Integer.MAX_VALUE;
		int xInd = -1;
		int yInd = -1;
		for(int i=0;i<n;i++) {
			String s = article[i];
			if(s.equals(x)) {
				xInd = i;
				if(yInd!=-1)
					min = Math.min(min, xInd-yInd);
			}
			if(s.equals(y)) {
				yInd = i;
				if(xInd!=-1)
					min = Math.min(min, yInd-xInd);
			}
		}
		return min;
	}
}
