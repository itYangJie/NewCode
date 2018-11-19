package com.xmu.leetcode;

public class ReverseStr2 {
	public String reverseStr(String s, int k) {
        int len = s.length();
        StringBuffer sb = new StringBuffer();
        
        int count = 1+(len-1)/2/k;
        
        for(int i=0;i<count-1;i++){
            sb.append(new StringBuffer(s.substring(i*2*k,i*2*k+k)).reverse().toString());
            sb.append(s.substring(i*2*k+k,(i+1)*2*k));
        }
        
        int leaveStart = (count-1)*2*k;
        if(len-leaveStart<=k){
            sb.append(new StringBuffer(s.substring(leaveStart)).reverse().toString());
        }else{
            sb.append(new StringBuffer(s.substring(leaveStart,leaveStart+k)).reverse().toString());
            sb.append(s.substring(leaveStart+k));
        }
        
        return sb.toString();
    }
}
