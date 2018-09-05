package com.xmu.xz2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Restaurant{

	public static void main(String[] args) {
		//读取数据
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] as = new int[n];
		boolean[] isUsed = new boolean[n];
		for(int i=0;i<n;i++) {
			as[i] = in.nextInt();
			isUsed[i] = false;
		}
		List<Cust> custs = new ArrayList<>();
		for(int i=0;i<m;i++) {
			Cust c = new Cust(in.nextInt(), in.nextInt());
			custs.add(c);
		}
		//排序
		Arrays.sort(as);
		Collections.sort(custs, new Comparator<Cust>() {
			@Override
			public int compare(Cust o1, Cust o2) {
				if (o1.c>o2.c)
					return 1;
				if(o1.c<o2.c)
					return -1;
				return o1.b<=o2.b?1:-1;
			}
		});
		//计算结果
		int res = 0,index=0;
		for(int i=m-1;i>=0;i--) {
			int b = custs.get(i).b;
			int c = custs.get(i).c;
			
			index = bs(as,b);
            while(index<n && isUsed[index]==true)
                index++;
            if(index<n){
                res += c;
                isUsed[index]=true;
            }
		}
		System.out.println(res);
	}
	public static class Cust{
		public int b,c;
		public Cust(int b,int c) {
			this.b = b;
			this.c = c;
		}
	}


	private static int bs(int[] num, int tar){
        int low=0;
        int high=num.length-1;
        int mid=0;
        while(low<=high){
            mid=(high+low)>>1;
            if(num[mid]>=tar)
                high=mid-1;
            else
                low=mid+1;
        }
         
        return low;
	}
}
