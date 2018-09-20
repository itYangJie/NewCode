package com.xmu.xz2016;

import java.util.Arrays;

public class GenerateGrayCode {

	public static void main(String[] args) {
		GenerateGrayCode ggc = new GenerateGrayCode();
		System.out.println(Arrays.toString(ggc.getGrayByRecursive(4)));

	}
	public String[] getGray(int n) {
        
		int totalNum = (int) Math.pow(2, n);
		String[] strs = new String[totalNum];
		
		for(int i=0;i<totalNum;i++) {
			String str = "";
			for(int j=0;j<n;j++) {
				int ind = i%(int)Math.pow(2, n-j+1)/(int)Math.pow(2, n-j-1);
				if(ind==0 || ind==3)
					str = str+"0";
				else
					str = str+"1";
			}
			strs[i] = str;
		}
		return strs;
    }
	public String[] getGrayByRecursive(int n) {
        
		if(n==1)
			return new String[] {"0","1"};
		String[] temp = getGrayByRecursive(n-1);
		int len = temp.length;
		String[] strs = new String[2*len];
		for(int i=0;i<len;i++) {
			strs[i] = "0"+temp[i];
		}
		for(int i=0;i<len;i++) {
			strs[i+len] = "1"+temp[len-1-i];
		}
		return strs;
    }
}
