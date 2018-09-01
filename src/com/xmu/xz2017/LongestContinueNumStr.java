package com.xmu.xz2017;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongestContinueNumStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.next();
		Pattern p = Pattern.compile("\\d{1,}");
		Matcher matcher = p.matcher(str);
		
		String res = "";
		while(matcher.find()){
            String temp = matcher.group();
            if(temp.length()>res.length())
            	res = temp;
        }
		System.out.println(res);
	}

}
