package com.xmu.xz2016;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class ChkBloodType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String[] chkBlood(String father, String mother) {
        // write code here
        LinkedHashMap<String, String> map=new LinkedHashMap<>();
        map.put("O,O", "O");
        map.put("A,O", "A,O");
        map.put("A,A", "A,O");
        map.put("A,B", "A,B,AB,O");
        map.put("A,AB", "A,B,AB");
        map.put("B,O", "B,O");
        map.put("B,B", "B,O");
        map.put("B,AB", "A,B,AB");
        map.put("AB,O", "A,B");
        map.put("AB,AB", "A,B,AB");
        String s1=father+","+mother;
        String s2=mother+","+father;
        String str="";
        if(map.containsKey(s1))
            str=map.get(s1);
        else if(map.containsKey(s2))
            str=map.get(s2);
        String[] re=str.split(",");
        Arrays.sort(re);
        return re;
	}
}
