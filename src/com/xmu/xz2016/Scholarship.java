package com.xmu.xz2016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Scholarship {
	
	static class Subject{
		int a,b;
		public Subject(int a,int b) {
			this.a = a;
			this.b = b;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt(),r = in.nextInt(),avg = in.nextInt();
			List<Subject> list = new ArrayList<>();
			long curScore = 0;
			for(int i=0;i<n;i++) {
				list.add(new Subject(in.nextInt(),in.nextInt()));
				curScore += list.get(i).a;
			}
			long needScore = avg*n-curScore;
			if(needScore<=0) {
				System.out.println(0);
				return;
			}
				
			Collections.sort(list,new Comparator<Subject>() {
				@Override
				public int compare(Subject o1, Subject o2) {
					if(o1.b==o2.b) 
						return o1.a-o2.a;
					else 
						return o1.b-o2.b;
				}
			});
			long minStudyTime = 0;
			for(int i=0;i<n;i++) {
				int maxScore = r-list.get(i).a;
				if(maxScore<needScore) {
					minStudyTime += list.get(i).b*maxScore;
					needScore -= maxScore;
				}else {
					minStudyTime += list.get(i).b*needScore;
					break;
				}
			}
			System.out.println(minStudyTime);
		}
	}

}
