package com.xmu.xz2017;

import java.util.Scanner;

public class NotTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int W = in.nextInt();
		int H = in.nextInt();
		
		int numPerLine = W/4*2;
		if (W%4==1)
			numPerLine = numPerLine+1;
		else if(W%4==2 || W%4==3)
			numPerLine = numPerLine+2;
		int total = H/4*2*W;
		if (H%4==1) 
			total = total+numPerLine;
		else if(H%4==2)
			total = total+2*numPerLine;
		else if(H%4==3)
			total = total+numPerLine+W;
		System.out.println(total);
		
	}

}
