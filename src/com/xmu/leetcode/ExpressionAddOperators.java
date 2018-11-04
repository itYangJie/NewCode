package com.xmu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	
	public List<String> addOperators(String num, int target) {
		List<String> rst = new ArrayList<>();
		if(num == null || num.length() == 0) 
			return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
	}

	private void helper(List<String> rst, String s, String num,
			int target, int pos, long eval, long mult) {
		if(pos==num.length()) {
			if(eval==target) {
				rst.add(s);
			}
			return;
		}
		for(int i=pos;i<num.length();i++) {
			if(i!=pos && num.charAt(pos)=='0')
				break;
			long cur = Long.parseLong(num.substring(pos, i+1));
			if(pos==0) {
				helper(rst,s+cur,num,target,i+1,cur,cur);
			}else {
				helper(rst,s+'+'+cur,num,target,i+1,eval+cur,cur);
				helper(rst,s+'-'+cur,num,target,i+1,eval-cur,-cur);
				helper(rst,s+'*'+cur,num,target,i+1,eval+(cur-1)*mult,mult*cur);
			}
		}
	}
}
