package com.xmu.swordoffer;

import java.util.ArrayList;

public class AdjustAarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void reOrderArray(int [] array) {
        if(array.length<=1)
            return;
        ArrayList<Integer> odds = new ArrayList();
        ArrayList<Integer> evens = new ArrayList();
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0)
                evens.add(array[i]);
            else
                odds.add(array[i]);
        }
        for(int i=0;i<odds.size();i++)
            array[i] = odds.get(i);
        for(int i=odds.size();i<array.length;i++)
            array[i] = evens.get(i-odds.size());
    }
}
