package com.xmu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinWatch {
	public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList();
        for(int h=0;h<16;h++){
            int hOneCount = Integer.bitCount(h);
            for(int m=0;m<60;m++){
            	if(hOneCount+Integer.bitCount(m)==num) {
            		String time = h+":"+(m<10?"0"+m:m);
            		res.add(time);
            	}
            }
        }
        return res;
    }
}
