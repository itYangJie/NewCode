package com.xmu.xz2016;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteNum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			List<Integer> list = new ArrayList<>();
			for(int i=0;i<n;i++)
				list.add(i);
			int k=3;
			int delInd = (k-1)%n;
			while(list.size()>1) {
				list.remove(delInd);
				delInd = (delInd+k-1)%list.size();
			}
			System.out.println(list.get(0));
		}
	}

}
