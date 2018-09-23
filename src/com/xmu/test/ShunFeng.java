package com.xmu.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShunFeng {
	
	static class Schedu{
		double start,end;
		public Schedu(double start,double end) {
			this.start = start;
			this.end = end;
		}
	}
	static int schedule(double[] data) {
		if(data.length<=2)
			return 0;
		int num = data.length/2;
		
		List<Schedu> list = new ArrayList<>();
		for(int i=0;i<num;i++) 
			list.add(new Schedu(data[2*i], data[2*i+1]));
		
		Collections.sort(list,new Comparator<Schedu>() {
			@Override
			public int compare(Schedu o1, Schedu o2) {
				if(o1.end<o2.end)
					return -1;
				else
					return 1;
			}
		});
		
		double end = -1.0;
		int res = 0;
		for(int i=0;i<num;i++) {
			if(end<list.get(i).start) {
				res++;
				end = list.get(i).end;
			}
		}
		return num-res;
	}
	public static void main(String[] args) {
		System.out.println(schedule(new double[] {12.0,14.5,8.0,10.0,
				8.0,10.0,8.0,10.0,8.0,10.0}));
	}
}
