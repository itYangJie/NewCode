package com.xmu.swordoffer;

public class FirstAppearingOnce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Insert one char from stringstream
	int[] hashtable = new int[256];
	StringBuilder sc = new StringBuilder();

	public void Insert(char ch) {
		sc.append(ch);
		if (hashtable[ch] == 0) {
			hashtable[ch] = 1;
		} else {
			hashtable[ch] += 1;
		}
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		char[] str = sc.toString().toCharArray();
		for (char s : str) {
			if (hashtable[s] == 1) {
				return s;
			}
		}
		return '#';
	}
}
