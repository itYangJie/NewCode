package com.xmu.interviewgold;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String zipString(String iniString) {
		StringBuffer sb = new StringBuffer();
		
		char[] chars = iniString.toCharArray();
		char curChar = chars[0];
		int count = 1;
		
		for(int i=1;i<chars.length;i++) {
			if(chars[i]==curChar)
				count++;
			else {
				sb.append(curChar+""+count);
				curChar = chars[i];
				count = 1;
			}
		}
		sb.append(curChar+""+count);
		String str = sb.toString();
		if(str.length()<iniString.length())
			return str;
		else
			return iniString;
					
    }
}
