package com.xmu.swordoffer;

import java.util.ArrayList;

public class SeqSum {
	public static void main(String[] args) {
		FindContinuousSequence(100);
	}
	public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > res = new ArrayList();
        int left=1,right=2;
        while(left<right){
            int cur =  (right + left) * (right - left + 1) / 2;
            if(cur<sum)
                right++;
            else if(cur>sum)
                left++;
            else{
               ArrayList<Integer> temp = new ArrayList();
                for(int i=left;i<=right;i++)
                    temp.add(i);
                res.add(temp);
                left++;
                right++;
            }
        }
        return res;
    }
}
