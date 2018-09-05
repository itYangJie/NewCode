package com.xmu.xz2017;

import java.util.Scanner;

public class StrongestBrain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for(int i=0;i<1;i++) {
			String ser = in.nextLine();
			String firstSee = in.nextLine();
			String secondSee = in.nextLine();
			
			boolean isForward = decide(ser,firstSee,secondSee);
			boolean isBackward = decide(new StringBuffer(ser).reverse().toString(),firstSee,secondSee);
			
			if(isForward==true && isBackward==true)
				System.out.println("both");
			else if(isForward==true)
				System.out.println("forward");
			else if (isBackward==true)
				System.out.println("backward");
			else
				System.out.println("invalid");
		}
	}

	private static boolean decide(String ser, String firstSee, String secondSee) {
		String regex = (".*"+firstSee+".*"+secondSee+".*").replaceAll(" ", "");
		return ser.matches(regex);
	}

}
