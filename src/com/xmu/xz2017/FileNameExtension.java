package com.xmu.xz2017;

import java.util.Scanner;

public class FileNameExtension {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String path = in.nextLine();
		int index = path.lastIndexOf('.');
		if(index<0 || index>=path.length()-1)
			System.out.println("null");
		else
			System.out.println(path.substring(index+1));
	}

}
