package com.xmu.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DiDiTrajectory {
	
	static class Point{
		double x,y;
		public Point(double x,double y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0;i<T;i++) {
			int n = in.nextInt();
			List<Point> starts = new ArrayList();
			List<Point> ends = new ArrayList();
			in.nextLine();
			for(int j=0;j<n;j++) {
				String command = in.nextLine();
				String[] split = command.split(" ");
				if(split.length==5) {
					starts.add(new Point(Double.parseDouble(split[1]), Double.parseDouble(split[2])));
					ends.add(new Point(Double.parseDouble(split[3]), Double.parseDouble(split[4])));
				}else {
					int count = 1,ind=Integer.parseInt(split[1])-1;
					Point A = starts.get(ind);
					Point B = ends.get(ind);
					Point C,D;
					for(int k=starts.size()-1;k>=0;k--) {
						if(k==ind)
							continue;
						C = starts.get(k);
						D = ends.get(k);
						if(sideIntersectSide(A,B,C,D))
							count++;
					}
					System.out.println(count);
				}
			}
			System.out.println();
		}
	}

	static boolean lineIntersectSide(Point A, Point B, Point C, Point D)  
	    {        
	    double fC = (C.y - A.y) * (A.x - B.x) - (C.x - A.x) * (A.y - B.y);  
	    double fD = (D.y - A.y) * (A.x - B.x) - (D.x - A.x) * (A.y - B.y);       
	        if(fC * fD > 0){
	            return false; 
	        }  
	                 
	        return true;
	    }  
	    static boolean sideIntersectSide(Point A, Point B, Point C, Point D)  
	    {  
	        if(!lineIntersectSide(A, B, C, D)) {
	            return false;  
	        } 
	            
	        if(!lineIntersectSide(C, D, A, B)){
	            return false;  
	        }  
	            
	        return true;  
	    }
}
