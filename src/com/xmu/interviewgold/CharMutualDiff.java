package com.xmu.interviewgold;


public class CharMutualDiff {

	public static void main(String[] args) {

	}
	public boolean checkDifferent(String iniString) {
		return !iniString.matches(".*(.).*\\1.*");
    }
}
