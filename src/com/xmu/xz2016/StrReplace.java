package com.xmu.xz2016;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrReplace {

	public static void main(String[] args) {
		System.out.println(formatString("A%sC%sE", 7, new char[] {'B','D'}));
	}
	 public static String formatString(String A, int n, char[] arg) {
		 Pattern p = Pattern.compile("%s");
		 Matcher matcher = p.matcher(A);
		 int count = 0;
		 while(matcher.find())
			 count++;
		 for(int i=0;i<count;i++)
			 A = A.replaceFirst("%s", arg[i]+"");
		 for(int i=count;i<arg.length;i++)
			 A = A+arg[i];
		 return A;
	 }
}
